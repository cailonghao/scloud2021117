package com.fish.security.service;

import com.fish.security.pojo.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AuthDaoProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("自定义认证器2");
        log.info("token:{}-{}", authentication.getPrincipal(), authentication.getCredentials());
        List<GrantedAuthority> list = new ArrayList <>();
        list.add((GrantedAuthority) () -> "ROLE_USER");
        //TODO 认证
        return new UsernamePasswordAuthenticationToken("cainiao", 123456, list);
        //return super.authenticate(authentication);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
