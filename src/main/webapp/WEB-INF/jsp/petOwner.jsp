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
</head>
<body>
<button id="back">返回</button>


<script>
    document.getElementById("back").onclick = function () {
        window.location.href = "/client";
    }
</script>
</body>
</html>
