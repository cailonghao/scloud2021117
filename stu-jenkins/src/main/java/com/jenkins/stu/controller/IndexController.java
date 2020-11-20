package com.jenkins.stu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2020/11/20 10:31
 * @Created by cai
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public String   index() {
        return "index";
    }
}
