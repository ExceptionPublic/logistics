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
}