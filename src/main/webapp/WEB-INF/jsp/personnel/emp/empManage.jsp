<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <%--<script src="${ctx}/js/personnel/emp/empMap.js"></script>--%>
    <script src="${ctx}/js/personnel/emp/empManage.js"></script>
</head>
<body>
<div class="layui-fluid layui-form">
    <div class="layui-row layui-col-space5" >
        <div class="layui-col-lg2 layui-col-md-offset2" style="padding-bottom: 5px;">
            <div class="layui-form-item">
                <label class="layui-form-label">真实姓名：</label>
                <div class="layui-input-block">
                    <input type="text" id="name" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-col-lg3" style="margin-top: 5px;">
            <label class="layui-form-label">部  门：</label>
            <div class="layui-input-block">
                <select id="dep">
                    <option value=""></option>
                </select>
            </div>
        </div>
        <div class="layui-col-lg2" style="margin-top: 5px;">
            <label class="layui-form-label">性 别：</label>
            <div class="layui-input-block" id="checkboxs">
                <input type="checkbox" name="gender" value="0" title="男" checked>
                <input type="checkbox" name="gender" value="1" title="女" checked>
            </div>
        </div>
        <div class="layui-col-lg1">
            <button class="layui-btn" id="btn_queryEmp">
                <i class="layui-icon">&#xe615;</i> 查询
            </button>
        </div>
        <div class="layui-col-lg1">
            <button class="layui-btn" id="btn_insertEmp">
                <i class="layui-icon">&#xe654;</i> 新增员工
            </button>
        </div>
    </div>
</div>


<div class="layui-fluid">
    <table class="layui-hide" id="empTable" lay-filter="empTable"></table>
</div>

</body>
</html>
