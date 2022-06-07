package com.guico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CssController {
    @RequestMapping("/css")
    public String css(){
        return "total";
    }
}
