<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>操作日志列表</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/plugins/bootstrap-fileinput/css/bootstrap-3.3.7.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <link rel="stylesheet" href="/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"
          media="screen"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <script type="text/javascript" src="../js/ckform.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
    <script type="text/javascript" src="/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"
            charset="UTF-8"></script>
    <script type="text/javascript" src="/plugins/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"
            charset="UTF-8"></script>
</head>
<body>
<form class="form-inline definewidth m20" action="/getAllLogs" method="post" id="form">
    <table class="searchTable" id="listPage_table_select">
        <tr>
            <td class="tdstyle">操作员:</td>
            <td>
                <input type="text" class="abc input-default" name="operator" id="operator"
                       value="${page.param.operator}"/>
            </td>
            <td class="tdstyle">操作类型:</td>
            <td>
                <select class="abc input-default" name="operateType" id="operateType">
                    <option value="">请选择操作类型</option>
                    <option value="LOGIN" <c:if test="${page.param.operateType=='LOGIN'}">selected="selected"</c:if>>登录
                    </option>
                    <option value="ADD" <c:if test="${page.param.operateType=='ADD'}">selected="selected"</c:if>>添加
                    </option>
                    <option value="UPDATE" <c:if test="${page.param.operateType=='UPDATE'}">selected="selected"</c:if>>
                        更新
                    </option>
                    <option value="DELETE" <c:if test="${page.param.operateType=='DELETE'}">selected="selected"</c:if>>
                        删除
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="tdstyle">开始时间:</td>
            <td>
                <div class="input-append date" id="datetimepicker" data-date-format="yyyy-mm-dd">
                    <input class="abc input-default selectDateTime" name="startDate" id="startDate" type="text"
                           value="${page.param.startDate}"/>
                    <span class="add-on"><i class="icon-th"></i></span>
                </div>
            </td>
            <td class="tdstyle">结束时间:</td>
            <td>
                <div class="input-append date" id="datetimepicker1" data-date-format="yyyy-mm-dd">
                    <input class="abc input-default selectDateTime" name="endDate" id="endDate" type="text"
                           value="${page.param.endDate}"/>
                    <span class="add-on"><i class="icon-th"></i></span>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="6" style="text-align: center;">
                <div style="margin-top: 10px">
                    <button type="button" class="btn btn-primary" onclick="goTo(1);">查询</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-primary" onclick="clearForm()">重置</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-primary" onclick="returnlastpage()">返回</button>
                </div>
            </td>
        </tr>
    </table>
    <input type="hidden" name="currentPage" id="currentPage" value="${page.param.currentPage}"/>
</form>
<div class="table-scrollable">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>操作员</th>
            <th>操作类型</th>
            <th>日志内容</th>
            <th>状态</th>
            <th>IP</th>
            <th>创建时间</th>
        </tr>
        </thead>
        <c:forEach var="logs" items="${page.list}" varStatus="st">
            <tr>
                <td>${logs.operator}</td>
                <td>
                    <c:if test="${logs.operateType=='LOGIN'}">登录</c:if>
                    <c:if test="${logs.operateType=='ADD'}">添加</c:if>
                    <c:if test="${logs.operateType=='UPDATE'}">更新</c:if>
                    <c:if test="${logs.operateType=='DELETE'}">删除</c:if>
                </td>
                <td>${logs.content}</td>
                <td>
                    <c:if test="${logs.status=='SUCCESS'}">成功</c:if>
                    <c:if test="${logs.status=='FAILURE'}">失败</c:if>
                </td>
                <td>${logs.ip}</td>
                <td><fmt:formatDate value="${logs.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="/common/page.jsp" flush="true"/>
</body>
</html>
<script type="text/javascript">
    var date = new Date()
    $('#datetimepicker').datetimepicker({
        language: 'zh-CN',
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        startDate: date.getDate()
    });
    $('#datetimepicker1').datetimepicker({
        language: 'zh-CN',
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        startDate: date.getDate()
    });

    function returnlastpage() {
        window.location = "/index";
    }
</script>
