$(function () {
    layui.use('form', function () {
        var form = layui.form;
    });

    //初始化表格
    initTable();
    //初始化部门下拉
    // initSelect("personnel/dep/queryDep", [], "#dep", "uuid", "name");
    //按钮监听
    //查询按钮
    $("#btn_queryPurchase").click(function () {
        queryOrders();
    });
    //新增按钮
    $("#btn_purchase").click(function () {
        openInsertPurchase();
    });

    tableDouble();
});

// 初始化表格
function initTable() {
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            id: "purchaseTable",
            elem: '#purchaseTable',
            height: "full-160",
            url: 'purchase/queryOrdersPager',
            title: "采购订单",
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
                    title: '创建日期',
                    field: 'createDate',
                    width: '20%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '确认日期',
                    field: 'checkerDate',
                    width: '20%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '下单员',
                    field: 'createName',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '审查员',
                    field: 'checkerName',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '供应商',
                    field: 'supplierName',
                    width: '20%',
                    align: "center"
                },
                {
                    title: '总金额',
                    field: 'totalMoney',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '订单操作',
                    field: 'state',
                    width: '10%',
                    align: "center",
                    templet: function (data) {
                        var state=data.state;
                        if(state==0){
                            var toolbar = '<div >';
                            toolbar+=getToolbar("取消订单","deleteOrder",data.ordersId,"layui-icon layui-icon-delete");
                            toolbar+=getToolbar("确认订单","alterOrdersState",{
                                ordersId:data.ordersId,
                                state:"1"
                            },"layui-icon layui-icon-ok-circle");
                            toolbar += '</div>';
                            return toolbar;
                        }else if(state==2){
                            var toolbar = '<div >';
                            toolbar+=getToolbar("退货","alterOrdersState",{
                                ordersId:data.ordersId,
                                state:"3"
                            },"layui-icon layui-icon-ok-circle");
                            toolbar += '</div>';
                            return toolbar;
                        }
                        return state=="1" ? "已确认" : state=="3"? "正在退货中！" :state=="4" ?"已退回":"未知";
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
 * 表格双击事件
 */
function tableDouble() {
    layui.use('table',function(){
        var table = layui.table;
        table.on('rowDouble(purchaseTable)', function(obj){
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.open({
                    id: "dep",
                    title: "订单详情",
                    type: 2,
                    anim: 1,
                    offset: 'auto',
                    area: ['1200px', '700px'],
                    content: 'purchase/toOrderDetail',
                    success:function (layero, index) {
                        // obj.data当前数据
                        var iframeWin = window[layero.find('iframe')[0]['name']];
                        iframeWin.initOrderDetailForm(JSON.stringify(obj.data));
                    }
                });
            });
        });
    });
}

// 查询
function queryOrders() {
    layui.use('table', function () {
        var table = layui.table;
        var paraments = {

        };
        table.reload('purchaseTable', {
            url: 'purchase/queryOrdersPager',
            where: paraments,
            page: {
                curr: 1
            }
        });
    });
}

/**
 * 改变订单状态
 */
function alterOrdersState(paraments) {
    $.ajax({
        url: "purchase/alterOrdersState",
        data: paraments,
        type: "post",
        dataType: "json",
        async: false,
        success: function (data) {
            msg(data.message);
            queryOrders();
        }
    });
}


/**
 * 申请采购
 * @param title
 * @param row
 */
function openInsertPurchase() {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.open({
            id: "dep",
            title: "申请采购",
            type: 2,
            anim: 1,
            offset: 'auto',
            area: ['1200px', '700px'],
            content: 'purchase/toInsertPurchase'
        });
    });
}


/**
 * 取消订单
 */
function deleteOrder(ordersId) {
    layer.confirm('确定取消此订单么?', function(index){
        $.ajax({
            url: "purchase/deleteOrder",
            data: {
                ordersId:ordersId
            },
            type: "post",
            dataType: "json",
            async: false,
            success: function (data) {
                msg(data.message);
                //关闭
                layer.close(index);
                queryOrders();
            }
        });

    });

}