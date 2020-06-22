<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>${userInfo.user_name}的主页</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/ckform.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
</head>
<style>
    /* 未访问的链接 */
    a:link {
        color: #FF0000
    }

    /* 已访问的链接 */
    a:visited {
        color: #FF0000
    }

    /* 鼠标移动到链接上 */
    a:hover {
        color: #FF00FF
    }

    /* 选定的链接 */
    a:active {
        color: #0000FF
    }

    span {
        color: aqua;
    }

    a {
        text-decoration-line: none;
    }
</style>
<body>
<p>用户名：${userInfo.user_name}</p>
<h2>功能列表：</h2>
<c:forEach items="${menuList}" var="menuList">
    <a href="${menuList.menu_href}">${menuList.menu_title}</a><br>
</c:forEach>
<a href="/loginOut">0.退出登录</a><br>
<c:if test="${msg eq '11'}">
    <script>alert("修改信息成功");</script>
</c:if>
<c:if test="${msg eq '01'}">
    <script>alert("登录成功");</script>
</c:if>
</body>
<script>
    function checkdateIsvacationdate() {
        $.ajax({
            type: 'post',
            url: "/checkdateIsvacationdate",
            dataType: 'json',
            success: function (result) {
                if (result.re == 0) {//正常周末
                    alert("正常周末，快点休息吧~！");
                } else if (result.re == 1) {//正常工作日
                    alert("正常工作日，好好工作吧~！");
                } else if (result.re == 11) {//法定节假日
                    alert("小长假去哪里玩呢？");
                } else if (result.re == 12) {//调休工作日
                    alert("假期过后该收心工作了？");
                }
            }
        });
    }
</script>
</html>
