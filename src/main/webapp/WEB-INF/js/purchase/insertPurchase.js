var uuid;
$(function () {
    layui.use('form', function () {
        var form = layui.form;
        form.on('select(supplier)', function (data) {
            uuid = data.value;
            if(!isBlank(data.value))
                return;
            $("#supplierDiv")[0].innerHTML="<input type='text' value='"+getTest("#supplier")+"' readonly='readonly' class='layui-input' /><input type='hidden' id='supplier' value='"+uuid+"' readonly='readonly' />";
        });
    });
    //新增商品
    $("#btn_insertOrderDetail").click(function () {
        openInsertOrderdetail();
    });
    //申请订单
    $("#btn_insertOrder").click(function () {
        insertOrder();
    });
    //初始化供应商
    initSelect("basicJsp/supplier/SupplierList", {}, "#supplier", "uuid", "name");
    initTable();
    colEdit();
});


// 初始化表格
function initTable() {
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            id: "orderDetailTable",
            elem: '#orderDetailTable',
            height: "full-160",
            data: [],
            title: "订单详情",
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
                    width: '20%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '商品价格',
                    field: 'price',
                    width: '20%',
                    sort: true,
                    align: "center"
                },
                {
                    title: '商品数量',
                    field: 'num',
                    width: '10%',
                    align: "center",
                    edit: "text"
                },
                {
                    title: '金额',
                    field: 'money',
                    width: '19%',
                    align: "center",
                    totalRow: true,
                    totalRowText: "总金额："
                },
                {
                    title: '操作',
                    field: 'state',
                    width: '30%',
                    align: "center",
                    templet: function (data) {
                        var toolbar = '<div>';
                        toolbar += getToolbar("删除", "void", 0 , "layui-icon layui-icon-delete","deleteOrderDetail");
                        toolbar += "</div>";
                        return toolbar;
                    }
                }
            ]],
            done: function (res, curr, count) {
                if (res.success == false)
                    msg(res.message)
            }
        });
        table.on('tool(orderDetailTable)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                layer.confirm('确定要删除'+obj.data.goodsName+'删除么?', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                });
        });
    });
}

/**
 * 添加新的一行
 */
function insertOrderdetail(data) {
    layui.use('table', function () {
        var table = layui.table;
        var oldData = table.cache["orderDetailTable"];
        oldData = oldData || new Array();
        var b = true;
        $(oldData).each(function (index, row) {
            if (data.goodsId == row.goodsId) {
                b = false;
                row.num = row.num + 1;
                row.money = row.num * row.price;
                oldData[index] = row;
                return false;
            }
        });
        if (b) {
            oldData.push(data);
        }
        table.reload('orderDetailTable', {
            data: oldData
        });
    });
}

/**
 * 打开新增商品订单界面
 * @param title
 * @param row
 * @param url
 */
function openInsertOrderdetail() {
    if (null == uuid) {
        msg("请选择供应商！！");
        return;
    }

    layui.use(['layer', 'form'], function () {
        var layer = layui.layer;
        var form = layui.form;
        layer.open({
            id: "orderDetail",
            title: "新增订单",
            type: 2,
            skin: 'layer-ext-myskin',
            anim: 1,
            offset: 'auto',
            area: ['300px', '300px'],
            content: 'purchase/toInsertOrderdetail',
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                var iframeWin = window[layero.find('iframe')[0]['name']];
                var goods=iframeWin.getGoods();
                if(!isBlank(goods)){
                    msg("请选择正确的商品！");
                    return;
                }
                var goods = JSON.parse(goods.replace(/'/g, "\""));
                var data = {
                    goodsId: goods.uuid,
                    goodsName: goods.name,
                    num: 1,
                    price: goods.inprice,
                    money: goods.inprice
                };
                insertOrderdetail(data);
                layer.close(index);
            },
            success: function (layero, index) {
                var iframeWin = window[layero.find('iframe')[0]['name']];
                iframeWin.initGoods(uuid);
            }
        });
    });
}

/**
 * 新增订单
 */
function insertOrder() {
    layui.use("table", function () {
        var table = layui.table;
        var orderDetails = [];
        $(table.cache["orderDetailTable"]).each(function (index, data) {
            delete data.LAY_TABLE_INDEX;
            orderDetails.push(JSON.stringify(data));
        });
        if(orderDetails.length==0){
            msg("请选择商品!!");
            return;
        }
        console.log(getValue("#supplier"));
        $.ajax({
            url: "purchase/insertOrder",
            data: {
                orderdetails:orderDetails,
                supplierId:getValue("#supplier")
            },
            type: "post",
            dateType: "json",
            async: false,
            cache : false,
            traditional: true,
            success: function (data) {
                parent.msg(data.message);
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.queryOrders();
                parent.layer.close(index); //再执行关闭
            }
        })
        ;
    });
}

/**
 * 监听单元格编辑事件
 */
function colEdit() {
    layui.use("table", function () {
        var table = layui.table;
        table.on('edit(orderDetailTable)', function (obj) {
            var row = obj.data;
            if (row.num == 0)
                obj.del();
            else {
                row.money = row.num * row.price;
                obj.update(row);
            }
        });
    });
}

