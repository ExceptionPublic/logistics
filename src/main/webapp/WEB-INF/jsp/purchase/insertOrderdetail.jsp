<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <script src="${ctx}/js/purchase/insertOrderDetail.js"></script>
    <style type="text/css">
        .layui-layer-page .layui-layer-content {
            position: relative;
            overflow: visible !important;
        }
    </style>
</head>
<body>
<div class="layui-form">
    <div class="layui-form-item" style="margin-top: 10px;margin-right: 30px;">
        <label class="layui-form-label">商品：</label>
        <div class="layui-input-block">
            <select id="goods" lay-filter="goods">
                <option value=""></option>
            </select>
        </div>
    </div>
</div>
</body>
</html>
