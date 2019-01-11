<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<div class="layui-fluid layui-form">
    <div class="layui-row layui-col-space10">
        <div class="layui-col-md4 layui-col-md-offset4">
            <div class="layui-form-item">
                <label class="layui-form-label">供应商：</label>
                <div class="layui-input-block">
                    <select id="supplier" lay-filter="supplier">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="layui-fluid">
    <table class="layui-hide" id="commodityTable" lay-filter="commodityTable"></table>
</div>
</body>
</html>
