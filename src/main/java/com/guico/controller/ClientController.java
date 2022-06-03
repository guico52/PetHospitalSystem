package com.guico.controller;

import com.guico.pojo.Vet;
import com.guico.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

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

    @RequestMapping("/test")
    public void test(int id){
        System.out.println(vetMapper.selectById(id));
    }

//    兽医业务代码区域
//    跳转到vet页面
    @RequestMapping("/vet")
    public String  vet(HttpServletRequest request){
        List<Vet> vets = vetMapper.selectAll();
        request.setAttribute("vets",vets);
        for(Vet vet:vets)
            System.out.println(vet);
        return "vet";
    }
//    从请求中获取vetName,根据其获取兽医信息
//    感觉这个功能在前端可以用ajax实现，返回的字符串为GBK编码，所以需要转换
    @RequestMapping("/getSpecByVetName")
    @ResponseBody
    public String vetInfo(String vetName,HttpServletResponse res) throws UnsupportedEncodingException {
        res.setCharacterEncoding("UTF-8");
        Vet vet = vetMapper.selectByName(vetName);
        String name  = vet.getVetName();
        return name;

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
