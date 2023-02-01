package com.example.study_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "helloworld"; //helloworld.html
    }

    @RequestMapping("/thymeleaf-test")
    public String thymeleafTest() {
        return "/thymeleaf-test";
    }
}
