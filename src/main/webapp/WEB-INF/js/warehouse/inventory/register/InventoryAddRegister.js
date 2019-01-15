var rowData;
$(function () {
    layui.use(['form'], function () {
        var form = layui.form;

        if(null==rowData)
            initSelect("basicJsp/store/StoreList", [], "#storeuuid", "uuid", "name");
        if(null==rowData)
            initSelect("basicJsp/goods/queryGoods", [], "#goodsuuid", "uuid", "name");



        $("#btn_close").click(function () {
            close();
        });
        form.on('submit(btn_inventoryAddregister)', function (data) {
            //获取form表单中的字段
            var field = data.field;//form表单字段{name:vlaue}

            var url = "warehouse/inventory/insert";
            //进行ajax请求
            $.ajax({
                url: url,
                data: field,
                type: "post",
                dataType: "json",
                success: function (data) {
                    msg(data.message);
                    close();
                    parent.inventory();
                }
            });
            return false; //阻止表单跳转。
        });
    });


});


/**
 * 关闭层
 */
function close() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}

/**
 * 初始化表单
 * @param row
 */
function initGtpForm(row) {
    rowData = row;
    //初始化部门下拉
    initSelect("basicJsp/store/StoreList", [], "#storeuuid", "uuid", "name");
    initSelect("basicJsp/goods/queryGoods", [], "#goodsuuid", "uuid", "name");

    initForm("invenAdd", row);
    renderForm("select", "storeuuid");
    renderForm("select", "goodsuuid");
}