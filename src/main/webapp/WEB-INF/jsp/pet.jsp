<%--
  Created by IntelliJ IDEA.
  User: guico
  Date: 2022/6/2
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {color: #FF0000;}
    </style>
</head>
<body>
<button id="back">返回</button>
<table id="inputTable" hidden="hidden">

    <tr>
        <td>宠物名称</td>
        <td><input type="text" id="petName"></td>
        <td class="error" id="petNameError" hidden="hidden"></td>
    </tr>
    <tr>
        <td>主人名称</td>
        <td><input type="text" id="ownerName"></td>
        <td class="error" id="ownerNameError" hidden="hidden"></td>
    </tr>
    <tr>
        <td><button id="selectByPetName">根据宠物查询</button></td>
        <td><button id="selectByOwnerName">根据主人查询</button></td>
    </tr>
</table>

<table id="showTable" hidden="hidden" >
    <tr><button id="selectAgain">重新查询</button></tr>
    <tr>
        <td>宠物名称</td>
        <td>主人姓名</td>
    </tr>
</table>

<script>
    //先不让inputTable隐藏
    document.getElementById("inputTable").hidden = false;

    document.getElementById("back").onclick = function () {
        window.location.href = "/client";
    }

//    点击selectByPetName按钮后，发送请求，获取数据
    document.getElementById("selectByPetName").onclick = function () {
        var petName = document.getElementById("petName").value;
        //判断是否为空
        if (petName === "") {
            document.getElementById("petNameError").hidden = false;
            document.getElementById("petNameError").innerHTML = "宠物名称不能为空";
            return;
        }
        var url = "/selectByPetName?petName=" + petName;
        var xhr = new XMLHttpRequest();
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var result = xhr.responseText;
                var json = JSON.parse(result);
                var showTable = document.getElementById("showTable");
                for (var i = 0; i < json.length; i++) {
                    var tr = document.createElement("tr");
                    var td1 = document.createElement("td");
                    var td2 = document.createElement("td");
                    td1.innerHTML = "<a href=/petInfo?petId="+json[i].id+">"+json[i].name+"</a>";
                    td2.innerHTML = "<a href=/ownerInfo?ownerId="+json[i].ownerId+">"+json[i].ownerName+"</a>";
                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    showTable.appendChild(tr);
                }
                document.getElementById("showTable").hidden = false;
                document.getElementById("inputTable").hidden = true;
            }
        }
        xhr.send();
    }

//    点击selectByOwnerName按钮后，发送请求，获取数据
    document.getElementById("selectByOwnerName").onclick = function () {
        var ownerName = document.getElementById("ownerName").value;
        //判断是否为空
        if (ownerName === "") {
            document.getElementById("ownerNameError").hidden = false;
            document.getElementById("ownerNameError").innerHTML = "主人名称不能为空";
            return;
        }
        var url = "/selectByOwnerName?ownerName=" + ownerName;
        var xhr = new XMLHttpRequest();
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var result = xhr.responseText;
                var json = JSON.parse(result);
                var showTable = document.getElementById("showTable");
                for (var i = 0; i < json.length; i++) {
                    var tr = document.createElement("tr");
                    var td1 = document.createElement("td");
                    var td2 = document.createElement("td");
                    td1.innerHTML = "<a href=/petInfo?petId="+json[i].id+">"+json[i].name+"</a>";
                    td2.innerHTML = "<a href=/ownerInfo?ownerId="+json[i].ownerId+">"+json[i].ownerName+"</a>";
                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    showTable.appendChild(tr);
                }
                document.getElementById("showTable").hidden = false;
                document.getElementById("inputTable").hidden = true;
            }
        }
        xhr.send();
    }
//    点击selectAgain按钮后，重新显示inputTable
    document.getElementById("selectAgain").onclick = function () {
        document.getElementById("inputTable").hidden = false;
        document.getElementById("showTable").hidden = true;
    }
</script>
</body>
</html>
