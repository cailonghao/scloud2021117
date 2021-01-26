package com.fish.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 权限信息
 */
@Slf4j
public class MyMetadataSource implements FilterInvocationSecurityMetadataSource {

    /**获取用户权限表*/
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        Map<String, Collection<ConfigAttribute>> map = new HashMap<>();
        List<ConfigAttribute> list = new ArrayList<>();
        list.add((ConfigAttribute) () -> "ROLE_USER");
        map.put("/user/index", list);
        FilterInvocation filterInvocation = (FilterInvocation) o;
        log.info("filterInvocation,{}", filterInvocation.getRequestUrl());
        if (isMatcherAllowedRequest(filterInvocation)) return null;
        HttpServletRequest request = filterInvocation.getRequest();
        String uri;
        AntPathRequestMatcher antPathRequestMatcher;
        for (String s : map.keySet()) {
            uri = s;
            antPathRequestMatcher = new AntPathRequestMatcher(uri);
            if (antPathRequestMatcher.matches(request)) {
                log.info("url:{}", map.get(uri));
                return map.get(uri);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    private boolean isMatcherAllowedRequest(FilterInvocation fi) {
        return allowedRequest().stream().map(AntPathRequestMatcher::new)
                .filter(requestMatcher -> requestMatcher.matches(fi.getHttpRequest()))
                .toArray().length > 0;
    }

    private List<String> allowedRequest() {
        return Arrays.asList("/login", "/css/**", "/fonts/**", "/js/**", "/scss/**", "/img/**");
    }
}
