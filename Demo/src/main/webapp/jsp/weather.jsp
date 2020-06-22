<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天气预报</title>
</head>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/ckform.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/areaQuery.js"></script>
<body>
<form action="/getWeatherInfoByAreaId">
    <table>
        <tr>
            <td class="tdstyle">所在地区：</td>
            <td colspan="3">
                <select style="width: 30%;" id="pre" name="provCode"
                        onchange="chg(this);">
                    <option value="">请选择</option>
                </select>
                <select style="width: 30%;" id="city" name="cityCode"
                        onchange="chg2(this);">
                    <option value="">请选择</option>
                </select>
                <select style="width: 30%;" id="area" name="areaCode">
                    <option value="">请选择</option>
                </select>
            </td>
            <td>
                <input type="button" value="查询天气" onclick="check()">
                <a href="/index">点我返回主页</a>
            </td>
        </tr>
    </table>
    <div>
        <span id="weatherResult"></span>
    </div>
</form>
</body>
<script type="text/javascript">
    function check() {
        if ($("#pre").val() == null || $("#pre").val() == "") {
            alert("请选择省份");
            return false;
        }

        if ($("#city").val() == null || $("#city").val() == "") {
            alert("请选择城市");
            return false;
        }

        if ($("#area").val() == null || $("#city").val() == "") {
            alert("请选择区域");
            return false;
        }

        var areaCode = $("#area").val();
        var html = "";
        $('#weatherResult').empty();
        $.ajax({
                type: 'post',
                url: "/getWeatherInfoByAreaId?areaCode=" + areaCode,
                dataType: 'json',
                success: function (result) {
                    if (result.re == '51') {
                        var weather = result.data;
                        html += '<table><tr><td>城市：' + weather.city +
                            '</td><td>日期：' + weather.date +
                            '</td><td>' + weather.week +
                            '</td><td>最后更新时间：' + weather.update_time +
                            '</td></tr>' +
                            '<tr><td>天气情况：' + weather.wea +
                            '</td><td>当前温度：' + weather.tem +
                            '</td><td>最高温度：' + weather.tem1 +
                            '</td><td>最低温度：' + weather.tem2 +
                            '</td></tr>' +
                            '<tr><td>风向：' + weather.win +
                            '</td><td>等级：' + weather.win_speed +
                            '</td><td>风速：' + weather.win_meter +
                            '</td><td>湿度：' + weather.humidity +
                            '</td></tr>' +
                            '<tr><td>可见度：' + weather.visibility +
                            '</td><td>大气压：' + weather.pressure +
                            '</td><td>PM2.5：' + weather.air_pm25 +
                            '</td><td>空气等级：' + weather.air_level +
                            '</td></tr>' +
                            '<tr><td colspan="4">建议：' + weather.air_tips +
                            '</td></tr></table>';
                        $('#weatherResult').append(html);
                    } else if (result.re == '50') {
                        alert("查询失败");
                    }
                    else {
                        alert("查询异常");
                    }
                }
            }
        )
        ;
    }
</script>
</html>
