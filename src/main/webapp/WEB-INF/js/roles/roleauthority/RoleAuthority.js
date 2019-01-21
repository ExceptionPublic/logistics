$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        rolelist({});
        // 给查询按钮绑定事件
        $("#btn_RoleAuthority").click(function() {
            roleListSe();
        });
        form.render();
    });
});

function rolelist(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "queryRoles",
            elem: '#RoleAuthority',
            // height: 312,
            url: 'roles/role/queryRolePager', //数据接口
            where:parameters,
            page: true ,//开启分页
            title : "角色权限设置",
            method : "post",
            // toolbar: '#toolbarDemo',//这是个神奇的标签
            text : {
                none : '对不起，暂无此类数据'
            },
            request : {
                // pageName : 'page',
                limitName : 'rows'
            },
            cols: [[ //表头
                {field: 'uuid', title: '编号', width:'10%', sort: true, align: 'center'},
                {field: 'name', title: '名称', width:'15%',align: 'center'},
            ]],
            done : function(res, curr, count) {
                if(res.success==false)
                    layer.msg(res.message);
            }

        });
    });
}

function roleListSe(){
    layui.use('table', function() {
        var table = layui.table;

        var paraments = {
            'name': getValue('#name'),
        };
        console.log(paraments)
        console.log(table)
        table.reload('queryRoles', {
            url : 'roles/role/queryRolePager',
            where : paraments,
            page:{
                curr:1
            }
        });
    });
}

