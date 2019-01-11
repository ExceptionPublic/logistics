$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        supplier({});
        // 给查询按钮绑定事件
        $("#btn_querySupplier").click(function() {
            supplierListSe();
        });
        form.render();
    });
});

function supplier(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "querySuppliers",
            elem: '#querySupplier',
            // height: 312,
            url: '/basicJsp/supplier/queryLstSupplier', //数据接口
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
                {field: 'uuid', title: '编号', width:'5%', sort: true, align: 'center'},
                {field: 'name', title: '供应商', width:'15%',align: 'center'},
                {field: 'address', title: '地州(点击编辑)',edit:'text', width:'20%',align: 'center'},
                {field: 'contact', title: '联系人',edit:'text', width:'15%',align: 'center'},
                {field: 'tele', title: '电话', width:'15%',align: 'center'},
                {field: 'email', title: 'EMAIL', width:'15%',align: 'center'},
                {field: '', title: '操作', width: '15%',align: 'center',
                    templet : function(data) {
                        var row = JSON.stringify(data).replace(/\"/g, "'");
                        var toolbar='<div >';
                        toolbar+='<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="save">保存</a>';
                        toolbar+='<a class="layui-btn layui-btn-xs" onclick="goodsedit('+row+');">编辑</a>';
                        toolbar+='<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                        toolbar+='</div>';
                        return toolbar;
                    }
                },
            ]],
            // done : function(res, curr, count) {
            //     if(res.success==false)
            //         layer.msg(res.message);
            // }

        });
        //头工具栏事件
        // 监听工具条
        table.on('tool(querySupplier)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除'+data.name+'么?', function(index){
                    $.ajax({
                        url : '/basicJsp/supplier/SupplierDel',
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
            }else if(layEvent=='update'){
                layer.confirm('确定修改吗?',function (index) {
                    $.ajax({
                        url:'/basicJsp/supplier/supplierUpdate',
                        data:data,
                        dataType : "json",
                        async : false,
                        type : "post",
                        success : function(data) {
                            layer.msg(data.message);
                            if (data.success) {
                                obj.update(); //同步更新缓存对应的值
                                layer.close(index); //向服务端发送指令
                            }

                        }
                    })
                })

            }
        });

    });
}

function supplierListSe(){
    layui.use('table', function() {
        var table = layui.table;

        var paraments = {
            'name': getValue('#name'),
            'address': getValue('#address'),
        };
        table.reload('querySuppliers', {
            url : '/basicJsp/supplier/queryLstSupplier',
            where : paraments
        });
    });
}



function SupplierAdd() {
    layui.use('layer', function() {
        var layer = layui.layer;
        layer.open({
            id : "supplierAdd",
            title : "新增供应商",
            type : 2,
            anim : 1,
            shadeClose: false,
            shade: 0.8,
            btnAlign: 'c',
            offset : 'auto',
            area : [ '400px', '430px' ],
            content : '/basicJsp/supplier/tosupplierAdd',
            // btn : [ '保存','关闭' ],
            // yes :function(index, layero) {
            //     supplier();
            //     // 获取表单 byid添id
            //     var form = layero.find("iframe")[0].contentWindow.document.getElementById("supplierAdd")
            //     // 获取表单数据
            //     var data = $(form).serializeArray();
            //     $.ajax({
            //         url : '/basicJsp/supplier/supplierAdd',
            //         data : data,
            //         dataType : "json",
            //         async : false,
            //         type : "post",
            //         success : function(data) {
            //             layer.msg(data.message);
            //             if (data.success) {
            //                 supplier();
            //                 layer.close(index);
            //             }
            //
            //         }
            //
            //     });
            //
            // },

        });
    });
}
//   /basicJsp/goodsTypeAdd

