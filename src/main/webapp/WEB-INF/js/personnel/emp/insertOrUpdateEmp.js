var rowData;
$(function () {
    layui.use(['form', 'laydate'], function () {
        var form = layui.form;
        var laydate = layui.laydate;

        //初始化部门
        if (null == rowData)
            initSelect("personnel/dep/queryDep", [], "#dep", "uuid", "name");
        form.on('select(depuuid)', function(data){
            $('#roleId').empty();
            initSelect("roles/role/roleByDepuuid", {'depuuid':data.value}, "#roleId", "uuid", "name");
        });

        //日期控件配置
        laydate.render({
            elem: 'input[name=birthday]',//选择器
            value: new Date(),//默认值
            max: 0//最大选择
        });
        //按钮监听
        //关闭按钮
        $("#btn_close").click(function () {
            close();
        });
        //自定义验证
        form.verify({
            username: function (value, item) { //value：表单的值、item：表单的DOM对象
                if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                    return '用户名不能有特殊字符';
                }
                if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if (/^\d+\d+\d$/.test(value)) {
                    return '用户名不能全为数字';
                }
                var data = ajax("personnel/emp/isRepetitionUsername", {
                    username:value
                });
                if (null == rowData || (null != rowData && rowData.username != value))
                    if (data.success)
                        return data.message;

            }
            , password: [
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ]
        });
        //提交按钮
        form.on('submit(btn_saveEmp)', function (data) {
            //获取form表单中的字段
            var field = data.field;//form表单字段{name:vlaue}
            console.log("员工"+field)
            //转换为int类型
            field.gender = parseInt(field.gender);
            field.depuuid = parseInt(field.depuuid);
            //转换为时间
            field.birthday = dateParseString(field.birthday);
            //判断是新增还是修改
            var url = "personnel/emp/insertEmp";
            if (isBlank(field.uuid))
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
function initEmpForm(row) {
    rowData = row;
    //初始化部门下拉
    initSelect("personnel/dep/queryDep", [], "#dep", "uuid", "name");
    initForm("emp", row);
    renderForm("select", "depuuid");
}