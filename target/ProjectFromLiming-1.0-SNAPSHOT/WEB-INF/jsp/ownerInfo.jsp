<%@ page import="com.guico.pojo.PetOwner" %><%--
  Created by IntelliJ IDEA.
  User: guico
  Date: 2022/6/4
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/ownerInfo_css" rel="stylesheet">
    <link rel="stylesheet" href="/direct_css">
</head>
<body>
<%
    PetOwner owner = (PetOwner)request.getSession().getAttribute("owner");
    System.out.println(owner);
%>
<div class="direct">
    <a href="/client">首页</a>
    <a href="/vet">兽医</a>
    <a href="/pet">宠物</a>
    <a href="/type">类型</a>
    <a href="/logout">退出</a>
</div>
<div class="update-petOwner-box">
    <form action="/updatePetOwner" id="updateOwner">
        <h3>主人信息</h3>
        <input type="hidden" name="ownerId" id="ownerId" value="<%=owner.getPetOwnerId()%>">
        <div class="ownerName-box">
            <label for="ownerName">主人姓名</label>
            <input type="text" id="ownerName" name="ownerName" class="ownerName" value="<%=owner.getPetOwnerName()%>">
        </div>
        <div class="ownerAddress-box">
            <label for="ownerAddress">主人地址</label>
            <input type="text" id="ownerAddress" name="ownerAddress" class="ownerAddress" value="<%=owner.getPetOwnerAddress()%>">
        </div>
        <div class="ownerCity-box">
            <label for="ownerCity">主人城市</label>
            <input type="text" id="ownerCity" name="ownerCity" class="ownerCity" value="<%=owner.getPetOwnerCity()%>">
        </div>
        <div class="ownerPhone-box">
            <label for="ownerPhone">主人电话</label>
            <input type="text" id="ownerPhone" name="ownerPhone" class="ownerPhone" value="<%=owner.getPetOwnerTelNo()%>">
        </div>
        <button type="submit" id="updatePetOwner">修改</button>
        <button type="button" id="addOwner">添加</button>
        <div class="error-box">
            <p class="error" id="error1"></p>
        </div>
    </form>
</div>
<div class="insert-petOwner-box-background" id="background">
    <div class="insert-petOwner-box">
        <h3>添加信息</h3>
        <form id="insertForm" action="/insertPetOwner">
            <input type="hidden" name="id2" id="id2">
            <div class="ownerName-box">
                <label for="ownerName2">主人姓名</label>
                <input type="text" id="ownerName2" name="ownerName2" class="ownerName2">
            </div>
            <div class="ownerAddress-box">
                <label for="ownerAddress2">主人地址</label>
                <input type="text" id="ownerAddress2" name="ownerAddress2" class="ownerAddress2">
            </div>
            <div class="ownerCity-box">
                <label for="ownerCity2">主人城市</label>
                <input type="text" id="ownerCity2" name="ownerCity2" class="ownerCity2">
            </div>
            <div class="ownerPhone-box">
                <label for="ownerPhone2">主人电话</label>
                <input type="text" id="ownerPhone2" name="ownerPhone2" class="ownerPhone2">
            </div>
            <button type="submit" id="insertPetOwner">添加</button>
            <button type="button" id="cancel">取消</button>
            <div class="error-box">
                <p class="error" id="error2"></p>
            </div>
        </form>
    </div>
</div>
<script>
    //点击addOwner按钮后，隐藏ownerInfoTable，显示addOwnerTable
    document.getElementById("addOwner").onclick=function (){
        document.getElementById("background").style.clipPath="circle(75% at center)";
    };
    //点击cancelAddOwner按钮后，隐藏addOwnerTable，显示ownerInfoTable
    document.getElementById("cancel").onclick=function (){
        document.getElementById("background").style.clipPath="circle(0% at center)";
    }

    //点击updatePetOwner按钮后，检查表单，如果表单不合法则不提交表单
    document.getElementById("updatePetOwner").onclick=function (){
        var ownerName = document.getElementById("ownerName").value;
        var ownerAddress = document.getElementById("ownerAddress").value;
        var ownerCity = document.getElementById("ownerCity").value;
        var ownerPhone = document.getElementById("ownerPhone").value;
        if(ownerName===""||ownerAddress===""||ownerCity===""||ownerPhone===""){
            document.getElementById("error1").innerHTML="请填写完整信息";
            return false;
        }
        else{
            return true;
        }
    }
    //    点击insertPetOwner按钮后，检查updateForm表单，表单不合法则不提交
    document.getElementById("insertPetOwner").onclick=function (){
        var ownerName = document.getElementById("ownerName2").value;
        var ownerAddress = document.getElementById("ownerAddress2").value;
        var ownerCity = document.getElementById("ownerCity2").value;
        var ownerPhone = document.getElementById("ownerPhone2").value;
        if(ownerName===""||ownerAddress===""||ownerCity===""||ownerPhone===""){
            document.getElementById("error2").innerHTML="请填写完整信息";
            return false;
        }
        else{
            return true;
        }
    }
</script>
</body>
</html>
