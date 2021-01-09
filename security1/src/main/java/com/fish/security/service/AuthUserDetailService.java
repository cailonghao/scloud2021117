package com.fish.security.service;

import com.fish.security.pojo.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class AuthUserDetailService implements UserDetailsService {

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        log.info("hello , world:{}",s);
        List<GrantedAuthority> list = new ArrayList<>();
        list.add((GrantedAuthority) () -> "ROLE_USER");
        Member member =  new Member.Builder().username("cainiao")
                .password(passwordEncoder.encode("123456"))
                .collection(list)
                .build();
        log.info(member.toString());
        return member;
    }
}
