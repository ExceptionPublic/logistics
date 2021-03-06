
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <title>Title</title>
    <script type="text/javascript" src="/js/basicJs/goodstype/GoodsTypeList.js"></script>
</head>
<body>
<div class="layui-container layui-form" style="margin-top: 10px;">
    <div class="layui-row">
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-block" style="width:40px;" align="center">
                    <input type="text" name="name" id="name" style="width: 200px;"
                           placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-col-md2 layui-col-md-offset1">

            <button class="layui-btn layui-btn-radius layui-btn-primary"
                    id="btn_queryGoodsType">
                <i class="layui-icon">&#xe615;</i>查询
            </button>
            <button class="layui-btn layui-btn-radius layui-btn-radius"
                    id="btn_GoodsTypeAdd" onclick="GoodsTyAdd()">
                <i class="layui-icon">&#xe608;</i>添加
            </button>


        </div>
    </div>
</div>
    <table id="queryGoodsType" lay-filter="queryGoodsType"></table>
</body>
</html>
