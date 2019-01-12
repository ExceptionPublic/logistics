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
                    field: 'createtime',
                    width: '20%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '审核日期',
                    field: 'checktime',
                    width: '20%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '下单员',
                    field: 'creater',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '审查员',
                    field: 'checker',
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
                    field: 'totalmoney',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '订单状态',
                    field: 'state',
                    width: '8%',
                    align: "center",
                    templet: function (data) {
                        var toolbar = '<div >';
                        toolbar+=getToolbar("删除订单","deleteOrders",{
                            uuid:data.uuid
                        },"layui-icon layui-icon-delete");
                        toolbar+=getToolbar("审核通过","alterOrdersState",{
                            state:"1"
                        },"layui-icon layui-icon-ok-circle");
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
 * 表格双击事件
 */
function tableDouble() {
    layer.use('table',function(){
        var table = layui.table;
        table.on('rowDouble(test)', function(obj){
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.open({
                    id: "dep",
                    title: "申请采购",
                    type: 2,
                    anim: 1,
                    offset: 'auto',
                    area: ['1200px', '800px'],
                    content: 'purchase/toInsertPurchase',
                    success:function (layero, index) {
                        // obj.data当前数据

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
            area: ['1200px', '800px'],
            content: 'purchase/toInsertPurchase'
        });
    });
}