<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/ckform.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
<jsp:include page="menuadd.jsp" flush="true"/>
<form action="/getAllMenus" method="post" id="form">
    <input type="hidden" name="currentPage" id="currentPage" value="${page.param.currentPage}"/>
    <table>
        <tr>
            <td>Menu_ID</td>
            <td>Menu_地址</td>
            <td>Menu_标题</td>
            <td>Menu_权限</td>
            <td>Menu_备注</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach var="menuList" items="${menuList}">
            <tr>
                <td>${menuList.menu_id}</td>
                <td>${menuList.menu_href}</td>
                <td>${menuList.menu_title}</td>
                <td>${menuList.menu_role}</td>
                <td>${menuList.menu_remark}</td>
                <td><a href="javascript:;" onclick="deleteMenu(${menuList.menu_id});">删除</a></td>
                <td>
                    <a href="/toUpdateMenu?menu_id=${menuList.menu_id}&menu_href=${menuList.menu_href}&menu_title=${menuList.menu_title}&menu_role=${menuList.menu_role}&menu_remark=${menuList.menu_remark}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<jsp:include page="/common/page.jsp" flush="true"/>
<c:if test="${menu eq '40'}">
    <script>alert("添加menu成功");</script>
</c:if>
<c:if test="${menu eq '41'}">
    <script>alert("删除menu成功");</script>
</c:if>
</body>
<script type="text/javascript">
    function deleteMenu(id) {
        $.ajax({
            type: 'post',
            url: "/deleteMenu?menu_id=" + id,
            dataType: 'json',
            success: function (result) {
                if (result.re == 41) {//正常周末
                    alert("删除成功");
                    window.location = '/getAllMenus';
                } else {
                    alert("删除失败");
                }
            }
        });
    }
</script>
</html>
