/**
 * 初始下拉
 *
 * @returns
 */
function initSelect(url,parameters,element,value,text) {
    $.ajax({
        url : url,
        data : parameters,
        type : "post",
        dataType : "json",
        async : false,
        success : function(data) {
            $.each(data, function(index, data) {
                var option = $("<option>").val($(data).attr(value))
                    .text($(data).attr(text));
                $(element).append(option);
            });
        }
    });
}