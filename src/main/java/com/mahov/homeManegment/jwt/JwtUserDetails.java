package com.mahov.homeManegment.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahov.homeManegment.domain.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final Long id;
    private final String login;

    @JsonIgnore
    private final String password;

    private final List<? extends GrantedAuthority> grantedAuthorities;

    public JwtUserDetails(Long id, String login, String password, List<? extends GrantedAuthority> grantedAuthorities) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
    }

    public static JwtUserDetails build(User person) {
        List<GrantedAuthority> authorities = person.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new JwtUserDetails(
                person.getId(),
                person.getLogin(),
                new String(person.getPassword()),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    public Long getId() {
        return id;
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
