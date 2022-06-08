<%--
  Created by IntelliJ IDEA.
  User: guico
  Date: 2022/6/1
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">

    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/client_css" rel="stylesheet" type="text/css">
</head>
<body>
<input type="checkbox" id="menu_btn">
<label class="menu-btn" for="menu_btn">
    <i class="fa fa-bars" aria-hidden="true" style="align-self: center"></i>
</label>
<div class="con">
    <h1>欢迎来到宠物医院管理系统</h1>
    <h3>请点击左上角的按钮继续</h3>
</div>
<div class="wrapper">
    <ul class="menu">
        <li><a href="/vet">兽医页面</a></li>
        <li><a href="/pet">宠物界面</a></li>
        <li><a href="/type">添加宠物种类</a></li>
        <li><a href="/logout">退出</a></li>
    </ul>
</div>

</body>
</html>
