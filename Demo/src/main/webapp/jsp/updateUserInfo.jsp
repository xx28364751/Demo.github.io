<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改${userInfo.user_name}的信息</title>
</head>
<body>
<form action="/updateUser">
    <table>
        <tr>
            <td>
                账户名称：
            </td>
            <td>
                <input type="text" name="user_name" value="${userInfo.user_name}">
            </td>
        </tr>
        <tr>
            <td>
                账户密码：
            </td>
            <td>
                <input type="text" name="user_pwd" value="${userInfo.user_pwd}">
            </td>
        </tr>
        <tr>
            <td>
                联系电话：
            </td>
            <td>
                <input type="text" name="user_telphone" value="${userInfo.user_telphone}">
            </td>
        </tr>
    </table>
    <input type="hidden" value="1" name="flag">
    <input type="hidden" name="user_role" value="${userInfo.user_role}">
    <input type="hidden" name="user_id" value="${userInfo.user_id}">
    <input type="submit" value="确认修改">
    <a href="/index">点我返回主页</a>
</form>
</body>
</html>
