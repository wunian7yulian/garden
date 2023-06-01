package com.lynwood.g.govern.fence.auth.config;

import com.lynwood.g.govern.fence.auth.security.details.client.ClientDetailsServiceImpl;
import com.lynwood.g.govern.fence.auth.security.details.users.MultiUsersBaseDetails;
import com.lynwood.g.govern.fence.auth.security.jwt.DydSysUserAuthenticationConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.util.*;

/**
 * @author： Lynwood
 */
@Component
@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final ClientDetailsServiceImpl clientDetailsService;

    /**
     * OAuth2客户端
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    /**
     * 配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // Token增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        tokenEnhancers.add(jwtAccessTokenConverter());
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);

        // 获取原有默认授权模式(授权码模式、密码模式、客户端模式、简化模式)的授权者
        List<TokenGranter> granterList = new ArrayList<>(Arrays.asList(endpoints.getTokenGranter()));

        CompositeTokenGranter compositeTokenGranter = new CompositeTokenGranter(granterList);
        endpoints
                .authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter())
                .tokenEnhancer(tokenEnhancerChain)
                .tokenGranter(compositeTokenGranter)
                .reuseRefreshTokens(true)
                .tokenServices(tokenServices(endpoints))
        ;
    }

    public DefaultTokenServices tokenServices(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        tokenEnhancers.add(jwtAccessTokenConverter());
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);

        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setTokenEnhancer(tokenEnhancerChain);
        return tokenServices;

    }

    @Autowired
    private DydSysUserAuthenticationConverter dydSysUserAuthenticationConverter;
    /**
     * 使用非对称加密算法对token签名
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter(){
            /**
             * 重写增强token的方法
             * 自定义返回相应的信息
             */
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                // 与登录时候放进去的UserDetail实现类一直查看link{SecurityConfiguration}
                MultiUsersBaseDetails usersBaseDetails = (MultiUsersBaseDetails) authentication.getUserAuthentication().getPrincipal();
                /* 自定义一些token属性 ***/
                final Map<String, Object> additionalInformation = new HashMap<>(18);
                String userName = usersBaseDetails.getUsername();
                Long userId = usersBaseDetails.getUserId();
                String nickname = usersBaseDetails.getNickname();
                additionalInformation.put("userName", userName);
                additionalInformation.put("userId", userId);
                additionalInformation.put("nickname",nickname);
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                return super.enhance(accessToken, authentication);
            }
        };
        converter.setKeyPair(keyPair());
        ((DefaultAccessTokenConverter) converter.getAccessTokenConverter())
                .setUserTokenConverter(dydSysUserAuthenticationConverter);
        return converter;
    }
    @Value("${spring.profiles.active}")
    private String env;

    /**
     * 密钥库中获取密钥对(公钥+私钥)
     */
    @Bean
    public KeyPair keyPair() {
        // keytool -genkey -alias jwt -keyalg RSA -keysize 1024 -keystore jwtdev.jks -validity 365
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(new ClassPathResource("jwt"+env+".jks"), "202208".toCharArray());
        KeyPair keyPair = factory.getKeyPair("jwt", "202208".toCharArray());
        return keyPair;
    }


}
