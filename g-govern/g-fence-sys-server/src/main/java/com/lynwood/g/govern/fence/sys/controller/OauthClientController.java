package com.lynwood.g.govern.fence.sys.controller;

import cn.hutool.core.bean.BeanUtil;
import com.lynwood.g.base.rock.web.utils.AssertUtil;
import com.lynwood.g.base.soi.common.enums.ResultCode;
import com.lynwood.g.base.soi.common.model.R;
import com.lynwood.g.govern.fence.sys.dto.OAuth2ClientDTO;
import com.lynwood.g.govern.fence.sys.feign.OAuthClientFeignClient;
import com.lynwood.g.govern.fence.sys.pojo.entity.SysOauthClient;
import com.lynwood.g.govern.fence.sys.service.SysOauthClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： Lynwood
 */
@Slf4j
@AllArgsConstructor
@RestController
public class OauthClientController implements OAuthClientFeignClient {
    private final SysOauthClientService iSysOauthClientService;

    @Override
    public R<OAuth2ClientDTO> getOAuth2ClientById(@RequestParam String clientId) {
        SysOauthClient client = iSysOauthClientService.getById(clientId);
        AssertUtil.notEmpty(client, ResultCode.CLIENT_AUTHENTICATION_FAILED);
        OAuth2ClientDTO oAuth2ClientDTO = new OAuth2ClientDTO();
        BeanUtil.copyProperties(client, oAuth2ClientDTO);
        return R.ok(oAuth2ClientDTO);
    }
}
