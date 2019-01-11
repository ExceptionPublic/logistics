$(function () {
    layui.use('form', function () {
        var form = layui.form;
    });

    //初始化表格
    initTable();
    //初始化部门下拉
    initSelect("personnel/dep/queryDep", [], "#dep", "uuid", "name");
    //按钮监听
    //查询按钮
    $("#btn_queryEmp").click(function () {
        queryEmp();
    });
    //新增按钮
    $("#btn_insertEmp").click(function () {
        openInsertOrUpdateEmp("新增员工", null);
    });
});

// 查询
function queryEmp() {
    layui.use('table', function () {
        var table = layui.table;
        var paraments = {
            genders: getCheckboxs("gender"),
            name: getValue("#name"),
            depuuid: getValue("#dep")
        };
        table.reload('empTable', {
            url: 'personnel/emp/queryEmpPager',
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
            id: "empTable",
            elem: '#empTable',
            height: "full-80",
            url: 'personnel/emp/queryEmpPager',
            title: "员工信息",
            page: true,
            limit: 10,
            limits: [10, 15, 20],
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
                    title: '登陆用户名',
                    field: 'username',
                    width: '8%',
                    align: "center"
                },
                {
                    title: '真实姓名',
                    field: 'name',
                    width: '8%',
                    align: "center"
                },
                {
                    title: '性别',
                    field: 'gender',
                    width: '5%',
                    align: "center",
                    templet: function (data) {
                        return data.gender == 0 ? "男" : "女";
                    }
                },
                {
                    title: '所属部门',
                    field: 'depName',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '出生日期',
                    field: 'birthday',
                    width: '13%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '电话',
                    field: 'tele',
                    width: '13%',
                    align: "center"
                },
                {
                    title: '邮箱',
                    field: 'email',
                    width: '13%',
                    align: "center"
                },
                {
                    title: '地址',
                    field: 'address',
                    width: '13%',
                    align: "center"
                },
                {
                    title: '操作',
                    width: '13%',
                    field: "",
                    align: "center",
                    templet: function (data) {
                        var row = JSON.stringify(data).replace(/\"/g, "'");
                        var toolbar = '<div >';
                        toolbar += '<span class="layui-badge  layui-bg-gray" style="margin-top: 5px;">';
                        toolbar += '<a href="javascript:openInsertOrUpdateEmp(\'修改' + data.name + '信息\',' + row + ');" >';
                        toolbar += '<i title="编辑" class="layui-icon layui-icon-edit"></i></a></span>';
                        toolbar += '<span class="layui-badge  layui-bg-gray" style="margin-left: 10px;margin-top: 5px;">';
                        toolbar += '<a href="javascript:deleteEmp(' + row + ');">';
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
 * 打开员工新增或修改界面
 * @param title
 * @param row
 * @param url
 */
function openInsertOrUpdateEmp(title, row) {
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer;
        var form = layui.form;
        layer.open({
            id: "emp",
            title: title,
            type: 2,
            anim: 1,
            offset: 'auto',
            area: ['1000px', '600px'],
            content: 'personnel/emp/toInsertOrUpdateEmp',
            success: function (layero, index) {
                if (row) {
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    iframeWin.initEmpForm(row);
                }
            }
        });
    });
}

/**
 * 删除员工
 * @param uuid
 */
function deleteEmp(row) {
    layer.confirm('确定删除' + row.name + '员工吗？', function (index) {
        $.ajax({
            url: "personnel/emp/deleteEmp",
            data: row,
            type: "post",
            dataType: "json",
            success: function (data) {
                msg(data.message);
                queryEmp();
            }
        });
        layer.close(index);
    });
}