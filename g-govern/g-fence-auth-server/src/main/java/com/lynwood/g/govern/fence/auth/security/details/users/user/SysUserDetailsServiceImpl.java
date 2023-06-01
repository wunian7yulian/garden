package com.lynwood.g.govern.fence.auth.security.details.users.user;

import com.lynwood.g.base.soi.common.enums.ResultCode;
import com.lynwood.g.base.soi.common.model.R;
import com.lynwood.g.govern.fence.auth.security.enums.PasswordEncoderTypeEnum;
import com.lynwood.g.govern.fence.sys.dto.UserAuthDTO;
import com.lynwood.g.govern.fence.sys.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author： Lynwood
 */
@Service("sysUserDetailsService")
@Slf4j
@RequiredArgsConstructor
public class SysUserDetailsServiceImpl implements UserDetailsService {
    private final UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        R<UserAuthDTO> result = userFeignClient.getUserByUsername(username);
        SysUserDetails userDetails = null;
        if (R.ok().getCode().equals(result.getCode())) {
            UserAuthDTO user = result.getData();
            if (null != user) {
                userDetails = new SysUserDetails();
                userDetails.setUserId(user.getUserId());
                userDetails.setUsername(user.getUsername());
                userDetails.setNickname(user.getNickname());
                userDetails.setAuthorities(handleRoles(user.getRoles()));
                userDetails.setEnabled(user.getStatus() == 1);
                userDetails.setPassword(PasswordEncoderTypeEnum.BCRYPT.getPrefix() + user.getPassword());
            }
        }
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

    private Collection<SimpleGrantedAuthority> handleRoles(Set<String> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }


}
