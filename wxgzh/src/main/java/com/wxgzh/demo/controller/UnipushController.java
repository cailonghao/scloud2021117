package com.wxgzh.demo.controller;

import com.unipush.TokenRequest;
import com.unipush.TokenResponse;
import com.unipush.UnipushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push")
public class UnipushController {

    @Autowired
    UnipushService unipushService;
    @RequestMapping("/test1.do")
    public void test1() throws Exception {
        TokenRequest request = new TokenRequest();
        TokenResponse token = unipushService.getToken();
    }
}
