<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="dataTables_paginate paging_bootstrap pagination" style="margin-left: 30%">
    <ul id="page">
        <li><a href="javascript:void(0);" onclick="goTo(1);">首页</a></li>
        <li><a href="javascript:void(0);" onclick="goTo(${page.currentPage - 1});">上一页</a></li>
        <li><a>[${page.currentPage}/${page.totalPage}]页&nbsp;&nbsp;
            <c:if test="${page.totalNumber == 0}">
                [${page.param.beginLine}-${page.param.endLine}]/${page.totalNumber}
            </c:if>
            <c:if test="${page.totalNumber != 0}">
                [${page.param.beginLine + 1}-${page.param.endLine}]/${page.totalNumber}
            </c:if>
            条</a></li>
        <li><a href="javascript:void(0);" onclick="goTo(${page.currentPage + 1});">下一页</a></li>
        <li><a href="javascript:void(0);" onclick="goTo(${page.totalPage});">尾页</a></li>
        <li><a href="javascript:void(0);" onclick="jump();" id="jumpPageHref">跳转</a><input type="text" id="jumpPage"
                                                                                           style="width:30px;height: 20px;"/>
        </li>
    </ul>
</div>
<script type="text/javascript">
    /*******************分页信息**********begin*********/
    var formId = '<%=request.getParameter("formId")%>';
    var pageId = '<%=request.getParameter("pageId")%>';
    var totalPage = parseInt('<%=request.getParameter("totalPage")%>');

    var $form = $('#' + formId);
    var $page = $('#' + pageId);

    function goTo(page) {
        //验证是否整数
        var reg = /^-?\d+$/;
        if (null == page || page == "") {
            page = 1;
        }
        if (!reg.test(page)) {
            alert('提示:只能输入数字!');
            return;
        }

        if (page > totalPage) {
            page = totalPage;
        }

        if (page < 1) {
            page = 1;
        }

        $page.val(page);
        $form.submit();
    }

    $(function () {
        $('#jumpPageHref').click(function () {
            goTo($('#jumpPage').val());
        });
    });
    /*******************分页信息************end*******/
</script>
