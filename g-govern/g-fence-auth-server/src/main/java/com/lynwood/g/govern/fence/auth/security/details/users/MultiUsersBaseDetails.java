package com.lynwood.g.govern.fence.auth.security.details.users;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author： Lynwood
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultiUsersBaseDetails implements UserDetails {
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
