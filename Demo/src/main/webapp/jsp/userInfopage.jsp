<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页查询</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/ckform.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
<form action="/getAllUsers" method="post" id="form">
    <input type="hidden" name="currentPage" id="currentPage" value="${page.param.currentPage}"/>
    <table>
        <tr>
            <td>用户ID</td>
            <td>用户名字</td>
            <td>用户密码</td>
            <td>用户电话</td>
            <td>角色等级</td>
        </tr>
        <c:forEach var="userList" items="${userList}">
            <tr>
                <td>${userList.user_id}</td>
                <td>${userList.user_name}</td>
                <td>${userList.user_pwd}</td>
                <td>${userList.user_telphone}</td>
                <td>${userList.user_role}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/index">点我返回主页</a>
</form>
<jsp:include page="/common/page.jsp" flush="true"/>
</body>
</html>
