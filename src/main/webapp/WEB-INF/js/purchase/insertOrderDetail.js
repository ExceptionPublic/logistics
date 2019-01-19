$(function () {
    layui.use("form",function () {
        var form=layui.form;
    });
});
/**
 * 初始化商品
 */
function initGoods(uuid) {
    $.ajax({
        url: "basicJsp/goods/querySupplierGoods",
        data: {
            uuid:uuid
        },
        type: "post",
        dataType: "json",
        async: false,
        success: function (data) {
            $.each(data, function (index, data) {
                var option = $("<option>").val(JSON.stringify(data).replace(/"/g,"'"))
                    .text($(data).attr("name"));
                $("#goods").append(option);
            });
            renderForm("select");
        }
    });
}

/**
 * 获取商品
 * @returns {*}
 */
function getGoods(){
    return getValue("#goods option:selected");
}