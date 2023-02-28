<%@ page import="com.guico.dao.pojo.Vet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.guico.dao.pojo.Spec" %>
<%--
  Created by IntelliJ IDEA.
  User: guico
  Date: 2022/6/2
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/vet_css" rel="stylesheet">
    <link rel="stylesheet" href="/direct_css">
</head>
<body>
<%
    List<Spec> specs = (List<Spec>) request.getAttribute("specs");
%>
<div class="direct">
    <a href="/client">首页</a>
    <a href="/vet">兽医</a>
    <a href="/pet">宠物</a>
    <a href="/type">类型</a>
    <a href="/logout">退出</a>
</div>

<div class="search-box">
    <form action="/selectVets">
        <h3>查找兽医</h3>
        <input type="text" name="vetName" id="vetName" placeholder="兽医姓名">
        <select name="vetSpec" id="vetSpec">
            <option value="" disabled hidden selected>兽医专业</option>
            <%--循环specs，添加下拉框选项--%>
            <% for (Spec spec : specs) { %>
            <option value="<%= spec.getSpecId() %>"><%= spec.getSpecName() %></option>
            <% } %>
        </select>
        <input id="select-button" type="submit" value="查找">
    </form>
</div>
</body>
</html>