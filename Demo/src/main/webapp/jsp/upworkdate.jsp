<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excel导入调休工作日</title>
</head>
<body>
<form action="/importExcel" enctype="multipart/form-data" method="post">
    <input type="hidden" name="flag" value="1">
    <input type="file" name="importExcel" id="importExcel"><br>
    <input type="submit" value="点击导入文件">
</form>
<c:if test="${msg eq '20'}">文件为空<br></c:if>
<c:if test="${msg ne '20'}">
    <c:if test="${msg eq '21'}">
        导入文件类型不是Excel<br>
    </c:if>
    <c:if test="${msg eq '29'}">
        <form action="/updateChangeWorkDate">
            <table>
                <c:forEach var="dates" items="${dates}">
                    <tr>
                        <td>${dates}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="button" value="查询数据库" onclick="selectAllChangeWorkDate()"><br>
            <c:if test="${msgs eq '30'}">数据库为空</c:if>
            <c:if test="${msgs ne '30'}">
                <table>
                    <h3>Excel数据</h3>
                    <c:forEach var="dates2" items="${dates2}">
                        <tr>
                            <td>${dates2.changeworkdate_date}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <input type="submit" value="更新数据库"><br>
        </form>
    </c:if>
</c:if>
<a href="/index">点我返回主页</a>
<script>
    function selectAllChangeWorkDate() {
        window.location.href = "/selectAllChangeWorkDate"
    }
</script>
<c:if test="${msg eq '28'}">
    <script>alert("数据库更新完毕");</script>
</c:if>
</body>
</html>
