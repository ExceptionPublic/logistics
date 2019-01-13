var rowData;
$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        //初始化部门
        if (null == rowData)
            // initSelect("basicJsp/store/StoreList", [], "#storeuuid", "uuid", "name");
            initSelect("basicJsp/goods/queryGoods", [], "#goodsuuid", "uuid", "name");
        inventory({});
        // 给查询按钮绑定事件
        $("#btn_queryInvenregister").click(function() {
            invenListSe();
        });
        form.render();
    });
});

function inventory(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "queryInvenregister2",
            elem: '#queryInvenregister',
            // height: 312,
            url: 'warehouse/inventory/queryInventoryPager', //数据接口
            where:parameters,
            page: true ,//开启分页
            title : "是",
            method : "post",
            // toolbar: '#toolbarDemo',//这是个神奇的标签
            text : {
                none : '对不起，暂无此类数据'
            },
            request : {
                limitName : 'rows'
            },
            cols: [[ //表头
                {field: 'uuid', title: '编号', width:'5%', align: 'center'},
                {field: 'type', title: '类型', width:'5%',align: 'center'},
                {field: 'pname', title: '登记人', width:'5%',align: 'center'},
                {field: 'shname', title: '审核人', width:'5%',align: 'center'},
                {field: 'dname', title: '状态', width:'5%',align: 'center'},
                {field: 'num', title: '库存数量', width:'7%',align: 'center'},
                {field: 'gname', title: '商品名称', width:'8%',align: 'center'},
                {field: 'sname', title: '仓库名称', width:'10%',align: 'center'},
                {field: 'createtime', title: '登记日期', width:'25%',align: 'center',
                    templet : function(data) {
                        return dateParseString(data.createtime);
                    }
                },
                {field: 'checktime', title: '审核日期', width:'25%',align: 'center',
                    templet : function(data) {
                        return dateParseString(data.checktime);
                    }
                },
            ]],
            done: function (res, curr, count) {
                if (res.success == false)
                    msg(res.message)
            }
        });
    });
}

function invenListSe(){
    layui.use('table', function() {
        var table = layui.table;
        var paraments = {
            type: getValue('#type '),
            goodsuuid: getValue('#goodsuuid'),
            // 'createtime': getValue('#createtime'),
        };
        console.log(paraments.createtime);
        table.reload('queryInvenregister2', {
            url: 'warehouse/inventory/queryInventoryPager',
            where : paraments,
            page:{
                curr:1
            }
        });
    });
}

function InvenAdd() {
    layui.use('layer', function() {
        var layer = layui.layer;
        layer.open({
            id : "invenAdd",
            title : "新增盘盈盘亏",
            type : 2,
            anim : 1,
            shadeClose: false,
            shade: 0.8,
            btnAlign: 'c',
            offset : 'auto',
            area : [ '400px', '480px' ],
            // area : [ 宽, 高 ],
            content : 'warehouse/inventory/toInvenAddRegister',
        });
    });
}