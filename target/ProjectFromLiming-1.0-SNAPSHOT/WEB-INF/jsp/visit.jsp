<%@ page import="com.guico.pojo.Pet" %>
<%@ page import="com.guico.pojo.PetVisit" %>
<%@ page import="java.util.List" %>
<%@ page import="com.guico.pojo.PetOwner" %><%--
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
</head>
<body>
<%
    Pet pet = (Pet) session.getAttribute("pet");
    System.out.println(pet);
    List<PetVisit> visits = (List<PetVisit>) session.getAttribute("visits");
    List<PetOwner> owners = (List<PetOwner>) session.getAttribute("owners");
%>
<div id="msg" hidden="hidden">
    <table>
        <tr>
            <td>
                <label>宠物名称</label>
                <input type="text" value="<%=pet.getName()%>">
            </td>
            <td>
                <label>宠物种类</label>
                <input type="text" value="<%=pet.getTypeName()%>">
            </td>
            <td>
                <lable>主人姓名</lable>
                <input type="text" value="<%=pet.getOwnerName()%>">
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td>诊断时间</td>
            <td>备注</td>
        </tr>
        <%
            for(PetVisit visit:visits){
        %>
        <tr>
            <td><%=visit.getPetVisitDate()%></td>
            <td><%=visit.getPetVisitDescription()%></td>
        </tr>
        <%
            }
        %>
    </table>
    <buton id="addVisit">添加病例</buton>
</div>

<form id="addVisitForm" action="/insertVisit">
    <table>
        <td><input type="text" id="petId" name="petId" value="<%=pet.getId()%>" hidden="hidden"></td>
        <tr>
            <td>宠物名称</td>
            <td><input type="text" id="petName" name="petName" value="<%=pet.getName()%>" disabled="disabled"></td>
        </tr>
        <tr>
            <td>主人名称</td>
            <td>
                <input type="text" id="ownerName" name="ownerName" value="<%=pet.getOwnerName()%>" disabled="disabled">
            </td>
        </tr>
        <tr>
            <td>宠物类型</td>
            <td><input type="text" id="petTypeName" name="petTypeName" disabled="disabled" value="<%=pet.getTypeName()%>"></td>
        </tr>
        <tr>
            <td>诊断时间</td>
            <td><input type="datetime-local" id="petVisitDate" name="petVisitDate"></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><textarea id="petVisitDesc" name="petVisitDesc"></textarea></td>
        </tr>
    </table>
    <input type="submit" value="增加">
    <button type="button" id="cancel">返回</button>
    <input type="reset" value="清空">
</form>

<table>
    <tr>
        <td>诊断时间</td>
        <td>备注</td>
    </tr>
    <%
        for(PetVisit visit:visits){
    %>
    <tr>
        <td><%=visit.getPetVisitDate()%></td>
        <td><%=visit.getPetVisitDescription()%></td>
    </tr>
    <%
        }
    %>
</table>

<script>
    //点击添加病例按钮，隐藏添加病例表单，显示添加病例表单
    document.getElementById("addVisit").onclick = function () {
        document.getElementById("msg").hidden = true;
        document.getElementById("addVisitForm").hidden = false;
    };

    //点击返回按钮，返回到petInfo.jsp
    document.getElementById("cancel").onclick = function () {
        window.location.href = "/petInfo?petId=<%=pet.getId()%>";
    };
</script>

</body>
</html>
