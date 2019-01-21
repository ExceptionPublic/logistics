<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <script src="${ctx}/js/purchase/insertPurchase.js"></script>
</head>
<body>
<div class="layui-fluid layui-form" style="margin-top: 10px;">
    <div class="layui-row layui-col-space10">

        <div class="layui-col-md1">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-primary" id="btn_insertOrder">
                        <i class="layui-icon layui-icon-download-circle"></i>
                        申请采购
                    </button>
                </div>
            </div>
        </div>

        <div class="layui-col-md4 layui-col-md-offset2">
            <div class="layui-form-item">
                <label class="layui-form-label">供应商：</label>
                <div class="layui-input-block" id="supplierDiv">
                    <select id="supplier" lay-filter="supplier">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-col-md1">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-primary" id="btn_insertOrderDetail">
                        <i class="layui-icon layui-icon-add-1"></i>
                        新增商品
                    </button>
                </div>
            </div>
        </div>



    </div>
</div>

<div class="layui-fluid">
    <table class="layui-hide" id="orderDetailTable" lay-filter="orderDetailTable"></table>
</div>
</body>
</html>
