<%--
  Created by IntelliJ IDEA.
  User: 20180723
  Date: 2019/1/10
  Time: 11:21
  To change this template use File | Settings | File Templates.
  销售录入查询页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <title>Title</title>
    <script type="text/javascript" src="/js/sell/sellOrder/salesEntry/SellOrderEntryList.js"></script>
    <script>
        //执行一个laydate实例
        layui.use('laydate', function() {
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem : '#startcreatetime',
                type : 'date',
                max:0,
            });
            laydate.render({
                elem : '#endcreatetime',
                type : 'date',
                min:0,
            });

        });
    </script>
</head>
<body>
<div class="layui-container layui-form" style="margin-top: 10px;">
    </div>
    <div class="layui-row layui-col-space0">
        <div class="layui-col-md5">
            <div class="layui-form-item">
                <label class="layui-form-label">录入时间：</label>
                <div class="layui-input-block" style="width: 320px;" align="center">
                    <div class="layui-col-md5">
                        <input type="text" id="startcreatetime"
                               placeholder="起始时间(&gt;)"
                               class="layui-input">
                    </div>
                    <div class="layui-col-md1" style="padding-top: 10px;">
                        <span>----</span>
                    </div>
                    <div class="layui-col-md6">
                        <input type="text" id="endcreatetime"
                               placeholder="终止时间(&lt;)"
                               class="layui-input">
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-md2 ">
            <button class="layui-btn layui-btn-sm layui-btn-primary"
                    id="btn_querySellOrder">
                <i class="layui-icon">&#xe615;</i>查询
            </button>
            <button class="layui-btn layui-btn-sm"
                    id="btn_SellOrderAdd" onclick="SellOrderAdd()">
                <i class="layui-icon">&#xe608;</i>录入销售订单
            </button>
        </div>
    </div>
</div>
<table id="querySellOrder" lay-filter="querySellOrder"></table>

</body>
</html>
