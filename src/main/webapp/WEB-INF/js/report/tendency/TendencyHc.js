$(function(){
    show();
    $('#btn_TendencyMap').click(function() {
        getAll();
    });
    //执行一个laydate实例
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem : '#endTime',
            type : 'year',
            max:0
        });

    });
});
function getAll(){
    var type = [];
    var count = [];
    $.ajax({
        url : "warehouse/storeoper/TendencyMap",
        data : {'endTime' : getValue('#endTime')},
        type : "post",
        dateType : "json",
        async : false,
        success : function(data) {
            // console.log(data);
            // console.log(data.series);
            $.each(data.series, function(i, e) {
                type.push(e.opertime);
                count.push(e.sum);
            });
        }
    });
    show(type, count);
}

function show(type, count){
    var chart = Highcharts.chart('TendencyMap', {
        chart: {
            type: 'line'
        },
        title: {
            text: '销售趋势'
        },
        subtitle: {
            // text: '数据来源: WorldClimate.com'
        },
        xAxis: {
            categories: type
        },
        yAxis: {
            title: {
                text: '销售额'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    // 开启数据标签
                    enabled: true
                },
                // 关闭鼠标跟踪，对应的提示框、点击事件会失效
                enableMouseTracking: false
            }
        },
        plotOptions: {
            column: {
                borderWidth: 0
            }
        },
        credits : {
            enabled : false
        },
        exporting : {
            enabled : false
        },
        series: [{
            name: '销售额',
            data: count
        }, ]
    });

}
