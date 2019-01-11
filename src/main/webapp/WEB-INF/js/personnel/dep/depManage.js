$(function () {
    //初始化表格
    initTable();
    //按钮监听
    //查询按钮
    $("#btn_queryDep").click(function () {
        queryDep();
    });
    //新增按钮
    $("#btn_insertDep").click(function () {
        openInsertOrUpdateDep("新增部门", null);
    });
});

// 查询
function queryDep() {
    layui.use('table', function () {
        var table = layui.table;
        var paraments = {
            name: getValue("#name")
        };
        table.reload('depTable', {
            url: 'personnel/dep/queryDepPager',
            where: paraments,
            page: {
                curr: 1
            }
        });
    });
}

// 初始化表格
function initTable() {
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            id: "depTable",
            elem: '#depTable',
            height: "full-80",
            url: 'personnel/dep/queryDepPager',
            title: "部门信息",
            page: true,
            limit: 3,
            limits: [3, 20, 25],
            request: {
                limitName: 'rows' //每页数据量的参数名，默认：limit
            },
            method: "post",
            text: {
                none: '对不起，暂无此类数据'
            },
            cols: [[ // 表头
                {
                    title: "序号",
                    field: 'uuid',
                    align: "center"
                },
                {
                    title: '部门名称',
                    field: 'name',
                    width: '20%',
                    align: "center"
                },
                {
                    title: '部门电话',
                    field: 'tele',
                    width: '35%',
                    align: "center"
                },
                {
                    title: '部门人数',
                    field: 'empCount',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '操作',
                    width: '30%',
                    field: "",
                    align: "center",
                    templet: function (data) {
                        var row = JSON.stringify(data).replace(/\"/g, "'");
                        var toolbar = '<div >';
                        toolbar += '<span class="layui-badge  layui-bg-gray" style="margin-top: 5px;">';
                        toolbar += '<a href="javascript:openInsertOrUpdateDep(\'修改' + data.name + '部门信息\',' + row + ');" >';
                        toolbar += '<i title="编辑" class="layui-icon layui-icon-edit"></i></a></span>';
                        toolbar += '<span class="layui-badge  layui-bg-gray" style="margin-left: 10px;margin-top: 5px;">';
                        toolbar += '<a href="javascript:deleteDep(' + row + ');">';
                        toolbar += '<i title="删除" class="layui-icon layui-icon-close"></i></a></span>';
                        toolbar += '</div>';
                        console.log();
                        return toolbar;
                    }
                }
            ]],
            done: function (res, curr, count) {
                if (res.success == false)
                    msg(res.message)
            }
        });
    });
}

/**
 * 打开部门新增或修改界面
 * @param title
 * @param row
 * @param url
 */
function openInsertOrUpdateDep(title, row) {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.open({
            id: "dep",
            title: title,
            type: 2,
            anim: 1,
            offset: 'auto',
            area: ['400px', '250px'],
            content: 'personnel/dep/toInsertOrUpdateDep',
            success: function (layero, index) {
                if (row) {
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    iframeWin.initDepForm(row);
                }
            }
        });
    });
}


/**
 * 删除部门
 * @param uuid
 */
function deleteDep(row) {
    layer.confirm('确定删除' + row.name + '部门吗？', function (index) {
        $.ajax({
            url: "personnel/dep/deleteDep",
            data: row,
            type: "post",
            dataType: "json",
            success: function (data) {
                msg(data.message);
                queryDep();
            }
        });
        layer.close(index);
    });
}