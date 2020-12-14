package com.fish.security.config;

import com.fish.security.pojo.Role;
import org.apache.commons.logging.Log;
import org.springframework.core.log.LogMessage;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 决策管理器
 * FilterSecurityInterceptor 为授权拦截器 invoke
 * AbstractSecurityInterceptor - beforeInvocation（） - afterInvocation（） - authenticateIfRequired（）
 */
@Component
public class MetadataSource implements FilterInvocationSecurityMetadataSource {

    public static List<Role> ROLES = new ArrayList<Role>(){
        {
            add(new MvcRequestMatcher());
            add(new Role("ROLE_ADMIN"));
            add(new Role("ROLE_ROOT"));
            add(new Role("ROLE_PROVIDER"));
        }
    };
    /**
     * @param o
     * @return
     * @throws IllegalArgumentException
     * @desc 获取受保护对象的权限合集
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation)o).getRequest();
        int count = 0;
        Iterator var4 = ROLES.iterator();

        while(var4.hasNext()) {
            Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry = (Map.Entry)var4.next();
            if (((RequestMatcher)entry.getKey()).matches(request)) {
                return (Collection)entry.getValue();
            }
        }

        return null;
    }

    /**
     * 获取所有安全对象的合集
     *
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 返回对象是否支持安全集合
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
