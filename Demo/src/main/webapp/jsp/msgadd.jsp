<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加Msg</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
</head>
<body>
<form action="/addMsg" id="form1" name="form1">
    <table>
        <tr>
            <td>
                msg_info：
            </td>
            <td>
                <input type="text" id="msg_info" name="msg_info" value="${msg.msg_info}">
            </td>
        </tr>
        <tr>
            <td>
                msg_code：
            </td>
            <td>
                <input type="text" id="msg_code" name="msg_code" value="${msg.msg_code}">
            </td>
        </tr>
        <tr>
            <td>
                msg_remark：
            </td>
            <td>
                <input type="text" id="msg_remark" name="msg_remark" value="${msg.msg_remark}">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="查询" disabled="disabled" style="width: 100px">
            </td>
            <td>
                <c:if test="${flag eq 2}">
                    <input type="button" value="修改" onclick="updateMsg()" style="width: 100px">
                </c:if>
                <c:if test="${flag ne 2}">
                    <input type="button" value="添加" onclick="addMsg()" style="width: 100px">
                </c:if>
            </td>
        </tr>
    </table>
    <a href="/index">点我返回主页</a>
</form>
<script>
    function x() {
        var a = $("#msg_info").val();
        var b = $("#msg_code").val();
        if (a == null || b == null) {
            alert("msg_info和msg_code不能为空");
            return false;
        }
        return true;
    }

    function addMsg() {
        if (!x()) {
            return false;
        }
        $.ajax({
            type: 'post',
            url: "/addMsg",
            dataType: 'json',
            data: $("#form1").serialize(),
            success: function (result) {
                if (result.re == "40") {
                    alert("添加成功");
                    window.location = '/getAllMsgs';
                } else {
                    alert("添加失败");
                }
            }
        });
    }

    function updateMsg() {
        if (!x()) {
            return false;
        }
        $.ajax({
            type: 'post',
            url: "/updateMsg",
            dataType: 'json',
            data: $("#form1").serialize(),
            success: function (result) {
                if (result.re == "11") {
                    alert("修改成功");
                    window.location = '/getAllMsgs';
                } else {
                    alert("修改失败");
                }
            }
        });
    }
</script>
</body>
</html>
