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

    @RequestMapping("/vet_css")
    public String vet(){
        return "vet_css";
    }

    @RequestMapping("/vetRes_css")
    public String vetRes(){
        return "vetRes_css";
    }

    @RequestMapping("/pet_css")
    public String pet(){
        return "pet_css";
    }

    @RequestMapping("/test_css")
    public String test(){
        return "test_css";
    }

    @RequestMapping("/petInfo_css")
    public String petInfo(){
        return "petInfo_css";
    }

    @RequestMapping("/ownerInfo_css")
    public String ownerInfo(){
        return "ownerInfo_css";
    }

    @RequestMapping("/visit_css")
    public String visit(){
        return "visit_css";
    }

    @RequestMapping("/direct_css")
    public String direct(){
        return "direct_css";
    }

}
