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
    <script type="text/javascript" src="${ctx}/js/warehouse/storeDetail/StoreDetailList.js"></script>
</head>
<body>
<div class="layui-container layui-form" style="margin-top: 10px;">
    <div class="layui-row">
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">商品仓库：</label>
                <div class="layui-input-block" style="width: 200px">
                    <select name="storeuuid"
                            lay-verify="required"
                            id="storeuuid"
                            lay-filter="storeuuid">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-col-md2 layui-col-md-offset1">
            <button class="layui-btn layui-btn-sm layui-btn-primary"
                    id="btn_queryStoreDa">
                <i class="layui-icon">&#xe615;</i>查询
            </button>


        </div>
    </div>
</div>
<table id="queryStoreDa" lay-filter="queryStoreDa"></table>

</body>
</html>
