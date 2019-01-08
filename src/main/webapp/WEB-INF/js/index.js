//动态加载导航条
/*
$(function() {
	// initTree();
});

function initTree() {
	$.ajax({
		url : "rightAction_queryUserRight.action",
		data : {},
		dataType : "json",
		type : "post",
		success : function(data) {
			layui.use('tree', function() {
				layui.tree({
					elem : '#tree',
					nodes : data,
					click : function(node) {
						if(node.type!='Folder')
							open(node);
					}
				});
			});
		}
	});
}

function open(node) {
	var id = node.id;
	var title = node.name;
	var content = node.url;
	var exist = $("li[lay-id='" + id + "']").length; // 判断是否存在tab
	if (exist == 0) {
		element.tabAdd('demo', {
			title : title,
			autoRefresh : true,
			content : '<iframe data-frameid="' + id
					+ '" scrolling="auto" frameborder="0" src="' + content
					+ '" style="width:100%;"></iframe>',
			id : id
		});
		calculate();
	}
	element.tabChange('demo', id);
}

function calculate() {
	FrameWH();

	function FrameWH() {
		var h = $(window).height() - 185;
		$("iframe").css("height", h + "px");
	}

	$(window).resize(function() {
		FrameWH();
	});
}*/

//静态加载导航条
$(function () {
    layui.use('element', function () {
        var element = layui.element;
        $(".open").click(function () {
            open($(this),element);
        });
    });
});

function open(node,element) {
    var id = node.attr('id');
    var title = node.text();
    var content = node.attr('lay-url');
    var exist = $("li[lay-id='" + id + "']").length; // 判断是否存在tab
    if (exist == 0) {
        element.tabAdd('demo', {
            title: title,
            autoRefresh: true,
            content: '<iframe data-frameid="' + id
            + '" scrolling="auto" frameborder="0" src="' + content
            + '" style="width:100%;"></iframe>',
            id: id
        });
        calculate();
    }
    element.tabChange('demo', id);

}

function calculate() {
    FrameWH();

    function FrameWH() {
        var h = $(window).height() - 185;
        $("iframe").css("height", h + "px");
    }

    $(window).resize(function () {
        FrameWH();
    });
}
