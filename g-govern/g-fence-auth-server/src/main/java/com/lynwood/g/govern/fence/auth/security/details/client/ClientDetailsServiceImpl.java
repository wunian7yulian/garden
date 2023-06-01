package com.lynwood.g.govern.fence.auth.security.details.client;

import com.lynwood.g.base.soi.common.model.R;
import com.lynwood.g.govern.fence.auth.security.enums.PasswordEncoderTypeEnum;
import com.lynwood.g.govern.fence.sys.dto.OAuth2ClientDTO;
import com.lynwood.g.govern.fence.sys.feign.OAuthClientFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author： Lynwood
 */
@Service
@RequiredArgsConstructor
public class ClientDetailsServiceImpl implements ClientDetailsService {
    private final OAuthClientFeignClient oAuthClientFeignClient;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        // 通过feign 调用admin服务获取client信息
        R<OAuth2ClientDTO> result = oAuthClientFeignClient.getOAuth2ClientById(clientId);
        if (R.ok().getCode().equals(result.getCode())) {
            OAuth2ClientDTO client = result.getData();
            BaseClientDetails clientDetails = new BaseClientDetails(
                    client.getClientId(),
                    client.getResourceIds(),
                    client.getScope(),
                    client.getAuthorizedGrantTypes(),
                    client.getAuthorities(),
                    client.getWebServerRedirectUri());
            clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + client.getClientSecret());
            clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
            clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());
            return clientDetails;
        } else {
            throw new NoSuchClientException(result.getMsg());
        }
    }
}
