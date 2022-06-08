<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guico
  Date: 2022/6/1
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">

    <title>登录</title>
    <style>
        *{
            /* 初始化 */
            margin: 0;
            padding: 0;
        }
        body{
            /* 100%窗口高度 */
            height: 100vh;
            /* 弹性布局 居中 */
            display: flex;
            justify-content: center;
            align-items: center;
            /* 渐变背景 */
            background: linear-gradient(200deg,#e3c5eb,#a9c1ed);
            /* 溢出隐藏 */
            overflow: hidden;
        }
        .container{
            /* 相对定位 */
            position: relative;
            z-index: 1;
            background-color: #fff;
            border-radius: 15px;
            /* 弹性布局 垂直排列 */
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 350px;
            height: 500px;
            /* 阴影 */
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
        }
        .container .tit{
            font-size: 26px;
            margin: 65px auto 70px auto;
        }
        .container input{
            width: 280px;
            height: 30px;
            text-indent: 8px;
            border: none;
            border-bottom: 1px solid #ddd;
            outline: none;
            margin: 12px auto;
        }
        .container button{
            width: 280px;
            height: 40px;
            margin: 35px auto 40px auto;
            border: none;
            background: linear-gradient(-200deg,#fac0e7,#aac2ee);
            color: #fff;
            font-weight: bold;
            letter-spacing: 8px;
            border-radius: 10px;
            cursor: pointer;
            /* 动画过渡 */
            transition: 0.5s;
        }
        .container button:hover{
            background: linear-gradient(-200deg,#aac2ee,#fac0e7);
            background-position-x: -280px;
        }
        .container span{
            font-size: 14px;
        }
        .container a{
            color: plum;
            text-decoration: none;
        }
        .error{
            color: red;
            font-size: 12px;
            margin: 0 auto;
        }


    </style>
</head>

<body>
<div class="container">
    <div class="tit">登录</div>
    <input type="text" placeholder="账号" id="username">
    <input type="password" placeholder="密码" id="password">
    <button id="login">登录</button>
    <span class="error"></span>
</div>

<script>
    //点击登录按钮后，检查表单是否合法，生产一个提交到/checkLogin的form表单，并且提交
    document.getElementById("login").onclick=function (){
        var username=document.getElementById("username").value;
        var password=document.getElementById("password").value;
        if(username===""||password===""){
            document.querySelector(".error").innerHTML="账号或密码不能为空";
        } else{
            var form=document.createElement("form");
            form.action="/checkLogin";
            form.method="post";
            var input1=document.createElement("input");
            input1.type="hidden";
            input1.name="username";
            input1.value=username;
            var input2=document.createElement("input");
            input2.type="hidden";
            input2.name="password";
            input2.value=password;
            form.appendChild(input1);
            form.appendChild(input2);
            document.body.appendChild(form);
            form.submit();
        }
    }
</script>
</body>
</html>
