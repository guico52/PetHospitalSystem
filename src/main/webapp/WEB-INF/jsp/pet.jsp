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
    <link rel="stylesheet" href="/pet_css">
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
<div class="input-box" id="input-box">
    <h3>宠物查询</h3>
    <input type="text" id="petName" placeholder="宠物名称">
    <input type="text" id="ownerName" placeholder="主人名称">
    <button id="selectByPetName">根据宠物查询</button>
    <button id="selectByOwnerName">根据主人查询</button>
    <p class="error" id="inputError"></p>
</div>

<div class="show-box" id="show-box">
    <table class="show-table" id="showTable">
        <thead>
        <tr>
            <td> <h3>宠物名称</h3> </td>
            <td> <h3>主人姓名</h3> </td>
        </tr>
        </thead>
        <tbody id="showTableBody">

        </tbody>
        <tfoot>
        <tr><td><button id="select-again">重新查询</button></td></tr>
        </tfoot>
    </table>

</div>
<script>

    //    点击selectByPetName按钮后，发送请求，获取数据
    document.getElementById("selectByPetName").onclick = function () {
        var petName = document.getElementById("petName").value;
        document.getElementById("inputError").innerHTML = "";
        //判断是否为空
        if (petName === "") {
            document.getElementById("inputError").innerHTML = "宠物名称不能为空";
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
                var showTable = document.getElementById("showTableBody");
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
                document.getElementById("show-box").style.clipPath = "circle(75%)";
            }
        }
        xhr.send();
    }

    //    点击selectByOwnerName按钮后，发送请求，获取数据
    document.getElementById("selectByOwnerName").onclick = function () {
        var ownerName = document.getElementById("ownerName").value;
        document.getElementById("inputError").innerHTML = "";
        //判断是否为空
        if (ownerName === "") {
            document.getElementById("inputError").innerHTML = "主人姓名不能为空";
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
                var showTable = document.getElementById("showTableBody");
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
                document.getElementById("show-box").style.clipPath = "circle(75%)";
            }
        }
        xhr.send();
    }
    //    点击selectAgain按钮后，重新显示inputTable
    document.getElementById("select-again").onclick = function () {
        document.getElementById("showTableBody").innerHTML = "";
        document.getElementById("show-box").style.clipPath = "circle(0%)";
    }
</script>
</body>
</html>

