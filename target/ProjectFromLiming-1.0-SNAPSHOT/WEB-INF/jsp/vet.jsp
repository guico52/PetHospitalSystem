<%@ page import="com.guico.pojo.Vet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.guico.pojo.Spec" %>
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
</head>
<body>
<%
    List<Spec> specs = (List<Spec>) request.getAttribute("specs");
%>
<button id="back-button"></button>
<label for="back-button" class="back-button"><i class="fa fa-arrow-left" aria-hidden="true"></i></label>

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
<script>
    //点击返回按钮，返回上一页，并不能通过历史返回
    document.getElementById("back-button").onclick = function () {
        history.back();
    };
</script>
</body>
</html>