$(function () {
    $("#checkall").click(function () {
        if ($(this).prop("checked") == false) {
            $(":checkbox[id=check]").prop("checked", false);
        } else {
            $(":checkbox[id=check]").prop("checked", true);
        }
    });
})
