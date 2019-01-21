<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单明细</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <script src="${ctx}/js/purchase/orderDetail.js"></script>
</head>
<body>
<%--布局容器--%>
<div class="layui-fluid layui-form" lay-filter="order" style="margin-top: 10px;">
    <%--行容器--%>
    <%--第一行--%>
    <div class="layui-row layui-col-space10">
        <%--列容器--%>
        <%--第一例--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">流水号：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="ordersId"/>
                </div>
            </div>
        </div>

        <%--第二列--%>
        <div class="layui-col-md4">
            <div class="layui-form-item">
                <label class="layui-form-label">供应商：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="supplierName"/>
                </div>
            </div>
        </div>

        <%--第三列--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">状态：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="stateName"/>
                </div>
            </div>
        </div>

        <%--第三列--%>
        <div class="layui-col-md2">
            <div class="layui-form-item">
                <label class="layui-form-label">总金额：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="totalMoney"/>
                </div>
            </div>
        </div>

    </div>

    <%--第二行--%>
    <div class="layui-row layui-col-space10">
        <%--列容器--%>
        <%--第一例--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">下单员：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="createName"/>
                </div>
            </div>
        </div>

        <%--第二列--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">审核员：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="checker"/>
                </div>
            </div>
        </div>

        <%--第三列--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">创建日期：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="createDate"/>
                </div>
            </div>
        </div>

        <%--第四列--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">确认日期：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="checkerDate"/>
                </div>
            </div>
        </div>

    </div>

</div>
<div class="layui-fluid">
    <table class="layui-hide" id="orderDateilTable" lay-filter="orderDateilTable"></table>
</div>
</body>
</html>
