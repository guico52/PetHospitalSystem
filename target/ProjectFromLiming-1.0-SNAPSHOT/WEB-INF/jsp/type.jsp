<%--
  Created by IntelliJ IDEA.
  User: guico
  Date: 2022/6/5
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            width: 100%;
            height: 100vh;
            background: linear-gradient(-200deg,#aac2ee,#fac0e7);
        }
        .type-box{
            position: absolute;
            top:40%;
            left: 40%;
            width: 400px;
            height: 200px;
            background: #fff;
            align-items: center;
            text-align: center;
            border-radius: 10px;
        }
        .type-box h3{
            font-size: 20px;
            color: #000;
            margin-top: 20px;
        }
        .type-box input{
            margin-top: 20px;
            width: 200px;
            height: 30px;
            border: none;
            border-bottom: 1px solid #ddd;
        }
        .type-box button {
            margin-top: 20px;
            width: 100px;
            height: 30px;
            border: none;
            border-radius: 5px;
            background: linear-gradient(-200deg, #aac2ee, #fac0e7);
            color: #fff;
            transition: all 0.3s ease-in-out;
        }
        .type-box button:hover{
            background: linear-gradient(-200deg, #fac0e7, #aac2ee);
            background-position-x: -100px;
        }

    </style>
</head>
<body>
<div class="type-box">
    <form action="/insertType">
        <h3>添加宠物类型</h3>
        <label for="typeName">  类型名称：</label><input type="text" id="typeName" name="typeName">
        <br>
        <button type="submit" id="submit">提交</button>
        <p class="error" id="error"></p>
    </form>
</div>
<script>
    //表单提交前检查
    document.getElementById("submit").onclick = function(){
        var typeName = document.getElementById("typeName").value;
        if(typeName === ""){
            document.getElementById("error").innerHTML = "类型名称不能为空";
            return false;
        }
    }
</script>

</body>
</html>
