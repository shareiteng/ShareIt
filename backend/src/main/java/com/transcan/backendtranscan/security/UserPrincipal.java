package com.transcan.backendtranscan.security;

import com.transcan.backendtranscan.domain.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class UserPrincipal implements UserDetails {
    private UserInfo userInfo;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(UserInfo userInfo,Collection<? extends GrantedAuthority> authorities){
        this.userInfo=userInfo;
        this.authorities = authorities;
    }

    public static UserPrincipal create(UserInfo user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user,
                authorities
        );
    }

    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getUsername();
    }

    public String getEmail() {
        return userInfo.getEmail();
    }

    public Long getId() {
        return userInfo.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return true;
    }

}
