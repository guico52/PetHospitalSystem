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
    List<Vet> vets = (List<Vet>)request.getAttribute("vets");
%>
<table id="allVetTable" hidden="hidden" >
    <tr>
        <td>兽医姓名</td>
        <td>兽医专业</td>
    </tr>
    <%
    for(Vet vet : vets){
        out.println("<tr><td>"+vet.getVetName()+"</td><td>"+vet.getSpecName()+"</td></tr>");
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
    </tr>
</table>
<button id="selectVet" value="查询兽医"></button>
<button id="showTable" value="展示列表"></button>

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
//    输入兽医姓名，查询兽医专业，获取参数后显示在spec中
    document.getElementById("getVetName").oninput = function () {
        var vetName = document.getElementById("getVetName").value;
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/getVetByName?vetName="+vetName, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var spec = document.getElementById("spec");
                spec.innerHTML = xhr.responseText;
            }
        }
    }
</script>
</body>
</html>
