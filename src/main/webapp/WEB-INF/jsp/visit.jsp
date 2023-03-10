<%@ page import="com.guico.dao.pojo.Pet" %>
<%@ page import="com.guico.dao.pojo.PetVisit" %>
<%@ page import="java.util.List" %>
<%@ page import="com.guico.dao.pojo.PetOwner" %><%--
  Created by IntelliJ IDEA.
  User: guico
  Date: 2022/6/2
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/visit_css"/>
    <link rel="stylesheet" href="/direct_css">
</head>
<body>
<%
    Pet pet = (Pet) session.getAttribute("pet");
    System.out.println(pet);
    List<PetVisit> visits = (List<PetVisit>) session.getAttribute("visits");
    List<PetOwner> owners = (List<PetOwner>) session.getAttribute("owners");
%>
<div class="direct">
    <a href="/client">首页</a>
    <a href="/vet">兽医</a>
    <a href="/pet">宠物</a>
    <a href="/type">类型</a>
    <a href="/logout">退出</a>
</div>
<div class="visit-table">
    <h3>病例信息</h3>
    <table class="visitTable">
        <thead>
        <tr>
            <td>诊断时间</td>
            <td>备注</td>
        </tr>
        </thead>
        <tbody>
        <%
        for (PetVisit visit : visits) {
        %>
        <tr>
            <td><%= visit.getPetVisitDate() %></td>
            <td><%= visit.getPetVisitDescription() %></td>
        </tr>
        <%
        }
        %>
        </tbody>
        <tfoot>
        <tr>
            <td><button id="addVisit">添加病例</button></td>
        </tr>
        </tfoot>
    </table>
</div>
<div class="msg-background" id="msg-background">
    <div class="msg-box">
        <form action="/insertVisit" class="visit-form">
            <h3>添加病例</h3>
            <input type="hidden" id="petId" name="petId" value="<%=pet.getId()%>">
            <div class="petName-box">
                <label for="petName">宠物名称</label>
                <input type="text" id="petName" class="petName" name="petName" disabled="disabled" value="<%=pet.getName()%>">
            </div>
            <div class="petOwnerName-box">
                <label for="petOwnerName">主人姓名</label>
                <input type="text" id="petOwnerName" class="petOwnerName" name="petOwnerName" disabled="disabled" value="<%=pet.getOwnerName()%>">
            </div>
            <div class="petTypeName-box">
                <label for="petTypeName">宠物种类</label>
                <input  type="text" id="petTypeName" class="petTypeName" name="petTypeName" disabled="disabled" value="<%=pet.getTypeName()%>">
            </div>
            <div class="petVisitDate-box">
                <label for="petVisitDate">诊断时间</label>
                <input type="datetime-local" id="petVisitDate" class="petVisitDate" name="petVisitDate">
            </div>
            <div class="petVisitDesc-box">
                <label for="petVisitDesc">描述</label>
                <input id="petVisitDesc" class="petVisitDesc" name="petVisitDesc">
            </div>
            <div class="petVisitControl-box">
                <button type="submit" id="submit">添加</button>
                <button type="button" id="cancel">返回</button>
            </div>
            <div class="input-error"><p class="error"></p></div>
        </form>

    </div>
</div>
<script>
    document.getElementById("addVisit").onclick = function(){
        document.getElementById("msg-background").style.clipPath = "circle(75% at center)";
    };
    document.getElementById("cancel").onclick = function(){
        document.getElementById("msg-background").style.clipPath = "circle(0% at center)";
    };
    //    表单提交前检查输入
    document.getElementById("submit").onclick = function (){
        var petId = document.getElementById("petId").value;
        var petVisitDate = document.getElementById("petVisitDate").value;
        var petVisitDesc = document.getElementById("petVisitDesc").value;
        var error = document.getElementsByClassName("error")[0];
        if(petVisitDate === ""||petVisitDesc === ""){
            error.innerHTML = "请输入完整信息";
            return false;
        }
    }

</script>

</body>
</html>
