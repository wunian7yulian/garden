package com.lynwood.g.govern.fence.sys.feign;

import com.lynwood.g.base.soi.common.model.R;
import com.lynwood.g.govern.fence.sys.dto.UserAuthDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * !!!!!!! 除auth/admin 服务其他禁用
 * @author： Lynwood
 */

@FeignClient(value = "g-fence-sys-server",contextId = "g-fence-sys-server-user")
public interface UserFeignClient {

    @GetMapping("/api/user/get")
    R<UserAuthDTO> getUserByUsername(@RequestParam String username);
}
