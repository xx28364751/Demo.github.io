<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>加密解密</title>
</head>
<script type="text/javascript" src="../js/jquery.js"></script>
<body>
ThreeDes加密解密：<br>
<form>
    <input type="text" id="TDencryptText" placeholder="要加密的数据">
    <input type="button" onclick="TDencrypt()" value="加密">
    <input type="text" id="TDencryptResult" disabled="disabled">
    <span id="TDencryptError" style="color: red"></span>
    <br>
    <input type="text" id="TDdecryptText" placeholder="要解密的数据">
    <input type="button" onclick="TDdecrypt()" value="解密">
    <input type="text" id="TDdecryptResult" disabled="disabled">
    <span id="TDdecryptError" style="color: red"></span>
    <br>
    <input type="reset" value="重置">
    <a href="/index">点我返回主页</a>
</form>
</body>
<script type="text/javascript">
    function TDencrypt() {
        var TDencryptText = $("#TDencryptText").val();
        if (TDencryptText == null || TDencryptText == "") {
            $("#TDencryptError").html("请输入要加密的数据");
            return false;
        }

        $("#TDencryptError").empty();
        $.ajax({
            type: 'post',
            url: "/toTDencrypt?TDencryptText=" + TDencryptText,
            dataType: 'json',
            success: function (result) {
                if (result.code == 1) {
                    $("#TDencryptResult").val(result.data);
                } else {
                    $("#TDencryptResult").val("加密异常");
                }
            }
        })
    }

    function TDdecrypt() {
        var TDdecryptText = $("#TDdecryptText").val();
        if (TDdecryptText == null || TDdecryptText == "") {
            $("#TDdecryptError").html("请输入要解密的数据");
            return false;
        }

        $("#TDdecryptError").empty();
        $.ajax({
            type: 'post',
            url: "/toTDdecrypt?TDdecryptText=" + TDdecryptText,
            dataType: 'json',
            success: function (result) {
                if (result.code == 1) {
                    $("#TDdecryptResult").val(result.data);
                } else {
                    $("#TDdecryptResult").val("解密异常");
                }
            }
        })
    }
</script>
</html>
