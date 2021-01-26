package com.fish.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

@Slf4j
public class MyAccessDecisionManager  implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        log.info("授权处理");
        if(collection==null|| collection.size()==0){
            throw new AccessDeniedException("permission denied");
        }
        ConfigAttribute configAttribute;
        String needRole;
        for (Iterator<ConfigAttribute> it = collection.iterator();it.hasNext();){
            configAttribute = it.next();
            needRole  = configAttribute.getAttribute();
            log.info("decide: needRole:{}-auth:{}",needRole,authentication);
            for(GrantedAuthority grantedAuthority:authentication.getAuthorities()){
                if(needRole.equals(grantedAuthority.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("permission denied");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
