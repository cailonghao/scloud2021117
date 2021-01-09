package com.fish.security.pojo;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthToken extends UsernamePasswordAuthenticationToken {

    private String code;

    public AuthToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public AuthToken(Object principal, Object credentials, String code) {
        super(principal, credentials);
        this.code = code;
    }

    public AuthToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public AuthToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String code) {
        super(principal, credentials, authorities);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
