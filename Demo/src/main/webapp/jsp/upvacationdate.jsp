<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excel导入法定节假日</title>
</head>
<body>
<form action="/importExcel" enctype="multipart/form-data" method="post">
    <input type="hidden" name="flag" value="0">
    <input type="file" name="importExcel" id="importExcel"><br>
    <input type="submit" value="点击导入文件">
</form>
<c:if test="${msg eq '20'}">文件为空<br></c:if>
<c:if test="${msg ne '20'}">
    <c:if test="${msg eq '21'}">
        导入文件类型不是Excel<br>
    </c:if>
    <c:if test="${msg eq '29'}">
        <form action="/updateVacationDate">
            <table>
                <c:forEach var="dates" items="${dates}">
                    <tr>
                        <td>${dates}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="button" value="查询数据库" onclick="selectAllVacationDate()"><br>
            <c:if test="${msgs eq '30'}">数据库为空<br></c:if>
            <c:if test="${msgs ne '30'}">
                <table>
                    <h3>Excel数据</h3>
                    <c:forEach var="dates2" items="${dates2}">
                        <tr>
                            <td>${dates2.vacation_date}</td>
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
    function selectAllVacationDate() {
        window.location.href = "/selectAllVacationDate"
    }
</script>
<c:if test="${msg eq '28'}">
    <script>alert("数据库更新完毕");</script>
</c:if>
</body>
</html>
