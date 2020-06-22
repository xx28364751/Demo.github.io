<%@ page pageEncoding="UTF-8" %>
<!-- 分页 -->
<input type="hidden" name="formId" id="formId" value="form"/>
<input type="hidden" name="pageId" id="pageId" value="currentPage"/>
<input type="hidden" name="totalPage" id="totalPage" value="${page.totalPage}"/>
<jsp:include page="/common/pageFooter.jsp" flush="true">
    <jsp:param name="formId" value="form"/>
    <jsp:param name="pageId" value="currentPage"/>
    <jsp:param name="totalPage" value="${page.totalPage}"/>
</jsp:include>