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

/**
 * 进行时间补零
 *
 * @param num
 * @returns
 */
function getzf(num) {
    if (parseInt(num) < 10) {
        num = '0' + num;
    }
    return num;
}
/**
 * 时间搓转换为时间 带小时分秒
 *
 * @param str
 * @returns
 */
function getDateTime(str) {
    var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
        .getMonth() + 1, oDay = oDate.getDate(), oHour = oDate.getHours(), oMin = oDate
        .getMinutes(), oSen = oDate.getSeconds(), oTime = oYear + '-'
        + getzf(oMonth) + '-' + getzf(oDay) + ' ' + getzf(oHour) + ':'
        + getzf(oMin) + ':' + getzf(oSen);// 最后拼接时间
    return oTime;
};

/**
 * 时间搓转换为时间 不带小时分秒
 *
 * @param str
 * @returns
 */
function getDate(str) {
    var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
        .getMonth() + 1, oDay = oDate.getDate(), oTime = oYear + '-'
        + getzf(oMonth) + '-' + getzf(oDay);
    return oTime;
};