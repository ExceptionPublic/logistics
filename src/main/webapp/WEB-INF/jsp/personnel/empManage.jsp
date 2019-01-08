<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<div class="layui-fluid layui-form">
    <div class="layui-row layui-col-space5">
        <div class="layui-col-lg4 layui-col-md-offset1" >
            <div class="layui-form-item">
                <label class="layui-form-label">真实姓名：</label>
                <div class="layui-input-block">
                    <input type="text" name="custName" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-col-lg2">
            <label class="layui-form-label">部  门：</label>
            <div class="layui-input-block">
                <select id="dep">
                    <option value=""></option>
                </select>
            </div>
        </div>
        <div class="layui-col-lg2">
            <label class="layui-form-label">性 别：</label>
            <div class="layui-input-block">
                <input type="checkbox" name="like[boy]" title="男" checked>
                <input type="checkbox" name="like[girl]" title="女" checked>
            </div>
        </div>
        <div class="layui-col-lg2">
            <button class="layui-btn" id="btn_queryClient">
                <i class="layui-icon">&#xe615;</i> 查询
            </button>
        </div>
    </div>
</div>


<div class="layui-fluid">
    <table class="layui-hide" id="client" lay-filter="client"></table>
</div>

</body>
</html>
