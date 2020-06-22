/**
 * Created with JetBrains PhpStorm.
 * User: kk
 * Date: 13-8-28
 * Time: 下午4:44
 */
function U() {
    var url = arguments[0] || [];
    var param = arguments[1] || {};
    var url_arr = url.split('/');
    if (!$.isArray(url_arr) || url_arr.length < 2 || url_arr.length > 3) {
        return '';
    }
    if (url_arr.length == 2)
        url_arr.unshift(_GROUP_);
    var pre_arr = ['g', 'm', 'a'];
    var arr = [];
    for (d in pre_arr)
        arr.push(pre_arr[d] + '=' + url_arr[d]);
    for (d in param)
        arr.push(d + '=' + param[d]);
    return _APP_ + '?' + arr.join('&');
}

/**
 * 清空表单
 */
function clearForm() {
    $("input[type='text']").val('');
    $("input[type='checkbox']").removeAttr("checked");
    $("input[type='radio']").removeAttr("checked");
    $('.select2').val(null).trigger('change');
    $('.js-select2').val(null).trigger('change');
    var SelectArr = $("select:not(.select2,.js-select2)");
    for (var i = 0; i < SelectArr.length; i++) {
        if (SelectArr[i].options != null && SelectArr[i].options.length > 0) {
            SelectArr[i].options[0].selected = true;
        }
    }
}

function num(obj) {
    var t = obj.value.charAt(0);
    obj.value = obj.value.replace(/[^\d.]/g, ""); //清除"数字"和"."以外的字符
    obj.value = obj.value.replace(/^\./g, ""); //验证第一个字符是数字
    obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个, 清除多余的
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'); //只能输入两个小数
    if (t == '-') {
        obj.value = '-' + obj.value;
    }
}
