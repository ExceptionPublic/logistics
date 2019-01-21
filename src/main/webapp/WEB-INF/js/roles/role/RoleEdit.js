var rowData;
$(function () {
    layui.use(['form'], function () {
        var form = layui.form;

        $("#btn_close").click(function () {
            close();
        });

        //初始化部门
        if (null == rowData)
            initSelect("personnel/dep/queryDep", [], "#depuuid", "uuid", "name");
        //自定义验证
        form.verify({
            name: function (value, item) { //value：表单的值、item：表单的DOM对象
                var data = ajax("roles/role/isRolename", {
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
        form.on('submit(btn_rooleEdit)', function (data) {
            //获取form表单中的字段
            var field = data.field;//form表单字段{name:vlaue}

            var url = "roles/role/innsert";
            if (isBlank(field.uuid))
                url = "roles/role/updateByRole";
            //进行ajax请求
            $.ajax({
                url: url,
                data: field,
                type: "post",
                dataType: "json",
                success: function (data) {
                    msg(data.message);
                    close();
                    parent.rolelist();
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
function initRoleForm(row) {
    rowData = row;
    //初始化部门下拉
    initSelect("personnel/dep/queryDep", [], "#depuuid", "uuid", "name");
    initForm("roleEdit", row);
}