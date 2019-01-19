
$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        StatisticsListMap({});
        // 给查询按钮绑定事件
        $('#btn_queryRole').click(function() {
            StatisticsListMapse();
        });
        form.render();
        //执行一个laydate实例
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        // 执行一个laydate实例
        laydate.render({
            elem : '#endTime',
            type : 'year',
            max:0
        });

    });
    });
});

//销售数据表
function StatisticsListMap(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "StatisticsListMap2",
            elem: '#StatisticsListMap',
            url: 'warehouse/storeoper/StatisticsListMap', //数据接口
            where:parameters,
            width:200,
            title : "销售统计表",
            method : "post",
            // toolbar: '#toolbarDemo',//这是个神奇的标签
            text : {
                none : '对不起，暂无此类数据'
            },
            cols: [[ //表头
                {field: 'gname', title: '商品', width:'50%',align: 'center'},
                {field: 'count', title: '销售额', width:'50%',align: 'center'},
            ]],

        });

    });
}


function StatisticsListMapse(){
    layui.use('table', function() {
        var table = layui.table;

        var paraments = {
            'endTime': getValue('#endTime'),
        };
        console.log(paraments)
        console.log(table)
        table.reload('StatisticsListMap2', {
            url : 'warehouse/storeoper/StatisticsListMap',
            where : paraments,
        });
    });
}



