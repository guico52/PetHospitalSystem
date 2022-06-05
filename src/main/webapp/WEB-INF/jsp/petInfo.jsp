<%@ page import="com.guico.pojo.Pet" %>
<%@ page import="com.guico.pojo.Type" %>
<%@ page import="com.guico.pojo.PetOwner" %>
<%@ page import="java.util.List" %><%--
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
        .error{
            color: red;
        }
    </style>
</head>
<body>
<%
    Pet pet= (Pet)request.getSession().getAttribute("pet");
    String birthday=pet.getBirthDate();
    birthday=birthday.substring(0,10)+"T"+birthday.substring(11,16);
    pet.setBirthDate(birthday);
    List<Type> types = (List<Type>)request.getSession().getAttribute("types");
    List<PetOwner> owners = (List<PetOwner>)request.getSession().getAttribute("owners");
%>
<table>
    <tr>
        <td>宠物名称</td>
        <td><input type="text" id="petName" name="petName" value="<%=pet.getName()%>"></td>
        <td class="error" id="petNameError"></td>
    </tr>
    <tr>
        <td>宠物类型</td>
        <td><select name="petType" id="petType">
            <%
            for(Type type:types){
                if(type.getTypeId()==pet.getTypeId()){
                    %>
                    <option value="<%=type.getTypeId()%>" selected="selected"><%=type.getTypeName()%></option>
                    <%
                }else{
                    %>
                    <option value="<%=type.getTypeId()%>"><%=type.getTypeName()%></option>
                    <%
                }
            }
            %>
        </select></td>
        <td class="error"></td>
    </tr>
    <tr>
        <td>出生日期</td>
        <td><input type="datetime-local" id="petBirthDate" name="petBirthDate" value="<%=pet.getBirthDate()%>"></td>
        <td class="error" id="petBirthDateError"></td>
    </tr>
    <tr>
        <td>主人姓名</td>
        <td><select name="petOwnerName" id="petOwnerName">
            <%
            for(PetOwner owner:owners){
                if(owner.getPetOwnerId()==pet.getOwnerId()){
                    %>
                    <option value="<%=owner.getPetOwnerId()%>" selected="selected"><%=owner.getPetOwnerName()%></option>
                    <%
                }else{
                    %>
                    <option value="<%=owner.getPetOwnerId()%>"><%=owner.getPetOwnerName()%></option>
                    <%
                }
            }
            %>
        </select></td>
        <td class="error" id="petOwnerNameError"></td>
    </tr>
</table>
<button id="updatePet" hidden="hidden">修改</button>
<button id="insertPet" hidden="hidden">添加</button>
<button id="insert" hidden="hidden">添加信息</button>
<button id="cancel" hidden="hidden">取消</button>
<button id="visit">浏览病例</button>
<script>
    var petId = "<%=pet.getId()%>";
    document.getElementById("updatePet").hidden=false;
    document.getElementById("insertPet").hidden=false;

//    点击修改按钮，检查输入信息，信息合法则将参数信息发送给"/updatePet"
    document.getElementById("updatePet").onclick = function () {
        var petName = document.getElementById("petName").value;
        var petType = document.getElementById("petType").value;
        var petBirthDate = document.getElementById("petBirthDate").value;
        var petOwnerName = document.getElementById("petOwnerName").value;
        var petNameError = document.getElementById("petNameError");
        var petBirthDateError = document.getElementById("petBirthDateError");
        var petOwnerNameError = document.getElementById("petOwnerNameError");
        var error = false;
        if (petName === "") {
            petNameError.innerHTML = "宠物名称不能为空";
            error = true;
        } else {
            petNameError.innerHTML = "";
        }
        if (petBirthDate == "") {
            petBirthDateError.innerHTML = "出生日期不能为空";
            error = true;
        } else {
            petBirthDateError.innerHTML = "";
        }
        if (petOwnerName == "") {
            petOwnerNameError.innerHTML = "主人姓名不能为空";
            error = true;
        } else {
            petOwnerNameError.innerHTML = "";
        }
        if (error) {
            return;
        }
        var form = document.createElement("form");
        form.action = "/updatePet";
        form.method = "post";
        var input = document.createElement("input");
        input.type = "hidden";
        input.name = "petId";
        input.value = petId;
        form.appendChild(input);
        input = document.createElement("input");
        input.type = "hidden";
        input.name = "petName";
        input.value = petName;
        form.appendChild(input);
        input = document.createElement("input");
        input.type = "hidden";
        input.name = "petType";
        input.value = petType;
        form.appendChild(input);
        input = document.createElement("input");
        input.type = "hidden";
        input.name = "petBirthDate";
        input.value = petBirthDate;
        form.appendChild(input);
        input = document.createElement("input");
        input.type = "hidden";
        input.name = "petOwnerName";
        input.value = petOwnerName;
        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();
    }

//    点击添加按钮，清空输入信息，修改按钮隐藏属性
    document.getElementById("insertPet").onclick = function () {
        document.getElementById("petName").value = "";
        document.getElementById("petType").value = "";
        document.getElementById("petBirthDate").value = "";
        document.getElementById("petOwnerName").value = "";
        document.getElementById("updatePet").hidden=true;
        document.getElementById("insertPet").hidden=true;
        document.getElementById("insert").hidden=false;
        document.getElementById("cancel").hidden=false;
    }

//    点击取消按钮，隐藏取消按钮和添加信息按钮，并恢复输入信息
    document.getElementById("cancel").onclick = function () {
        document.getElementById("updatePet").hidden=false;
        document.getElementById("insertPet").hidden=false;
        document.getElementById("cancle").hidden=true;
        document.getElementById("insert").hidden=true;
        document.getElementById("petName").value = "<%=pet.getName()%>";
        document.getElementById("petType").value = "<%=pet.getTypeId()%>";
        document.getElementById("petBirthDate").value = "<%=pet.getBirthDate()%>";
        document.getElementById("petOwnerName").value = "<%=pet.getOwnerId()%>";
    }

//    点击添加信息按钮，检查输入信息，信息合法则将参数信息发送给"/insertPet"
    document.getElementById("insert").onclick = function () {
        var petName = document.getElementById("petName").value;
        var petType = document.getElementById("petType").value;
        var petBirthDate = document.getElementById("petBirthDate").value;
        var petOwnerName = document.getElementById("petOwnerName").value;
        var petNameError = document.getElementById("petNameError");
        var petBirthDateError = document.getElementById("petBirthDateError");
        var petOwnerNameError = document.getElementById("petOwnerNameError");
        var error = false;
        if (petName == "") {
            petNameError.innerHTML = "宠物名称不能为空";
            error = true;
        } else {
            petNameError.innerHTML = "";
        }
        if (petBirthDate == "") {
            petBirthDateError.innerHTML = "出生日期不能为空";
            error = true;
        } else {
            petBirthDateError.innerHTML = "";
        }
        if (petOwnerName == "") {
            petOwnerNameError.innerHTML = "主人姓名不能为空";
            error = true;
        } else {
            petOwnerNameError.innerHTML = "";
        }
        if (error) {
            return;
        }
        var form = document.createElement("form");
        form.action = "/insertPet";
        form.method = "post";
        var input = document.createElement("input");
        input.type = "hidden";
        input.name = "petName";
        input.value = petName;
        form.appendChild(input);
        input = document.createElement("input");
        input.type = "hidden";
        input.name = "petType";
        input.value = petType;
        form.appendChild(input);
        input = document.createElement("input");
        input.type = "hidden";
        input.name = "petBirthDate";
        input.value = petBirthDate;
        form.appendChild(input);
        input = document.createElement("input");
        input.type = "hidden";
        input.name = "petOwnerName";
        input.value = petOwnerName;
        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();
    }
//    点击浏览病例按钮，返回病例列表
    document.getElementById("back").onclick = function () {
        window.location.href = "/visit";
    }

</script>
</body>

</html>
