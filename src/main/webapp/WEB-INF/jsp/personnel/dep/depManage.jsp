<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <script src="${ctx}/js/personnel/dep/depManage.js"> </script>
</head>
<body>
<div class="layui-fluid layui-form">
    <div class="layui-row layui-col-space5" >
        <div class="layui-col-lg4 layui-col-md-offset3" style="padding-bottom: 5px;">
            <div class="layui-form-item">
                <label class="layui-form-label">部门名称：</label>
                <div class="layui-input-block">
                    <input type="text" id="name" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-col-lg1">
            <button class="layui-btn" id="btn_queryDep">
                <i class="layui-icon">&#xe615;</i> 查询
            </button>
        </div>
        <div class="layui-col-lg1">
            <button class="layui-btn" id="btn_insertDep">
                <i class="layui-icon">&#xe654;</i> 新增部门
            </button>
        </div>
    </div>
</div>
<div class="layui-fluid">
    <table class="layui-hide" id="depTable" lay-filter="depTable"></table>
</div>
</body>
</html>
