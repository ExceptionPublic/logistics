<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主界面</title>
    <link href="${ctx}/css/index.css" >
    <script type="text/javascript" src="${ctx}/js/index.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">飞扬物流系统</div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">axing</li>
            <li class="layui-nav-item"><a href="/loginOut">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="tree" id=tree>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab" lay-filter="demo" lay-allowClose="true">
            <ul class="layui-tab-title">
            </ul>
            <div class="layui-tab-content layui-bg-white" style="height: 99%">
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © zking.com.T213.axing
    </div>
</div>
</body>
</html>