<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工添加或者修改界面</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <script src="${ctx}/js/personnel/dep/insertOrUpdateDep.js"></script>
</head>
<body>
<%--form表单--%>
<form class="layui-form" lay-filter="dep" id="dep" style="padding: 10px">
    <input type="hidden" name="uuid"/>

    <div class="layui-form-item" style="margin-right: 20px;">
        <label class="layui-form-label" id="username">部门名称：</label>
        <div class="layui-input-block">
            <input type="text" name="name" class="layui-input" lay-verify="name">
        </div>
    </div>

    <div class="layui-form-item"  style="margin-right: 20px;">
        <label class="layui-form-label" id="pwd">部门电话：</label>
        <div class="layui-input-block">
            <input type="text" name="tele" class="layui-input" lay-verify="phone|required">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="btn_saveDep">
                <i class="layui-icon "> &#x1005;</i>保存
            </button>
            <button class="layui-btn" lay-filter="btn_close" id="btn_close">
                <i class="layui-icon" title="关闭">&#x1007;</i>关闭
            </button>
        </div>
    </div>
</form>

</body>
</html>
