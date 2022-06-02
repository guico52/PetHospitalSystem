package com.guico.controller;

import com.guico.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ClientController {

    @Autowired
    private PetMapperImpl petMapper;
    @Autowired
    private PetOwnerMapperImpl petOwnerMapper;
    @Autowired
    private PetVisitMapperImpl petVisitMapper;
    @Autowired
    private SpecMapperImpl specMapper;
    @Autowired
    private VetMapperImpl vetMapper;

//    兽医业务代码区域
//    跳转到vet页面
    @RequestMapping("/vet")
    public ModelAndView vet(){
        ModelAndView view = new ModelAndView("vet");
        view.addObject("vets", vetMapper.selectAll());
        return view;
    }
//    从请求中获取vetName,根据其获取兽医信息
//    感觉这个功能在前端可以用ajax实现
    @RequestMapping("/getVetByName")
    @ResponseBody
    public String vetInfo(String vetName){
        return vetMapper.selectByName(vetName).getSpecName();
    }



//    宠物主人业务区域

//    跳转到petOwner页面
    @RequestMapping("/petOwner")
    public String petOwner(){
        return "petOwner";
    }

//    宠物业务区域
//    跳转到pet页面
    @RequestMapping("/pet")
    public String pet(){
        return "pet";
    }

//    浏览历史区域
//    跳转到visit页面
    @RequestMapping("/visit")
    public String visit(){
        return "visit";
    }



}
