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
    <link rel="stylesheet" href="/petInfo_css">
    <link rel="stylesheet" href="/direct_css">
</head>
<body>
<div class="direct">
    <a href="/client">首页</a>
    <a href="/vet">兽医</a>
    <a href="/pet">宠物</a>
    <a href="/type">类型</a>
    <a href="/logout">退出</a>
</div>
<%
    Pet pet= (Pet)session.getAttribute("pet");
    String birthday=pet.getBirthDate();
    birthday=birthday.substring(0,10)+"T"+birthday.substring(11,16);
    pet.setBirthDate(birthday);
    List<Type> types = (List<Type>)request.getSession().getAttribute("types");
    List<PetOwner> owners = (List<PetOwner>)request.getSession().getAttribute("owners");
%>
<div class="msg-box">
    <h3>宠物信息</h3>
    <input type="text" name="petId" id="petId" value="<%=pet.getId()%>" hidden="hidden">
    <div class="petName-box">
        <label for="petName">宠物名称</label>
        <input type="text" id="petName" name="petName" value="<%=pet.getName()%>">
    </div>
    <div class="petType-box">
        <label for="petType">宠物类型</label>
        <select name="petType" id="petType">
            <%
            for(Type type:types){
                if(pet.getTypeId()==type.getTypeId()){
                    %>
                    <option value="<%=type.getTypeId()%>" selected><%=type.getTypeName()%></option>
                    <%
                        } else{
            %>
            <option value="<%=type.getTypeId()%>"><%=type.getTypeName()%></option>
            <%
            }}
            %>
        </select>
    </div>
    <div class="petBirthDate-box">
        <label for="petBirthDate">宠物生日</label>
        <input type="datetime-local" id="petBirthDate" name="petBirthDate" value="<%=pet.getBirthDate()%>">
    </div>
    <div class="petOwnerName-box">
        <label for="petOwnerName">宠物主人</label>
        <select name="petOwnerName" id="petOwnerName">
            <%
            for(PetOwner owner:owners){
                %>

            <option value="<%=owner.getPetOwnerId()%>"><%=owner.getPetOwnerName()%></option>
            <%
                    }
            %>
        </select>
    </div>
    <button id="updatePet">修改</button>
    <button id="insertPet">添加</button>
    <div class="view-visit">
        <button id="visit1">浏览病例</button>
    </div>
    <div class="error-box"><p class="error" id="msg-box-error"></p></div>
</div>

<div class="insert-box-background" id="insert-box-background">
    <div class="insert-box">
        <h3>添加宠物</h3>
        <div class="petName-box">
            <label for="petName">宠物姓名</label>
            <input type="text" id="petName2" name="petName">
        </div>
        <div class="petType-box">
            <label for="petType">宠物类型</label>
            <select name="petType" id="petType2">
                <option value="dog">狗</option>
                <option value="cat">猫</option>
                <option value="bird">鸟</option>
                <option value="fish">鱼</option>
            </select>
        </div>
        <div class="petBirthDate-box">
            <label for="petBirthDate">宠物年龄</label>
            <input type="datetime-local" id="petBirthDate2" name="petBirthDate">
        </div>
        <div class="petOwnerName-box">
            <label for="petOwnerName">宠物主人</label>
            <select name="petOwnerName" id="petOwnerName2">
                <option>张三1</option>
                <option>张三2</option>
                <option>张三3</option>
            </select>
        </div>
        <div class="insert-control">
            <button id="insert">添加信息</button>
            <button id="cancel">取消</button>
        </div>
        <div class="view-visit">
            <button id="visit2">浏览病例</button>
        </div>
        <div class="error-box"><p class="error" id="insert-box-error"></p></div>
    </div>
</div>

<script>

    //    点击修改按钮，检查输入信息，信息合法则将参数信息发送给"/updatePet"
    document.getElementById("updatePet").onclick = function () {
        var petName = document.getElementById("petName").value;
        var petType = document.getElementById("petType").value;
        var petId = document.getElementById("petId").value;
        var petBirthDate = document.getElementById("petBirthDate").value;
        var petOwnerName = document.getElementById("petOwnerName").value;
        if (petName === "" || petType === "" || petBirthDate === "" || petOwnerName === "") {
            document.getElementById("msg-box-error").innerHTML = "请输入完整信息";
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

    //    点击添加按钮，设置
    document.getElementById("insertPet").onclick = function () {
        document.getElementById("insert-box-background").style.clipPath = "circle(75%)";
    }

    //    点击取消按钮，隐藏取消按钮和添加信息按钮，并恢复输入信息
    document.getElementById("cancel").onclick = function () {
        document.getElementById("insert-box-background").style.clipPath = "circle(0)";
    }

    //    点击添加信息按钮，检查输入信息，信息合法则将参数信息发送给"/insertPet"
    document.getElementById("insert").onclick = function () {
        var petName = document.getElementById("petName").value;
        var petType = document.getElementById("petType").value;
        var petBirthDate = document.getElementById("petBirthDate").value;
        var petOwnerName = document.getElementById("petOwnerName").value;
        if (petName === "" || petType === "" || petBirthDate === "" || petOwnerName === "") {
            document.getElementById("insert-box-error").innerHTML = "请输入完整信息";
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
    document.getElementById("visit1").onclick = function () {
        window.location.href = "/visit";
    }

    document.getElementById("visit2").onclick = function () {
        window.location.href = "/visit";
    }

</script>
</body>

</html>