$(function(){
    show();
    $('#btn_queryRole').click(function() {
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
    $.ajax({
        url : "warehouse/storeoper/StatisticsMap",
        data : {'endTime' : getValue('#endTime')},
        type : "post",
        dateType : "json",
        async : false,
        success : function(data) {
            console.log(data);
            console.log(data.series);
            show(data.series);
            // var d= JSON.parse(data);
            // show(d.series);
        }
    });
}

function show(data){
    // Build the chart
    Highcharts.chart('statisticsMap', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: '销售统计图'
        },
        credits : {enabled : false},
        exporting : {nabled : false},
        tooltip: {pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'},
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        plotOptions: {
            column: {
                borderWidth: 0
            }
        },
        // credits : {
        //     enabled : false
        // },
        exporting : {
            enabled : false
        },
        series: [{
            name: '百分比',
            colorByPoint: true,
            data: data
        }]
    });
}
