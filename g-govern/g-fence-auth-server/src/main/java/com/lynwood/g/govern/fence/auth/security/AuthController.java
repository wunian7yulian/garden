package com.lynwood.g.govern.fence.auth.security;

import com.lynwood.g.base.soi.common.model.R;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： Lynwood
 */
@Api(tags = "认证相关接口")
@RestController
@RequestMapping("/oauth")
@Slf4j
public class AuthController {

    @Autowired
    private KeyPair keyPair;

    @Autowired
    private TokenEndpoint tokenEndpoint;


    @ApiOperation(value = "登录/刷新", notes = "登录/刷新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", value = "grant_type", defaultValue = "password", example = "password"),
            @ApiImplicitParam(name = "refresh_token", value = "refresh_token"),
            @ApiImplicitParam(name = "username", value = "用户名", example = "wunian_@hotmail.com"),
            @ApiImplicitParam(name = "password", value = "密码 md32 小写", example = "5690dddfa28ae085d23518a035707282")
    })
    @PostMapping("/token")
    public Object postAccessToken(
            @ApiIgnore Principal principal,
            @ApiIgnore @RequestParam Map<String, String> parameters
    ) throws Exception {
        return R.ok(tokenEndpoint.postAccessToken(principal, this.getFinalParam(parameters)).getBody());
    }

    @ApiIgnore
    @GetMapping("/public-key")
    public Map<String, Object> getPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }


    /**
     * 获取最终用户认证包体
     *
     * @param parameters
     * @return
     */
    private Map<String, String> getFinalParam(Map<String, String> parameters) {
        Map<String, String> parametersFinal = new HashMap<>();
        parametersFinal.put("grant_type", parameters.get("grant_type"));
        parametersFinal.put("password", parameters.get("password"));
        parametersFinal.put("username", parameters.get("username"));
        parametersFinal.put("refresh_token", parameters.get("refresh_token"));
        return parametersFinal;
    }

}
