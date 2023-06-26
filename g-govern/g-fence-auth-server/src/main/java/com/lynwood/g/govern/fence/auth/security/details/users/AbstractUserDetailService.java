package com.lynwood.g.govern.fence.auth.security.details.users;

import com.lynwood.g.base.soi.common.enums.ResultCode;
import com.lynwood.g.govern.fence.auth.security.details.users.user.GUsersBaseDetails;
import com.lynwood.g.govern.fence.auth.security.enums.UserServerType;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/**
 * @Author Lynwood
 * @Date 2023/6/26
 * @Version 1.0
 */
public abstract class AbstractUserDetailService implements UserDetailsService {
    protected abstract UserServerType getUserServerType();

    @Override
    public GUsersBaseDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GUsersBaseDetails userDetails = getUserDetail(username);
        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException(ResultCode.USER_NOT_EXIST.getMsg());
        } else if (!userDetails.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }
        return userDetails;
    }

    protected Collection<SimpleGrantedAuthority> handleRoles(Set<String> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
    protected abstract GUsersBaseDetails getUserDetail(String username);
}
