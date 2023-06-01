package com.lynwood.g.govern.fence.auth.security.details.users;

import com.github.xiaoymin.knife4j.core.util.CommonUtils;
import com.lynwood.g.base.soi.common.enums.ResultCode;
import com.lynwood.g.govern.fence.auth.security.details.users.user.SysUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 多用户体系
 */
@Service("multiUsersDetailsService")
@Slf4j
@RequiredArgsConstructor
public class MultiUsersDetailServiceImpl implements UserDetailsService {

    private final SysUserDetailsServiceImpl sysUserDetailsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return sysUserDetailsService.loadUserByUsername(username);
    }
}
