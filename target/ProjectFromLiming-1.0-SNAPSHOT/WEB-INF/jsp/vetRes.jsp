<%@ page import="com.guico.dao.pojo.Vet" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: guico
  Date: 2022/6/11
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/vetRes_css" rel="stylesheet">
    <link rel="stylesheet" href="/direct_css">
</head>
<body>
<%
    List<Vet> vets = (List<Vet>)request.getAttribute("res");
%>
<div class="direct">
    <a href="/client">首页</a>
    <a href="/vet">兽医</a>
    <a href="/pet">宠物</a>
    <a href="/type">类型</a>
    <a href="/logout">退出</a>
</div>
<div class="msg-box">
    <table>
        <thead>
        <tr>
            <td><h3>医生姓名</h3></td>
            <td><h3>医生专业</h3></td>
        </tr>
        </thead>
        <tbody>
            <%
            for(Vet vet:vets){
            %>
            <tr>
                <td><%=vet.getVetName()%></td>
                <td><%=vet.getSpecName()%></td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
</div>
<script>
    //点击返回按钮，返回上一页
    document.getElementById("back-button").addEventListener("click",function(){
        window.history.back();
    });
</script>
</body>
</html>
