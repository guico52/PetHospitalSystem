package com.guico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CssController {

    @RequestMapping("/client_css")
    public String client(){
        return "client_css";
    }

    @RequestMapping("/login_css")
    public String login(){
        return "login_css";
    }
}
