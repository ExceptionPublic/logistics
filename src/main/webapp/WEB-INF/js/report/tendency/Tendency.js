
$(function() {
    layui.use([ 'form', 'table' ], function() {
        // 变量定义
        var table = layui.table,
            form = layui.form;
        // 初始化
        TendencyListMap({});
        // 给查询按钮绑定事件
        $('#btn_TendencyMap').click(function() {
            TendencyListMapse();
        });
        form.render();
        //执行一个laydate实例
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        // 执行一个laydate实例
        laydate.render({
            elem : '#endTime',
            value:new Date(),
            type : 'year',
            max:0
        });

    });
    });
});

//销售数据表
function TendencyListMap(parameters){
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id : "TendencyListMap2",
            elem: '#TendencyListMap',
            url: '', //数据接口
            where:parameters,
            width:200,
            title : "销售趋势表",
            method : "post",
            // toolbar: '#toolbarDemo',//这是个神奇的标签
            text : {
                none : '对不起，暂无此类数据'
            },
            cols: [[ //表头
                {field: 'opertime', title: '月份', width:'50%',align: 'center'},
                {field: 'sum', title: '销售额', width:'50%',align: 'center'},
            ]],

        });

    });
}


function TendencyListMapse(){
    layui.use('table', function() {
        var table = layui.table;


        var paraments = {
            'endTime': getValue('#endTime'),
        };

        console.log(table)
        table.reload('TendencyListMap2', {
           url : 'warehouse/storeoper/TendencyListMap',
            where : paraments,
        });

        // console.log(paraments)
    });
}



