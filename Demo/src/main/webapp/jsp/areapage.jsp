<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择地区</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/ckform.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
    <script type="text/javascript" src="../js/areaQuery.js"></script>
</head>
<body>
<form action="/saveProCityArea">
    <table>
        <tr>
            <td class="tdstyle">所在地区：</td>
            <td colspan="3">
                <input type="hidden" name="user_id" id="user" value="${userInfo.user_id}"/>
                <select style="width: 22%;" id="pre" name="provCode"
                        onchange="chg(this);">
                    <option value="">请选择</option>
                </select>
                <select style="width: 22%;" id="city" name="cityCode"
                        onchange="chg2(this);">
                    <option value="">请选择</option>
                </select>
                <select style="width: 22%;" id="area" name="areaCode">
                    <option value="">请选择</option>
                </select>
            </td>
        </tr>
    </table>
    <a href="/index">点我返回主页</a>
</form>
</body>
</html>
