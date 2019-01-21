<%--
  Created by IntelliJ IDEA.
  User: 20180723
  Date: 2019/1/19
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/js/sell/sellOrder/salesEntry/SellOrderEntryGoods.js"></script>

</head>
<body>
<div class="layui-container layui-form" style="margin-top: 10px;">
    <div class="layui-row">
        <div class="layui-col-md3">
            <div class="layui-form-item">
                <label class="layui-form-label">供应商：</label>
                <div class="layui-input-block" style="width: 150px">
                    <select name="supplieruuid"
                            id="supplieruuid"
                            lay-filter="supplieruuid">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-col-md1 layui-col-md-offset1" >
        </div>
    </div>
</div>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md10 layui-col-md-offset1">
            <table id="SellOrderEntryAdd" lay-filter="SellOrderEntryAdd"></table>
        </div>
    </div>
</div>

</body>
</html>
