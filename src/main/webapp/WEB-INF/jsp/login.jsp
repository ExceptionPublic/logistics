<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <title>登陆</title>
    <script type="text/javascript" src="${ctx}/js/login.js"></script>
</head>
<body>
<H1>登陆</H1>
<div class="layui-container" style="margin:auto;">
    <div class="layui-row">
        <div class="layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header  layui-bg-gray">用户登陆</div>
                <div class="layui-card-body">
                    <div class="layui-container">
                        <div class="layui-row">
                            <div class="layui-col-md5">
                                <div class="layui-form-item">
                                    <label class="layui-form-label">用户账号：</label>
                                    <div class="layui-input-block">
                                        <input type="text" id="username" placeholder="请输入账号"
                                               autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="layui-row">
                            <div class="layui-col-md5">
                                <div class="layui-form-item">
                                    <label class="layui-form-label">用户密码：</label>
                                    <div class="layui-input-block">
                                        <input type="password" id="pwd" placeholder="请输入密码"
                                               autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="layui-row">
                            <div class="layui-col-md5">
                                <div class="layui-col-md3 layui-col-md-offset5">
                                    <button class="layui-btn" id="btn_login">登陆</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
