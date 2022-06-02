<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guico
  Date: 2022/6/1
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<!--登录表单-->
<form id="loginForm" action="/checkLogin" method="post" >
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" id="username" onblur="checkUsername()"/></td>
            <td class="error" id="usernameError" hidden="hidden">请输入用户名</td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="password" onblur="checkPassword()"/></td>
            <td class="error" id="passwordError" hidden="hidden">请输入密码</td>
        </tr>
        <tr>
            <td><input type="button" value="登录" id="submit" onclick="checkForm()"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
<script>
    //检查用户名是否为空
    function checkUsername() {
        var username = document.getElementById("username").value;
        if (username === "" || username === null) {
            document.getElementById("usernameError").hidden = false;
            return false;
        } else {
            document.getElementById("usernameError").hidden = true;
            return true;
        }
    }
    //    检查密码是否为空
    function checkPassword() {
        var password = document.getElementById("password").value;
        if (password === "" || password === null) {
            document.getElementById("passwordError").hidden = false;
            return false;
        } else {
            document.getElementById("passwordError").hidden = true;
            return true;
        }
    }
    //    检查表单,如果表单不合法则不提交
    function checkForm() {
        if (checkUsername() && checkPassword()) {
            document.getElementById("passwordError").submit();
        } else {
            alter("请输入用户名和密码");
        }
    }

</script>
</body>
</html>