package com.guico.controller;

import com.guico.service.EmpMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private EmpMapperImpl mapper;
//    返回登录页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    返回Client页面
    @RequestMapping("/client")
    public String client(){
        return "client";
    }

//    检查用户登录表单信息是否合法
    @RequestMapping("/checkLogin")
    public void checkLogin(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        检查用户名和密码是否合法，合法则跳转到Client页面，不合法alter提示用户名或密码错误，异常使用try catch捕获
        if(mapper.checkEmpLogin(username,password)){
            try {
                response.sendRedirect("/client");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try {
                response.getWriter().println("<script>alert('用户名或密码错误！');</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
