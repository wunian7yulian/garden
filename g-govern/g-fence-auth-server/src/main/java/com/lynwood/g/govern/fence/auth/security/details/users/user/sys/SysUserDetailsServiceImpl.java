package com.lynwood.g.govern.fence.auth.security.details.users.user.sys;

import com.lynwood.g.base.soi.common.model.R;
import com.lynwood.g.govern.fence.auth.security.details.users.AbstractUserDetailService;
import com.lynwood.g.govern.fence.auth.security.details.users.user.GUsersBaseDetails;
import com.lynwood.g.govern.fence.auth.security.enums.PasswordEncoderType;
import com.lynwood.g.govern.fence.auth.security.enums.UserServerType;
import com.lynwood.g.govern.fence.sys.dto.UserAuthDTO;
import com.lynwood.g.govern.fence.sys.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author： Lynwood
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysUserDetailsServiceImpl extends AbstractUserDetailService {
    private final UserFeignClient userFeignClient;

    @Override
    public UserServerType getUserServerType() {
        return UserServerType.SYS_USER;
    }

    @Override
    protected GUsersBaseDetails getUserDetail(String username) {
        R<UserAuthDTO> result = userFeignClient.getUserByUsername(username);
        GUsersBaseDetails userDetails = null;
        if (R.isSuccess(result)) {
            UserAuthDTO user = result.getData();
            if (null != user) {
                userDetails = new GUsersBaseDetails();
                userDetails.setUserId(user.getUserId());
                userDetails.setUsername(user.getUsername());
                userDetails.setNickname(user.getNickname());
                userDetails.setAuthorities(handleRoles(user.getRoles()));
                userDetails.setEnabled(user.getStatus() == 1);
                userDetails.setPassword(PasswordEncoderType.BCRYPT.getPrefix() + user.getPassword());
                userDetails.setGroupId(userDetails.getGroupId());
            }
        }
        return  userDetails;
    }
}
