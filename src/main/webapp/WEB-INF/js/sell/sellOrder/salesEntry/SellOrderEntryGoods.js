var rowData;
$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        goods({});
        // 给查询按钮绑定事件
        if (null == rowData)
            initSelect("basicJsp/supplier/SupplierList", [], "#supplieruuid", "uuid", "name");

        form.on('select(supplieruuid)', function(data){
            // $('#roleId').empty();
            goodsListSe();
        });
        // $("#btn_queryGoods").click(function() {
        //     goodsListSe();
        // });
        form.render();
    });
});

function goods(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "queryGoods2",
            elem: '#SellOrderEntryAdd',
            url: 'warehouse/storeDetail/queryStoredetailPager', //数据接口
            where:parameters,
            page: true ,//开启分页
            title : "商品页面",
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
                {field: 'uuid', title: '编号', width:'10%', align: 'center'},
                {field: 'gname', title: '商品名称', width:'13%',align: 'center'},
                // {field: 'sname', title: '仓库', width:'13%',align: 'center'},
                {field: 'quantity', title: '库存', width:'13%',align: 'center'},
                {field: 'outprice', title: '销售价格',width:'13%',align: 'center'},
                {field: 'count', title: '数量',edit:'number',  width:'12%',align: 'center'},
                {field: 'sumprice', title: '总价格',edit:'number',width:'12%',align: 'center',
                    // templet : function(data) {
                    //     var row = JSON.stringify(data).replace(/\"/g, "'");
                    //     // console.log(row);
                    //     // var f=(row.quantity)*(row.outprice);
                    //     // return f;
                    // }
                },
                {field: 'gtname', title: '商品类型', width:'15%',align: 'center'},
                {field: '', title: '操作', width: '12%',align: 'center',
                    templet : function(data) {
                        var row = JSON.stringify(data).replace(/\"/g, "'");
                        var toolbar='<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="save">加入订单</a>';
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
        table.on('tool(SellOrderEntryAdd)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'save'){ //删除
                layer.confirm('确认加入'+data.gname+'商品入销售订单吗?', function(index){
                    params={
                        supplieruuid:data.supplieruuid,
                        // totalmoney:data.sumprice,
                        goodsuuid:data.goodsuuid,
                        price:data.outprice,
                        num:data.count,
                        money:data.sumprice,
                        storeuuid:data.storeuuid,
                    }
                    console.log(params);
                    $.ajax({
                        url : '',
                        data : [],
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

function goodsListSe(){
    layui.use('table', function() {
        var table = layui.table;
        var paraments = {
            'supplieruuid': getValue('#supplieruuid'),
        };
        table.reload('queryGoods2', {
            url: 'warehouse/storeDetail/queryStoredetailPager',
            where : paraments,
            page:{
                curr:1
            }
        });
    });
}

//模态框
// function openModak(){
//     console.log("ni");
//     // $("[name='testname']").val("xxxxxxxxxxxxxxx");//向模态框中赋值
//     layui.use(['layer'],function () {
//         var layer = layui.layer,
//             $=layui.$;
//         layer.open({
//             type:1,//类型
//             area:['400px','300px'],//定义宽和高
//             title:'查看详细信息',//题目
//             shadeClose:false,//点击遮罩层关闭
//             content: $('#motaikunag')//打开的内容
//         });
//     })
// }

function SellOrderEntryAdd() {
    layui.use('layer', function() {
        var layer = layui.layer;
        layer.open({
            // id : "invenAdd",
            title : "商品页面",
            type : 2,
            anim : 1,
            shadeClose: false,
            shade: 0.8,
            btnAlign: 'c',
            offset : 'auto',
            area : [ '850px', '480px' ],
            // area : [ 宽, 高 ],
            content : 'sell/sellOrder/salesEntry/toSellOrderEntryGoods',
        });
    });
}