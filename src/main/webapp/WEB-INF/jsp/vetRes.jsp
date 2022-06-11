<%@ page import="com.guico.pojo.Vet" %>
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

</head>
<body>
<%
    List<Vet> vets = (List<Vet>)request.getAttribute("res");
%>
<button id="back-button"></button>
<label for="back-button" class="back-button"><i class="fa fa-arrow-left" aria-hidden="true"></i></label>
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
