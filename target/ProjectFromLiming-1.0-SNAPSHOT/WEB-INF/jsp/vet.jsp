<%@ page import="com.guico.pojo.Vet" %>
<%@ page import="java.util.List" %><%--
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
</head>
<body>

<%
    List<Vet> vets = (List<Vet>) request.getAttribute("vets");
%>
<table id="allVetTable" hidden="hidden" >
    <tr>
        <td>兽医姓名</td>
        <td>兽医专业</td>
    </tr>
    <%
        for(Vet vet : vets){
    %>
    <tr>
        <td><%=vet.getVetName()%></td>
        <td><%=vet.getSpecName()%></td>
    </tr>
    <%
        }
    %>
</table>
<script>
    <%--先不要让allVetTable隐藏--%>
    document.getElementById("allVetTable").hidden = false;
</script>
<table id="selectVetByName" hidden="hidden">
    <tr>
        <td>兽医姓名</td>
        <td><input type="text" id="getVetName"></td>
    </tr>
    <tr>
        <td>兽医专业</td>
        <td id="spec"></td>
        <td class="error" id="error" hidden="hidden">请输入正确的姓名</td>
    </tr>
    <tr>
        <td><button id="submitVetName">提交</button></td>
    </tr>
</table>
<button id="selectVet" >查询兽医</button>
<button id="showTable" >查看所有</button>
<a id="logout">退出登录</a>

<script>
// 点击查询兽医后，隐藏兽医列表，显示查询兽医的表单
    document.getElementById("selectVet").onclick = function () {
        document.getElementById("allVetTable").hidden = true;
        document.getElementById("selectVetByName").hidden = false;
    }
//  点击展示列表后，隐藏查询兽医的表单，显示兽医列表
    document.getElementById("showTable").onclick = function () {
        document.getElementById("allVetTable").hidden = false;
        document.getElementById("selectVetByName").hidden = true;
    }
//  点击submitVetName按钮后，提交getVetName的值，获取兽医专业
    document.getElementById("submitVetName").onclick = function () {
        var getVetName = document.getElementById("getVetName").value;
        if(getVetName === ""){
            document.getElementById("error").hidden = false;
        }else{
            document.getElementById("error").hidden = true;
            var xhr = new XMLHttpRequest();
            xhr.open("GET","/getSpecByVetName?vetName="+getVetName,true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            xhr.send();
            xhr.onreadystatechange = function () {
                if(xhr.readyState === 4 && xhr.status === 200){
                    var spec = xhr.responseText;
                    spec = window.decodeURIComponent(spec);
                    document.getElementById("spec").innerHTML = spec;
                }
            }
        }
    }
//    点击退出登录字体后，发送请求和session中的emp对象，退出登录
    document.getElementById("logout").onclick = function () {
        var xhr = new XMLHttpRequest();
        xhr.open("GET","/logout",true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        xhr.send();
        xhr.onreadystatechange = function () {
            if(xhr.readyState === 4 && xhr.status === 200){
                window.location.href = "/login";
            }
        }
    }

</script>
</body>
</html>
