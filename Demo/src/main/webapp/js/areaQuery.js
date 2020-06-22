// 选择省的事件
function chg(obj) {
    // 默认省
    var cityEle = document.getElementById("city");
    var areaEle = document.getElementById("area");
    if (obj.value == -1) {
        cityEle.options.length = 0;
        areaEle.options.length = 0;
    }
    //获取选中的省
    var preId = obj.value;
    //根据选中的省查询城市 得到第一个城市
    getCity(preId);
}

// 选择城市的事件
function chg2(obj) {
    var val = obj.value;
    //查询地区
    getArea(val);
}

// 根据省的ID查询市
function getCity(preId) {
    var cityEle = document.getElementById("city");
    //先清空市
    cityEle.options.length = 1;
    $.ajax({
        type: 'post',
        url: "/getCityByProNo",
        dataType: 'json',
        data: {
            provinceNo: preId
        },
        success: function (result) {
            for (var i = 0; i < result.length; i++) {
                if (i == 0) {
                    getArea(result[i].cityNo);
                }
                var op = new Option(result[i].cityName, result[i].cityNo);
                cityEle.options.add(op);
            }
        },
        error: function () {
            alert("发生错误");
        }
    });
}

// 根据城市的ID查询地区
function getArea(cityNo) {
    var areaEle = document.getElementById("area");
    //先清空地区
    areaEle.options.length = 1;
    $.ajax({
        type: 'post',
        url: "/getAreaByCityNo",
        dataType: 'json',
        data: {
            cityNo: cityNo
        },
        success: function (result) {
            for (var i = 0; i < result.length; i++) {
                var op = new Option(result[i].areaName, result[i].areaNo);
                areaEle.options.add(op);
            }
        },
        error: function () {
            alert("发生错误");
        }
    });
}

/*省市区二级联动*/
function proChg2(obj) {
    // 默认省
    var cityEle = document.getElementById("city");
    var areaEle = document.getElementById("area");
    if (obj.value == -1) {
        cityEle.options.length = 0;
        areaEle.options.length = 0;
    }
    //获取选中的省
    var preId = obj.value;
    //根据选中的省查询城市 得到第一个城市
    getCity2(preId);
}

// 根据省的ID查询市
function getCity2(preId) {
    var cityEle = document.getElementById("city");
    //先清空市
    cityEle.options.length = 1;
    $.ajax({
        type: 'post',
        url: "/getCityByProNo",
        dataType: 'json',
        data: {
            provinceNo: preId
        },
        success: function (result) {
            for (var i = 0; i < result.length; i++) {
                var op = new Option(result[i].cityName, result[i].cityNo);
                cityEle.options.add(op);
            }
        },
        error: function () {
            alert("发生错误");
        }
    });
}

/*--基本信息start---*/

//获取省列表
function getProvinces() {
    $("#pre").empty();
    $("#pre").append("<option value=''>请选择省</option>");
    var provinceNo = $("#basicPro").val();
    $.ajax({
        url: "/getProvinceList.jhtml",
        async: false,
        type: "POST",
        success: function (result) {
            $.each(result, function (i, v) {
                if (provinceNo == v.provinceNo) {
                    $("#pre").append("<option value='" + v.provinceNo + "' selected = 'selected'>" + v.provinceName + "</option>");
                } else {
                    $("#pre").append("<option value='" + v.provinceNo + "'>" + v.provinceName + "</option>");
                }
            });
        }
    });
}

//获取市列表
function getCitys() {
    $("#city").empty();
    $("#city").append("<option value=''>请选择市</option>");
    var cityNo = $("#basicCity").val();
    $.ajax({
        url: "/getCityByProNo.jhtml",
        async: false,
        type: "POST",
        data: {provinceNo: $("#pre").val()},
        success: function (result) {
            $.each(result, function (i, v) {
                if (cityNo == v.cityNo) {
                    $("#city").append("<option value='" + v.cityNo + "' selected = 'selected'>" + v.cityName + "</option>");
                } else {
                    $("#city").append("<option value='" + v.cityNo + "'>" + v.cityName + "</option>");
                }
            });
        }
    });
}

//获取区县列表
function getAreas() {
    $("#area").empty();
    $("#area").append("<option value=''>请选择区县</option>");
    var areaNo = $("#basicArea").val();
    $.ajax({
        url: "/getAreaByCityNo.jhtml",
        async: false,
        type: "POST",
        data: {cityNo: $("#city").val()},
        success: function (result) {
            $.each(result, function (i, v) {
                if (areaNo == v.areaNo) {
                    $("#area").append("<option value='" + v.areaNo + "' selected = 'selected'>" + v.areaName + "</option>");
                } else {
                    $("#area").append("<option value='" + v.areaNo + "'>" + v.areaName + "</option>");
                }
            });
        }
    });
}

/*--基本信息end---*/

$(function () {
    getProvinces();
    getCitys();
    getAreas();
});