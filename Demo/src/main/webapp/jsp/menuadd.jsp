<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加Menu</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
</head>
<body>
<form action="/addOrfindMenu" id="form1" name="form1">
    <table>
        <tr>
            <td>
                menu_id：
            </td>
            <td>
                <input type="text" id="menu_id" name="menu_id" value="${menu.menu_id}">
            </td>
        </tr>
        <tr>
            <td>
                menu_href：
            </td>
            <td>
                <input type="text" id="menu_href" name="menu_href" value="${menu.menu_href}">
            </td>
        </tr>
        <tr>
            <td>
                menu_title：
            </td>
            <td>
                <input type="text" id="menu_title" name="menu_title" value="${menu.menu_title}">
            </td>
        </tr>
        <tr>
            <td>
                menu_role：
            </td>
            <td>
                <input type="text" id="menu_role" name="menu_role" value="${menu.menu_role}">
            </td>
        </tr>
        <tr>
            <td>
                menu_remark：
            </td>
            <td>
                <input type="text" id="menu_remark" name="menu_remark" value="${menu.menu_remark}">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="submit" value="查询" disabled="disabled" style="width: 100px">
            </td>
            <td>
                <c:if test="${flag eq 2}">
                    <input type="button" value="修改" onclick="updateMenu()" style="width: 100px">
                </c:if>
                <c:if test="${flag ne 2}">
                    <input type="button" value="添加" onclick="addMenu()" style="width: 100px">
                </c:if>
            </td>
        </tr>
    </table>
    <a href="/index">点我返回主页</a>
</form>
<script>
    function x() {
        var a = $("#menu_id").val();
        var b = $("#menu_href").val();
        var c = $("#menu_title").val();
        var d = $("#menu_role").val();
        if (a == null || b == null || c == null || d == null) {
            alert("menu_id、menu_href、menu_title和menu_role不能为空");
            return false;
        }
        return true;
    }

    function addMenu() {
        if (!x()) {
            return false;
        }
        $.ajax({
            type: 'post',
            url: "/addMenu",
            dataType: 'json',
            data: $("#form1").serialize(),
            success: function (result) {
                if (result.re == "40") {
                    alert("添加成功");
                    window.location = '/getAllMenus';
                } else {
                    alert("添加失败");
                }
            }
        });
    }

    function updateMenu() {
        if (!x()) {
            return false;
        }
        $.ajax({
            type: 'post',
            url: "/updateMenu",
            dataType: 'json',
            data: $("#form1").serialize(),
            success: function (result) {
                if (result.re == "11") {
                    alert("修改成功");
                    window.location = '/getAllMenus';
                } else {
                    alert("修改失败");
                }
            }
        });
    }
</script>
</body>
</html>
