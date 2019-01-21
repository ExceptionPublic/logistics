$(function () {
    layui.use('form', function () {
        var form = layui.form;
    });
    initSelect("personnel/dep/queryDep", [], "#dep", "uuid", "name");
    //初始化表格
    initTable();
    //查询按钮
    $("#btn_queryEmp").click(function () {
        queryEmp();
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
            title: "用户角色设置",
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
                    title: '角色',
                    field: 'rname',
                    width: '6%',
                    align: "center"
                },
                {
                    title: '出生日期',
                    field: 'birthday',
                    width: '10%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '电话',
                    field: 'tele',
                    width: '10%',
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
                        toolbar+='<a href="javascript:openPwdEmp(\'修改' + data.name + '密码\',' + row + ');" class="layui-btn layui-btn-xs">';
                        toolbar += '编辑密码</a>';
                        toolbar += '</div>';
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
 * 修改界面
 * @param title
 * @param row
 * @param url
 */
function openPwdEmp(title, row) {
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer;
        var form = layui.form;
        layer.open({
            id: "rolepwdEdit",
            title: title,
            type : 2,
            anim : 1,
            shadeClose: false,
            shade: 0.8,
            btnAlign: 'c',
            offset : 'auto',
            area : [ '350px', '170px' ],
            content: 'roles/rolepwd/RolepwdEdit',
            success: function (layero, index) {
                if (row) {
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    iframeWin.initRolepwdForm(row);
                }
            }
        });
    });
}
