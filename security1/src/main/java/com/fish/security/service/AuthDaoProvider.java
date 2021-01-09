package com.fish.security.service;

import com.fish.security.pojo.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AuthDaoProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AuthToken authToken = (AuthToken) authentication;
        log.info("自定义认证器2");
        log.info("token:{}-{}-{}", authToken.getPrincipal(), authToken.getCredentials(), authToken.getCode());
        List<GrantedAuthority> list = new ArrayList <>();
        list.add((GrantedAuthority) () -> "ROLE_USER");
        //TODO 认证
        return new AuthToken("cainiao", 123456, list, "123456");
        //return super.authenticate(authentication);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthToken.class.isAssignableFrom(aClass);
    }
}
