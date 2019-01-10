
/**
 * 获取值
 *
 * @param element
 * @returns
 */
function getValue(element) {
    return $(element).val();
}

/**
 * 获取文本
 *
 * @param element
 * @returns
 */
function getTest(element) {
    var elementType = $(element)[0].tagName.toLowerCase();
    if ("select" == elementType)
        return $(element+" option:selected").text();
    else
        return getValue(element);
}

function ajax(url,paraments) {
    var returnData;
    $.ajax({
        url: url,
        data: paraments,
        type: "post",
        dataType: "json",
        async: false,
        success: function (data) {
            returnData=data;
        }
    });
    return returnData;
}