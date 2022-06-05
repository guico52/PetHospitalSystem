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
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%
    PetOwner owner = (PetOwner)request.getSession().getAttribute("owner");
    System.out.println(owner);
%>
<form action="/updatePetOwner" id="updateOwner">
    <table id="ownerInfoTable" hidden="hidden">
        <input type="hidden" name="ownerId" id="ownerId" value="<%=owner.getPetOwnerId()%>">
        <tr>
            <td>主人姓名</td>
            <td><input type="text" name="ownerName" id="ownerName" value="<%=owner.getPetOwnerName()%>"></td>
            <td class="error" id="ownerNameError" hidden="hidden"></td>
        </tr>
        <tr>
            <td>主人地址</td>
            <td><input type="text" name="ownerAddress" id="ownerAddress" value="<%=owner.getPetOwnerAddress()%>"></td>
            <td class="error" id="ownerAddressError" hidden="hidden"></td>
        </tr>
        <tr>
            <td>主人城市</td>
            <td><input type="text" name="ownerCity" id="ownerCity" value="<%=owner.getPetOwnerCity()%>"></td>
            <td class="error" id="ownerCityError" hidden="hidden"></td>
        </tr>
        <tr>
            <td>主人电话</td>
            <td><input type="text" name="ownerPhone" id="ownerPhone" value="<%=owner.getPetOwnerTelNo()%>"></td>
            <td class="error" id="ownerPhoneError" hidden="hidden"></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改" id="updatePetOwner"></td>
            <td><button id="addOwner" type="button">添加</button></td>
        </tr>
    </table>
</form>

<form id="insertForm" action="/insertPetOwner">
    <table id="addOwnerTable" hidden="hidden">
        <input type="hidden" name="id2" id="id2" value="<%=owner.getPetOwnerId()%>">
        <tr>
            <td>主人姓名</td>
            <td><input type="text" id="ownerName2" name="ownerName2"></td>
            <td class="error" id="ownerNameError2" hidden="hidden"></td>
        </tr>
        <tr>
            <td>主人地址</td>
            <td><input type="text" id="ownerAddress2" name="ownerAddress2"></td>
            <td class="error" id="ownerAddressError2" hidden="hidden"></td>
        </tr>
        <tr>
            <td>主人城市</td>
            <td><input type="text" id="ownerCity2" name="ownerCity2"></td>
            <td class="error" id="ownerCityError2" hidden="hidden"></td>
        </tr>
        <tr>
            <td>主人电话</td>
            <td><input type="text" id="ownerPhone2" name="ownerPhone2"></td>
            <td class="error" id="ownerPhoneError2" hidden="hidden"></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加" id="insertPetOwner"></td>
            <td><button id="cancelAddOwner" type="button">取消</button></td>
        </tr>
    </table>
</form>
<script>
    //先不让ownerInfoTable隐藏，让addOwnerTable隐藏
    document.getElementById("ownerInfoTable").hidden = false;


    //点击updatePetOwner按钮后，检查表单，如果表单不合法则不提交表单
    document.getElementById("updatePetOwner").onclick=function (){
        var ownerName = document.getElementById("ownerName").value;
        var ownerAddress = document.getElementById("ownerAddress").value;
        var ownerCity = document.getElementById("ownerCity").value;
        var ownerPhone = document.getElementById("ownerPhone").value;
        var ownerNameError = document.getElementById("ownerNameError");
        var ownerAddressError = document.getElementById("ownerAddressError");
        var ownerCityError = document.getElementById("ownerCityError");
        var ownerPhoneError = document.getElementById("ownerPhoneError");
        if(ownerName == ""||ownerName == null){
            ownerNameError.hidden = false;
            ownerNameError.innerHTML = "主人姓名不能为空";
            return false;
        }
        if(ownerAddress == ""||ownerAddress == null){
            ownerAddressError.hidden = false;
            ownerAddressError.innerHTML = "主人地址不能为空";
            return false;
        }
        if(ownerCity == ""||ownerCity == null){
            ownerCityError.hidden = false;
            ownerCityError.innerHTML = "主人城市不能为空";
            return false;
        }
        if(ownerPhone == ""||ownerPhone == null){
            ownerPhoneError.hidden = false;
            ownerPhoneError.innerHTML = "主人电话不能为空";
            return false;
        }
    }
//    点击insertPetOwner按钮后，检查updateForm表单，表单不合法则不提交
    document.getElementById("insertPetOwner").onclick=function (){
        var ownerName = document.getElementById("ownerName2").value;
        var ownerAddress = document.getElementById("ownerAddress2").value;
        var ownerCity = document.getElementById("ownerCity2").value;
        var ownerPhone = document.getElementById("ownerPhone2").value;
        var ownerNameError = document.getElementById("ownerNameError2");
        var ownerAddressError = document.getElementById("ownerAddressError2");
        var ownerCityError = document.getElementById("ownerCityError2");
        var ownerPhoneError = document.getElementById("ownerPhoneError2");
        if(ownerName == ""||ownerName == null){
            ownerNameError.hidden = false;
            ownerNameError.innerHTML = "主人姓名不能为空";
            return false;
        }
        if(ownerAddress == ""||ownerAddress == null){
            ownerAddressError.hidden = false;
            ownerAddressError.innerHTML = "主人地址不能为空";
            return false;
        }
        if(ownerCity == ""||ownerCity == null){
            ownerCityError.hidden = false;
            ownerCityError.innerHTML = "主人城市不能为空";
            return false;
        }
        if(ownerPhone == ""||ownerPhone == null){
            ownerPhoneError.hidden = false;
            ownerPhoneError.innerHTML = "主人电话不能为空";
            return false;
        }
    }

//点击addOwner按钮后，隐藏ownerInfoTable，显示addOwnerTable
    document.getElementById("addOwner").onclick=function (){
        document.getElementById("ownerInfoTable").hidden = true;
        document.getElementById("addOwnerTable").hidden = false;
    }
//点击cancelAddOwner按钮后，隐藏addOwnerTable，显示ownerInfoTable
    document.getElementById("cancelAddOwner").onclick=function (){
        document.getElementById("addOwnerTable").hidden = true;
        document.getElementById("ownerInfoTable").hidden = false;
    }


</script>

</body>
</html>
