$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        store({});
        // 给查询按钮绑定事件
        $("#btn_queryStore").click(function() {
            storeListSe();
        });
        $("#btn_storeAdd").click(function() {
            storeAdd("新增仓库",null);
        });
        form.render();
    });
});

function store(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "queryStores",
            elem: '#queryStore',
            // height: 312,
            url: '/basicJsp/store/queryStorePager', //数据接口
            where:parameters,
            page: true ,//开启分页
            title : "是",
            method : "post",
            // toolbar: '#toolbarDemo',//这是个神奇的标签
            text : {
                none : '对不起，暂无此类数据'
            },
            request : {
                // pageName : 'page',
                limitName : 'rows'
            },
            // response : {
            //     statusName : 'status' // 规定数据状态的字段名称，默认：code
            //     ,
            //     statusCode : 200 // 规定成功的状态码，默认：0
            //     ,
            //     msgName : 'hint' // 规定状态信息的字段名称，默认：msg
            //     ,
            //     countName : 'total' // 规定数据总数的字段名称，默认：count
            //     ,
            //     dataName : 'rows' // 规定数据列表的字段名称，默认：data
            // },
            cols: [[ //表头
                {field: 'uuid', title: '仓库编号', width:'10%', sort: true, align: 'center'},
                {field: 'name', title: '仓库名称', width:'15%',align: 'center'},
                {field: 'address', title: '仓库地址',edit:'text', width:'20%',align: 'center'},
                {field: 'ename', title: '仓库管理员',edit:'text', width:'15%',align: 'center'},
                {field: '', title: '操作', width: '15%',align: 'center',
                    templet : function(data) {
                        var row = JSON.stringify(data).replace(/\"/g, "'");
                        var toolbar='<div >';
                        toolbar+='<a href="javascript:storeAdd(\'修改' + data.name + '信息\',' + row + ');" class="layui-btn layui-btn-xs">';
                        toolbar += '编辑</a>';
                        toolbar+='<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                        toolbar+='</div>';
                        return toolbar;
                    }
                },
            ]],
            done : function(res, curr, count) {
                if(res.success==false)
                    layer.msg(res.message);
            }

        });
        //头工具栏事件
        // 监听工具条
        table.on('tool(queryStore)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除'+data.name+'么?', function(index){
                    $.ajax({
                        url : '/basicJsp/store/storeDel',
                        data : data,
                        dataType : "json",
                        async : false,
                        type : "post",
                        success : function(data) {
                            layer.msg(data.message);
                            if (data.success) {
                                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                layer.close(index); //向服务端发送删除指令
                            }

                        }
                    });

                });
            }
        });

    });
}

function storeListSe(){
    layui.use('table', function() {
        var table = layui.table;

        var paraments = {
            'name': getValue('#name'),
            'address': getValue('#address'),
        };
        table.reload('queryStores', {
            url : '/basicJsp/store/queryStorePager',
            where : paraments,
            page:{
                curr:1
            }
        });
    });
}



function storeAdd(titile,row) {
    layui.use('layer', function() {
        var layer = layui.layer;
        layer.open({
            id : "storeEdit",
            title : titile,
            type : 2,
            anim : 1,
            shadeClose: false,
            shade: 0.8,
            btnAlign: 'c',
            offset : 'auto',
            area : [ '400px', '300px' ],
            content : '/basicJsp/store/tostoreEdit',
            success : function(layero, index) {
                if(row){
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    iframeWin.initStoForm(row);
                }
            },

        });
    });
}

