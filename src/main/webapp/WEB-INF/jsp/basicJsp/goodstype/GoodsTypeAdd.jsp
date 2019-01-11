
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <title>Title</title>
    <script type="text/javascript" src="/js/basicJs/goodstype/GoodsTypeadd.js"></script>
</head>


<body>

<form method="post" lay-filter="supplierAdd" id="supplierAdd" class="layui-form">


<div class="layui-container layui-form" style="margin-top: 10px;">
    <div class="layui-row">
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-block" style="width:40px;" align="center">
                    <input type="text" name="name" id="name" style="width: 200px;"
                           lay-verify="name|required"
                           placeholder="请输入"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="btn_goodstyAdd">立即提交</button>
                <button id="btn_close" class="layui-btn layui-btn-primary">关闭</button>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>
