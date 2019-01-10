var rowData;
$(function () {
    layui.use('form', function () {

        var form = layui.form;
        //按钮监听
        //关闭按钮
        $("#btn_close").click(function () {
            close();
        });
        //自定义验证
        form.verify({
            name: function (value, item) {
                if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                    return '部门名称不能有特殊字符';
                }
                if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                    return '部门名称首尾不能出现下划线\'_\'';
                }
                if (/^\d+\d+\d$/.test(value)) {
                    return '部门名称不能全为数字';
                }
                var data = ajax("personnel/dep/isRepetitionDepName", {
                    name:value
                });
                if (null == rowData || (null != rowData && rowData.name != value))
                    if (data.success)
                        return data.message;
            }
        });
        //提交按钮
        form.on('submit(btn_saveDep)', function (data) {
            //获取form表单中的字段
            var field = data.field;//form表单字段{name:vlaue}
            //转换为int类型
            field.gender = parseInt(field.gender);
            field.depuuid = parseInt(field.depuuid);
            //转换为时间
            field.birthday = dateParseString(field.birthday);
            //判断是新增还是修改
            var url = "personnel/dep/insertDep";
            if (isBlank(field.uuid))
                url = "personnel/dep/updateDep";
            //进行ajax请求
            $.ajax({
                url: url,
                data: field,
                type: "post",
                dataType: "json",
                success: function (data) {
                    msg(data.message);
                    close();
                    parent.queryDep();
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
function initDepForm(row) {
    console.log(row);
    rowData = row;
    initForm("dep", row);
}