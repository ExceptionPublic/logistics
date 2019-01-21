<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/highcharts.jsp" %>
    <title>Insert title here</title>
    <script type="text/javascript" src="${ctx}/js/report/tendency/Tendency.js"></script>
    <script type="text/javascript" src="${ctx}/js/report/tendency/TendencyHc.js"></script>
</head>
<body>
<div class="layui-fluid layui-form">
    <div class="layui-row  layui-col-space30">
        <div class="layui-col-lg4 layui-col-md-offset3">
            <div class="layui-form-item">
                <label class="layui-form-label">时间：</label>
                <div class="layui-input-block">
                    <input type="text" id="endTime" class="layui-input"
                    >
                </div>
            </div>
        </div>

        <div class="layui-col-lg2">
            <button class="layui-btn" id="btn_TendencyMap" lay-submit>
                <i class="layui-icon">&#xe615;</i> 查询
            </button>
        </div>
    </div>

    <div class="layui-row">
        <div class="layui-col-lg2">
            <div>
                <table id="TendencyListMap" lay-filter="TendencyListMap"></table>
            </div>
        </div>

        <div class="layui-col-lg9">
            <div id="TendencyMap" style="min-width:350px;height:350px"></div>
        </div>
    </div>
</div>

</body>
</html>