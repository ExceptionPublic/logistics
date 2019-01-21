<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工添加或者修改界面</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <script src="${ctx}/js/sell/sellOrder/salesOutbound/SellParticulars.js"></script>
</head>
<body>
<%--form表单--%>
<form class="layui-form" lay-filter="lineitem" id="lineitem">
    <%--总容器--%>
    <div class="layui-container" style="margin-top: 10px;">
        <%--第一行--%>
        <div class="layui-row layui-col-space0">
            <%--第一列--%>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">销售单号：</label>
                    <div class="layui-input-block" style="width: 150px;">
                        <input type="text" name="maid" readonly="readonly"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <%--第三列--%>
            <div class="layui-col-md4">
                <div class="layui-form-item">
                    <label class="layui-form-label">销售员：</label>
                    <div class="layui-input-block" style="width: 150px;">
                        <input type="text" name="empsalesman" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4">
                <div class="layui-form-item">
                    <label class="layui-form-label">状态：</label>
                    <div class="layui-input-block" style="width: 150px;">
                        <input type="text" name="state" class="layui-input">
                    </div>
                </div>
            </div>
        </div>
<div class="layui-container">
    <div class="layui-row layui-col-space10">
        <div class="layui-col-md10 layui-col-md-offset1">
            <table id="SellLineItem" lay-filter="SellLineItem"></table>
        </div>
    </div>
</div>
</div>

</form>
</body>
</html>
