<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单明细</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<%--布局容器--%>
<div class="layui-fluid layui-form">
    <%--行容器--%>
    <%--第一行--%>
    <div class="layui-row layui-col-space10">
        <%--列容器--%>
        <%--第一例--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">流水号：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="uuid"/>
                </div>
            </div>
        </div>

        <%--第二列--%>
        <div class="layui-col-md6">
            <div class="layui-form-item">
                <label class="layui-form-label">供应商：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="uuid"/>
                </div>
            </div>
        </div>

        <%--第三列--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">状态：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="uuid"/>
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
                    <input class="layui-input" type="text" readonly="readonly" name="uuid"/>
                </div>
            </div>
        </div>

        <%--第二列--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">审核员：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="uuid"/>
                </div>
            </div>
        </div>

        <%--第三列--%>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">采购员：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="uuid"/>
                </div>
            </div>
        </div>

        <%--第四列--%>
        <div class="layui-col-md6">
            <div class="layui-form-item">
                <label class="layui-form-label">入库员：</label>
                <div class="layui-input-block">
                    <input class="layui-input" type="text" readonly="readonly" name="uuid"/>
                </div>
            </div>
        </div>

    </div>

</div>
</body>
</html>
