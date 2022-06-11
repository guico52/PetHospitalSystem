package com.guico.controller;

import com.guico.pojo.Emp;
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

//    设置索引页
    @RequestMapping("/")
    public String index(){
        return "login";
    }

//    返回client
    @RequestMapping("/client")
    public String client(HttpServletResponse resp, HttpServletRequest req){
        if(req.getSession().getAttribute("emp") == null){
            try {
                System.out.println("未登录");
                resp.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("已登录,返回client");
        return "client";
    }


//    返回登录页面
    @RequestMapping("/login")
    public String login(){
        System.out.println("User login");
        return "login";
    }


//    检查用户登录表单信息是否合法
    @RequestMapping("/checkLogin")
    public void checkLogin(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + " password: " + password);

//        检查用户名和密码是否合法，合法则跳转到Client页面，不合法alter提示用户名或密码错误，异常使用try catch捕获
        if(mapper.checkEmpLogin(username,password)){
            //                将登录成功的emp对象放在session中，并跳转到Client页面
            Emp emp = mapper.selectEmpByName(username);
            request.getSession().setAttribute("emp",emp);
            System.out.println("User log in success");
            try {
                response.sendRedirect("/client");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try {
//                登录不合法，提示用户名或密码错误
//                response需要使用GBK编码，否则会出现乱码
                response.setContentType("text/html;charset=GBK");
//                提示用户名或密码错误，在用户点击确认后，跳转到登录页面
                response.getWriter().println("<script>alert('用户名或密码错误！');</script>");
                response.getWriter().println("<script>window.location.href='/login';</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    用户退出登录
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("emp");
        return "login";
    }
}
