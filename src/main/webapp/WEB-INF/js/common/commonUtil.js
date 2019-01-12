
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


function getToolbar(title,functionName,paraments,icon) {
    paraments = JSON.stringify(paraments).replace(/\"/g, "'");
    var toolbar = '<span class="layui-badge  layui-bg-gray" style="margin-top: 5px;">';
    toolbar += '<a href="javascript:'+functionName+'(' + paraments + ');" >';
    toolbar += '<i title="'+title+'" class="'+icon+'"></i></a></span>';
}