<%--
  Created by IntelliJ IDEA.
  User: 20180723
  Date: 2019/1/10
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <title>Title</title>
    <script type="text/javascript" src="/js/basicJs/store/StoreList.js"></script>
</head>
<body>
<div class="layui-container layui-form" style="margin-top: 10px;">
    <div class="layui-row">
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-block" style="width:40px;" align="center">
                    <input type="text" name="name" id="name" style="width: 200px;"
                           placeholder="请输入" class="layui-input">
                </div>
            </div>

        </div>
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">地址：</label>
                <div class="layui-input-block" style="width:40px;" align="center">
                    <input type="text" name="address" id="address" style="width: 200px;"
                           placeholder="请输入" class="layui-input">
                </div>
            </div>

        </div>


        <div class="layui-col-md2 layui-col-md-offset1">

            <button class="layui-btn layui-btn-sm layui-btn-primary"
                    id="btn_queryStore">
                <i class="layui-icon">&#xe615;</i>查询
            </button>
            <button class="layui-btn layui-btn-sm"
                    id="btn_storeAdd">
                <i class="layui-icon">&#xe608;</i>添加
            </button>


        </div>
    </div>
</div>
<table id="queryStore" lay-filter="queryStore"></table>

</body>
</html>
