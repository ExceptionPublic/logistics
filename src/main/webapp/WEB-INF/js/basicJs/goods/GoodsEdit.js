var rowData;

$(function () {
    layui.use(['form'], function () {
        var form = layui.form;

        //初始化部门
        if (null == rowData)
            initSelect("basicJsp/goodstype/SelectGtype", [], "#goodstypeuuid", "uuid", "name");
            initSelect("basicJsp/supplier/SupplierList", [], "#supplieruuid", "uuid", "name");

        //按钮监听
        //关闭按钮
        $("#btn_close").click(function () {
            close();
        });
        //自定义验证
        form.verify({
            name: function (value, item) { //value：表单的值、item：表单的DOM对象
                var data = ajax("basicJsp/goods/goodsService", {
                    name: value
                });
                console.log(data);
                if (null == rowData || (null != rowData && rowData.name != value)) {
                    // console.log(data);
                    if (data.success)
                        return data.message;
                }

            }
        });
        //提交按钮
        form.on('submit(btn_goodsEdit)', function (data) {
            //获取form表单中的字段
            var field = data.field;//form表单字段{name:vlaue}
            console.log(data);
            //转换为int类型
            //判断是新增还是修改
            var url = "basicJsp/goods/goodsAdd";
            if (isBlank(field.uuid))
                url = "basicJsp/goods/goodsUpdate";
            // 进行ajax请求
            $.ajax({
                url: url,
                data: field,
                type: "post",
                dataType: "json",
                success: function (data) {
                    msg(data.message);
                    close();
                    parent.goods();
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
function initGoodsForm(row) {
    rowData = row;
    //初始化部门下拉
    initSelect("basicJsp/goodstype/SelectGtype", [], "#goodstypeuuid", "uuid", "name");
    initSelect("basicJsp/supplier/SupplierList", [], "#supplieruuid", "uuid", "name");
    initForm("goodsEdit", row);
    renderForm("select", "supplieruuid");
    renderForm("select", "goodstypeuuid");
}