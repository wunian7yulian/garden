package com.lynwood.g.govern.fence.auth.security.details.users.user;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author： Lynwood
 */
@Getter
@Setter
public class GUsersBaseDetails implements UserDetails {
    /**
     * 扩展字段
     */
    private Long userId;
    /**
     * 默认字段
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    private String password;
    private Boolean enabled;

    private Long groupId;

    private Collection<? extends GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }


}
