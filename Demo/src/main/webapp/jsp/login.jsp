<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>登陆界面</title>
</head>
<body>
<form action="/login" method="post">
    <input type="text" placeholder="帐号" name="user_name">
    <input type="password" placeholder="密码" name="user_pwd">
    <input type="submit" value="登陆">
    <a href="/register">注册</a>
</form>
</body>
<c:if test="${msg eq '02'}">
    <script>alert("账号或密码错误");</script>
</c:if>
<c:if test="${msg eq '03'}">
    <script>alert("退出成功");</script>
</c:if>
<c:if test="${msg eq '04'}">
    <script>alert("注册成功");</script>
</c:if>
</html>
