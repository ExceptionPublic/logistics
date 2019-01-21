var rowData;
$(function () {
    layui.use(['form'], function () {
        var form = layui.form;
        //按钮监听
        //关闭按钮
        if(null==rowData)
            initSelect("personnel/dep/queryDep", [], "#dep", "uuid", "name");
        $("#btn_close").click(function () {
            close();
        });
        //自定义验证
        form.verify({
            password: [
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ]
        });
        //提交按钮
        form.on('submit(btn_roolepwdEdit)', function (data) {
            //获取form表单中的字段
            var field = data.field;//form表单字段{name:vlaue}
            //转换为int类型
            //判断是新增还是修改
            url = "personnel/emp/updateEmp";
            //进行ajax请求
            $.ajax({
                url: url,
                data: field,
                type: "post",
                dataType: "json",
                success: function (data) {
                    msg(data.message);
                    close();
                    parent.initTable();
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
function initRolepwdForm(row) {
    rowData = row;
    //初始化部门下拉
    initForm("rolepwdEdit", row);
    initSelect("personnel/dep/queryDep", [], "#dep", "uuid", "name");
    renderForm("select", "depuuid");
}