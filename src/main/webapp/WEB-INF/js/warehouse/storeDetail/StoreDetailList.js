var rowData;
$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化

        //初始化部门
        if (null == rowData)
            initSelect("basicJsp/store/StoreList", [], "#storeuuid", "uuid", "name");


        storeOp({});
        // 给查询按钮绑定事件
        $("#btn_queryStoreDa").click(function() {
            storeDeListSe();
        });
        form.render();
    });
});

function storeOp(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "queryStoreDa2",
            elem: '#queryStoreDa',
            // height: 312,
            url: 'warehouse/storeDetail/queryStoredetailPager', //数据接口
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
                {field: 'uuid', title: '编号', width:'10%', align: 'center'},
                {field: 'sname', title: '仓库名称', width:'15%',align: 'center'},
                {field: 'gname', title: '商品名称', width:'15%',align: 'center'},
                {field: 'quantity', title: '库存数量', width:'10%',align: 'center'},
            ]],
            done: function (res, curr, count) {
                if (res.success == false)
                    msg(res.message)
            }
        });
    });
}

function storeDeListSe(){
    layui.use('table', function() {
        var table = layui.table;
        var paraments = {
            storeuuid: getValue('#storeuuid '),
        };
        console.log(paraments);
        table.reload('queryStoreDa2', {
            url: 'warehouse/storeDetail/queryStoredetailPager',
            where : paraments,
            page:{
                curr:1
            }
        });
    });
}

