var rootPath;
$(function() {
	rootPath = $("#adsoluetPath").val();
});


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