$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        // SellParticularsList({});
        // 给查询按钮绑定事件
        // $("#btn_queryGoods").click(function() {
        //     SellParticularsListSe();
        // });
        form.render();
    });
});

function SellParticularsList(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "queryGoods2",
            elem: '#SellLineItem',
            // height: 312,
            url: 'sell/sellOrder/salesOutbound/queryMarketMap', //数据接口
            where:parameters,
            title : "商品页面",
            method : "post",
            // toolbar: '#toolbarDemo',//这是个神奇的标签
            text : {
                none : '对不起，暂无此类数据'
            },
            cols: [[ //表头
                {field: 'uuid', title: '编号', width:'10%', sort: true, align: 'center'},
                {field: 'goodsuuid', title: '商品编号', width:'15%',align: 'center'},
                {field: 'gname', title: '商品名称', width:'20%',align: 'center'},
                {field: 'price', title: '价格', width:'10%',align: 'center'},
                {field: 'num', title: '数量', width:'10%',align: 'center'},
                {field: 'money', title: '金额', width:'10%',align: 'center'},
                {field: 'state', title: '状态', width:'15%',align: 'center'},
                {field: '', title: '操作', width: '10%',align: 'center',
                    templet : function(data) {
                        var row = JSON.stringify(data).replace(/\"/g, "'");
                        var toolbar='<div >';
                        toolbar+='<a href="javascript:SellParticulars(' + row + ');" class="layui-btn layui-btn-xs">出库</a>';
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
    });
}

// function SellParticularsListSe(){
//     layui.use('table', function() {
//         var table = layui.table;
//
//         var paraments = {
//             'name': getValue('#name'),
//             // 'address': getValue('#address'),
//         };
//         table.reload('queryGoods2', {
//             url: 'sell/sellOrder/salesOutbound/queryMarketMap',
//             where : paraments,
//             page:{
//                 curr:1
//             }
//         });
//     });
// }


function SellParticulars(row) {
    // console.log(row.goodstypeuuid);
    layui.use([ 'layer'], function() {
        var layer = layui.layer;
        layer.open({
            id : "goodsEdit",
            title : "订单明细",
            type : 2,
            anim : 1,
            shadeClose: false,
            shade: 0.8,
            btnAlign: 'c',
            offset : 'auto',
            area : [ '400px', '480px' ],
            content : 'basicJsp/goods/togoodsEdit',
            success : function(layero, index) {
                if(row){
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    iframeWin.initGoodsForm(row);
                }
            },
        });
    });
}


function initSellForm(data) {
    rowData = data;
    //初始化部门下拉
    initForm("lineitem", data);
}