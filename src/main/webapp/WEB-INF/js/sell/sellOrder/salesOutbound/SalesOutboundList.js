$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        querySellOrder({});
        // 给查询按钮绑定事件
        $("#btn_querySellOrder").click(function() {
            querySellOrderListSe();
        });
        form.render();
    });
});

function querySellOrder(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "querySellOrder2",
            elem: '#querySellOrder',
            url: 'sell/sellOrder/queryMarketPager', //数据接口
            where:parameters,
            page: true ,//开启分页
            title : "销售出库",
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
                {field: 'maid', title: '下单号', width:'10%', sort: true, align: 'center'},
                {field: 'markettime', title: '录入日期', width:'15%',align: 'center',
                    templet:function(data){
                        return getDateTime(data.markettime);
                    }
                },
                {field: 'chukutime', title: '下单日期', width:'15%',align: 'center',
                    templet:function (data) {
                        if(null==data.chukutime){
                            return "";
                        }else
                            return getDateTime(data.chukutime);
                    }
                },
                {field: 'empsalesman', title: '销售员', width:'10%',align: 'center'},
                {field: 'empender', title: '库管员', width:'12%',align: 'center'},
                {field: 'cname', title: '客户',edit:'number', width:'10%',align: 'center'},
                {field: 'totalmoney', title: '总金额', width:'10%',align: 'center'},
                {field: 'state', title: '订单状态', width:'10%',align: 'center'},
                {field: 'state', title: '操作', width:'8%',align: 'center',
                    templet : function(data) {
                        var row = JSON.stringify(data).replace(/\"/g, "'");
                        var toolbar='<a class="layui-btn layui-btn-danger layui-btn-xs" onclick="len('+row+')" ">出库</a>';
                        return toolbar;
                    }
                },

            ]],
            done : function(res, curr, count) {
                if(res.success==false)
                    layer.msg(res.message);
            }
        });

    });
}

function querySellOrderListSe(){
    layui.use('table', function() {
        var table = layui.table;
        var paraments = {
            'startcreatetime': getValue('#startcreatetime'),
            'endcreatetime': getValue('#endcreatetime'),
        };
        table.reload('querySellOrder2', {
            url: 'sell/sellOrder/queryMarketPager',
            where : paraments,
            page:{
                curr:1
            }
        });
    });
}

function len(row) {
    console.log(row);
    layui.use(['layer'], function() {
        var layer = layui.layer;
        layer.open({
            id : "lineitem",
            title : '订单详情',
            type : 2,
            anim : 1,
            shadeClose: false,
            shade: 0.8,
            btnAlign: 'c',
            offset : 'auto',
            area : [ '800px', '480px' ],
            content : 'sell/sellOrder/toSellParticulars',
            success : function(layero, index) {
                if(row){
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    iframeWin.initSellForm(row);
                    iframeWin.SellParticularsList({
                        'ordersuuid':row.maid
                    });
                }
            },
        });
    });
}
