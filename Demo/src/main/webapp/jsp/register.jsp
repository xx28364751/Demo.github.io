<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>注册界面</title>
</head>
<body>
<form action="/registerUser" method="post">
    <input type="text" placeholder="帐号" name="user_name">
    <input type="password" placeholder="密码" name="user_pwd">
    <input type="password" placeholder="电话" name="user_telphone">
    <input type="submit" value="注册">
    <a href="/loginpage">登录</a>
</form>
</body>
<c:if test="${msg eq '05'}">
    <script>alert("注册失败");</script>
</c:if>
</html>
