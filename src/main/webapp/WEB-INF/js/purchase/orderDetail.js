$(function () {

});

/**
 * 初始化表格
 * @param row
 */
function initOrderDetailForm(row) {
    row = JSON.parse(row);
    row.stateName = row.state == 0 ? "未确认" : "已确认"
    initTable(row);
    initForm("order", row);

}

// 初始化表格
function initTable(row) {
    // row=JSON.parse(row);
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            id: "orderDateilTable",
            elem: '#orderDateilTable',
            height: "full-200",
            url: 'purchase/queryOrdersDetailPager',
            title: "订单详情",
            where: {
                ordersId: row.ordersId
            },
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
                    title: '商品名称',
                    field: 'goodsName',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '商品价格',
                    field: 'price',
                    width: '10%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '商品数量',
                    field: 'num',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '金额',
                    field: 'money',
                    width: '8%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '采购员',
                    field: 'purchaseName',
                    width: '8%',
                    align: "center"
                },
                {
                    title: '采购日期',
                    field: 'purchaseDate',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '仓库名',
                    field: 'storeName',
                    width: '18%',
                    align: "center",
                    templet:function (data) {
                        if(data.state==1){
                            var str="<div>";
                            str+="<select name='store' id='store_"+data.detailId+"'><option></option></select>";
                            str+="</div>";
                            return str;
                        }

                        return null==data.storeName ? "" : data.storeName;
                    }
                },
                {
                    title: '入库员',
                    field: 'enderName',
                    width: '8%',
                    align: "center"
                },
                {
                    title: '入库日期',
                    field: 'enderDate',
                    width: '10%',
                    align: "center"
                },
                {
                    title: '订单状态',
                    field: 'state',
                    width: '8%',
                    align: "center",
                    templet: function (data) {
                        var state = data.state;
                        if (row.state == 0) {
                            state = "未确认";
                        } else if(state==2){
                            state="已入库";
                        } else {
                            var toolbar = "<div>";
                            var title = "";
                            var paraments = {
                                detailId:data.detailId
                            };
                            switch (state) {
                                case "0":
                                    title = "确认采购";
                                    paraments.state=1;
                                    break;
                                case "1":
                                    title = "确认入库";
                                    paraments.state=2
                                    paraments.storeId="store_"+data.detailId+" option:selected";
                                    paraments.goodsId=data.goodsId;
                                    paraments.num=data.num;
                                    break;
                            }
                            toolbar += '<span class="layui-badge  layui-bg-gray" style="margin-top: 5px;">';
                            toolbar += '<a href="javascript:alterOrdersDetailState('+JSON.stringify(paraments).replace(/\"/g,"'")+')" class="layui-btn layui-btn-xs">' + title + '</a>';
                            toolbar += "</div>";
                            state=toolbar;
                        }
                        return state;
                    }
                }
            ]],
            done: function (res, curr, count) {
                initSelect("basicJsp/store/StoreList",{},"select[name=store]","uuid","name");
                if (res.success == false)
                    msg(res.message)
            }
        });
    });
}

/**
 * 刷新表格
 */
function queryOrdersDateil() {
    layui.use('table', function () {
        var table = layui.table;
        table.reload('orderDateilTable', {
            url: 'purchase/queryOrdersDetailPager'
        });
    });
}

/**
 * 改变订单详情状态
 */
function alterOrdersDetailState(paraments) {
    if(isBlank(paraments.storeId)){
        if(!isBlank(getValue("#"+paraments.storeId))){
            msg("请选择仓库！");
            return;
        }
        paraments.storeId=getValue("#"+paraments.storeId);
        paraments.ordersId=getValue("input [name=ordersId]");
    }
    $.ajax({
        url: "purchase/alterOrdersDetailState",
        data: paraments,
        type: "post",
        dataType: "json",
        async: false,
        success: function (data) {
            msg(data.message);
            queryOrdersDateil();
        }
    });
}






