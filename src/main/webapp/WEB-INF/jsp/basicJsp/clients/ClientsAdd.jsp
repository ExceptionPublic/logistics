<%--
  Created by IntelliJ IDEA.
  User: 20180723
  Date: 2019/1/10
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <title>Title</title>
    <script type="text/javascript" src="/js/basicJs/clients/ClientsAdd.js"></script>
</head>
<body>
<form method="post" lay-filter="clientsAdd" id="clientsAdd" class="layui-form">


    <div class="layui-container layui-form" style="margin-top: 10px;">
        <div class="layui-row">
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">名称：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="hidden" name="uuid">
                        <input type="text" name="name" id="name" style="width: 200px;"
                               placeholder="请输入"
                               lay-verify="name|required"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">地址：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="address" id="address" style="width: 200px;"
                               lay-verify="required"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">联系人：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="contact" id="contact" style="width: 200px;"
                               lay-verify="required"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">电话：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="tele" id="tele" style="width: 200px;"
                               lay-verify="phone"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">email：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="email" id="email" style="width: 200px;"
                               lay-verify="email"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="btn_clientsAdd">立即提交</button>
                    <button id="btn_close" class="layui-btn layui-btn-primary">关闭</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
