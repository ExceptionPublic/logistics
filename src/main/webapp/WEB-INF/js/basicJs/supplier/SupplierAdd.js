var rowData;
$(function () {
    layui.use(['form', 'laydate'], function () {
        var form = layui.form;
        //提交按钮
        $("#btn_close").click(function () {
            close();
        });
        //自定义验证
        form.verify({
            name: function (value, item) { //value：表单的值、item：表单的DOM对象
                var data = ajax("basicJsp/supplier/isRepetitionSuppliertsname", {
                    name:value
                });
                console.log(data);
                if (null == rowData || (null != rowData && rowData.name != value)) {
                    // console.log(data);
                    if (data.success)
                        return data.message;
                }

            }
        });
        //关闭按钮
        form.on('submit(btn_supplierAdd)', function (data) {
            //获取form表单中的字段
            var field = data.field;//form表单字段{name:vlaue}
            // var url="";
            //进行ajax请求
            $.ajax({
                url: '/basicJsp/supplier/supplierAdd',
                data: field,
                type: "post",
                dataType: "json",
                success: function (data) {
                    if (data.success){
                        msg(data.message);
                        close();
                        parent.supplier();
                    }else {
                        layer.msg("服务器忙！")
                    }
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
function initEmpForm(row) {
    rowData = row;
    //初始化部门下拉
    initSelect("personnel/dep/queryDep", [], "#dep", "uuid", "name");
    initForm("emp", row);
    renderForm("select", "depuuid");
}