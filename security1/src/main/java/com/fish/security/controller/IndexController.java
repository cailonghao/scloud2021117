package com.fish.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/noLogin")
    public String login(HttpServletRequest request) {
        AuthenticationException exception = (AuthenticationException) request.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        return "please login"+exception.getMessage();
    }

    @RequestMapping("/noAuth")
    public String noAuth() {
        return "no auth";
    }

    @RequestMapping("/auth")
    public String auth() {
        return "login success";
    }

    @RequestMapping("/authSucc")
    public String authSucc() {
        return "auth authSucc";
    }

    @RequestMapping("/needRoleUser")
    public String needRoleUser() {
        return "has role user";
    }

    @RequestMapping("/needRoleAdmin")
    public String needRoleAdmin() {
        return "has role user";
    }

    @ResponseStatus(code = HttpStatus.NON_AUTHORITATIVE_INFORMATION)
    @RequestMapping("/error")
    public String error(HttpServletRequest request) {
        AccessDeniedException errorMsg = (AccessDeniedException) request.getAttribute("SPRING_SECURITY_403_EXCEPTION");
        return errorMsg.getMessage();
    }

}
