<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <script src="${ctx}/js/purchase/purchase.js"></script>
</head>
<body>
<div class="layui-fluid layui-form">
    <%--第一行--%>
    <%--日期查询--%>
    <div class="layui-row layui-col-space5" style="padding-bottom: 5px;">

        <%--下单员下拉--%>
        <div class="layui-col-md2 layui-col-md-offset2">
            <div class="layui-form-item">
                <label class="layui-form-label">选择时间：</label>
                <div class="layui-input-block">
                    <select id="whatDate" lay-filter="creater">
                        <option value="createtime">创建时间</option>
                        <option value="checktime">审核时间</option>
                        <option value="starttime">采购时间</option>
                        <option value="endtime">入库时间</option>
                    </select>
                </div>
            </div>
        </div>

        <%--开始日期--%>
        <div class="layui-col-md2">
            <div class="layui-form-item">
                <label class="layui-form-label">开始日期：</label>
                <div class="layui-input-block">
                    <input type="text" id="beginDate" class="layui-input">
                </div>
            </div>
        </div>

        <%--结束日期--%>
        <div class="layui-col-md2">
            <div class="layui-form-item">
                <label class="layui-form-label">开始日期：</label>
                <div class="layui-input-block">
                    <input type="text" id="endDate" class="layui-input">
                </div>
            </div>
        </div>

        <%--采购申请--%>
        <div class="layui-col-lg1">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" id="btn_purchase">
                        <i class="layui-icon">&#xe654;</i> 采购申请
                    </button>
                </div>
            </div>
        </div>


    </div>

    <%--第二行--%>
    <%--人员查询--%>
    <div class="layui-row layui-col-space5" style="padding-bottom: 5px;">
        <%--下单员下拉--%>
        <div class="layui-col-md2 layui-col-md-offset1">
            <div class="layui-form-item">
                <label class="layui-form-label">下 单 员：</label>
                <div class="layui-input-block">
                    <select id="creater" lay-filter="creater">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>

        <%--审查员下拉--%>
        <div class="layui-col-md2">
            <div class="layui-form-item">
                <label class="layui-form-label">审 查 员：</label>
                <div class="layui-input-block">
                    <select id="checker" lay-filter="checker">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>

        <%--采购员下拉--%>
        <div class="layui-col-md2">
            <div class="layui-form-item">
                <label class="layui-form-label">采 购 员：</label>
                <div class="layui-input-block">
                    <select id="starter" lay-filter="starter">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>

        <%--库管员下拉--%>
        <div class="layui-col-md2">
            <div class="layui-form-item">
                <label class="layui-form-label">库 管 员：</label>
                <div class="layui-input-block">
                    <select name="ender" lay-filter="ender">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>

        <%--查询按钮--%>
        <div class="layui-col-md2">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" id="btn_queryPurchase">
                        <i class="layui-icon">&#xe615;</i> 查询订单
                    </button>
                </div>
            </div>
        </div>




    </div>

</div>


<div class="layui-fluid">
    <table class="layui-hide" id="purchaseTable" lay-filter="purchaseTable"></table>
</div>
</body>
</html>
