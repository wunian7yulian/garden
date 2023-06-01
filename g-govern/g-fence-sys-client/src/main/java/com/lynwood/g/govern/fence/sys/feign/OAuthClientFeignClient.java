package com.lynwood.g.govern.fence.sys.feign;

import com.lynwood.g.base.soi.common.model.R;
import com.lynwood.g.govern.fence.sys.dto.OAuth2ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author： Lynwood
 */
@FeignClient(value = "g-fence-sys-server", contextId = "g-fence-sys-server-oauth-client")
public interface OAuthClientFeignClient {

    @GetMapping("/api/oauth-client/get")
    R<OAuth2ClientDTO> getOAuth2ClientById(@RequestParam String clientId);
}
