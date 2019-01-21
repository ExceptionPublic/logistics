$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        goodsType({});
        // 给查询按钮绑定事件
        $("#btn_queryGoodsType").click(function() {
            goodsTypeListSe();
        });
        $("#btn_queryGoodsType").click(function() {
            goodsTypeListSe("新增类型",null);
        });
        form.render();
    });
});

function goodsType(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "queryGoodsTypes",
            elem: '#queryGoodsType',
            // height: 312,
            url: '/basicJsp/goodstype/goodsTypeLst', //数据接口
            where:parameters,
            page: true ,//开启分页
            title : "商品类型页面",
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
                {field: 'uuid', title: '编号', width:'10%', sort: true, align: 'center'},
                {field: 'name', title: '名称', width:'15%',align: 'center'},
                {field: '', title: '操作', width: '15%',align: 'center',
                    templet : function(data) {
                        var row = JSON.stringify(data).replace(/\"/g, "'");
                        var toolbar='<div >';
                        toolbar+='<a href="javascript:GoodsTyAdd(\'修改' + data.name + '信息\',' + row + ');" class="layui-btn layui-btn-xs">';
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
        table.on('tool(queryGoodsType)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除'+data.name+'么?', function(index){
                    $.ajax({
                        url : '/basicJsp/goodstype/goodsTypeDel',
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

function goodsTypeListSe(){
    layui.use('table', function() {
        var table = layui.table;

        var paraments = {
            'name': getValue('#name'),
        };
        console.log(paraments)
        console.log(table)
        table.reload('queryGoodsTypes', {
            url : '/basicJsp/goodstype/goodsTypeLst',
            where : paraments,
            page:{
                curr:1
            }
        });
    });
}



function GoodsTyAdd(title,row) {
    layui.use('layer', function() {
        var layer = layui.layer;
        layer.open({
            id : "goodsTypeAdd",
            title : title,
            type : 2,
            anim : 1,
            shadeClose: false,
            shade: 0.8,
            btnAlign: 'c',
            offset : 'auto',
            area : [ '350px', '250px' ],
            content : '/basicJsp/goodstype/togoodstypeAdd',
            success : function(layero, index) {
                if(row){
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    iframeWin.initGtpForm(row);
                }
            },




            // btn : [ '保存','关闭' ],
            // yes :function(index, layero) {
            //     goodsType();
            //
            //     // 获取表单 byid添id
            //     var form = layero.find("iframe")[0].contentWindow.document.getElementById("goodsTypeAdd")
            //     // 获取表单数据
            //     var data = $(form).serializeArray();
            //     $.ajax({
            //         url : '/basicJsp/goodsTypeAdd',
            //         data : data,
            //         dataType : "json",
            //         async : false,
            //         type : "post",
            //         success : function(data) {
            //             layer.msg(data.message);
            //             if (data.success) {
            //                 goodsType();
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

