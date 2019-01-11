/**
 * 初始下拉
 *
 * @returns
 */
function initSelect(url, parameters, element, value, text) {
    $.ajax({
        url: url,
        data: parameters,
        type: "post",
        dataType: "json",
        async: false,
        success: function (data) {
            $.each(data, function (index, data) {
                var option = $("<option>").val($(data).attr(value))
                    .text($(data).attr(text));
                $(element).append(option);
            });
            renderForm("select");
        }
    });
}

/**
 * form表单重新渲染
 * @param type
 * @param layFilter
 */
function renderForm(type,layFilter) {
    layui.use('form', function () {
        var form = layui.form;
        form.render(type,layFilter);
    });
}

/**
 * 获取复选框
 * @param name
 * @returns {string}
 */
function getCheckboxs(name) {
    var check_arr = "";
    $('input[name=' + name + ']:checked').each(function () {
        check_arr += ($(this).val())+",";
    });
    return check_arr;
}

/**
 * 弹出
 * @param message
 */
function msg(message) {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.msg(message);
    });
}

/**
 * 字符串转换为时间
 */
function dateParseString(date) {
    return new Date(date);
}

/**
 * 初始化form表单
 * @param layFilter
 * @param paraments
 */
function initForm(layFilter, paraments) {
    layui.use('form', function () {
        var form = layui.form;
        paraments=JSON.parse(JSON.stringify(paraments));
        form.val(layFilter, paraments);
    });
}


