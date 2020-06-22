<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>msg字典库</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/ckform.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
<jsp:include page="msgadd.jsp" flush="true"/>
<form action="/getAllMsgs" method="post" id="form">
    <input type="hidden" name="currentPage" id="currentPage" value="${page.param.currentPage}"/>
    <table>
        <tr>
            <td>Msg_ID</td>
            <td>Msg_内容</td>
            <td>Msg_代码</td>
            <td>Msg_备注</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach var="msgList" items="${msgList}">
            <tr>
                <td>${msgList.msg_id}</td>
                <td>${msgList.msg_info}</td>
                <td>${msgList.msg_code}</td>
                <td>${msgList.msg_remark}</td>
                <td><a href="javascript:;" onclick="deleteMsg(${msgList.msg_id});">删除</a></td>
                <td>
                    <a href="/toUpdateMsg?msg_id=${msgList.msg_id}&msg_info=${msgList.msg_info}&msg_code=${msgList.msg_code}&msg_remark=${msgList.msg_remark}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<jsp:include page="/common/page.jsp" flush="true"/>
<c:if test="${msg eq '40'}">
    <script>alert("添加msg成功");</script>
</c:if>
<c:if test="${msg eq '41'}">
    <script>alert("删除msg成功");</script>
</c:if>
</body>
<script type="text/javascript">
    function deleteMsg(id) {
        $.ajax({
            type: 'post',
            url: "/deleteMsg?msg_id=" + id,
            dataType: 'json',
            success: function (result) {
                if (result.re == 41) {//正常周末
                    alert("删除成功");
                    window.location = '/getAllMsgs';
                } else {
                    alert("删除失败");
                }
            }
        });
    }
</script>
</html>
