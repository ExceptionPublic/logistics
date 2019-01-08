<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <title>主界面</title>
    <%--<link href="${ctx}/css/index.css">--%>
    <script type="text/javascript" src="${ctx}/js/index.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <%--头部--%>
    <div class="layui-header">
        <div class="layui-logo">资产管理系统</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="javascript:;"> 阿星 </a></li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <%--左侧--%>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="javascript:;">人事管理</a>
                    <dl class="layui-nav-child">
                        <dd><a id="1423" class="open" lay-url="${ctx}/personnel/toEmpManage" href="javascript:void(0);">部门管理</a></dd>
                        <dd><a id="1424" class="open" lay-url="${ctx}/personnel/toEmpManage" href="javascript:void(0);">员工管理</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <%--中间--%>
    <div class="layui-body">
        <div class="layui-tab" lay-filter="demo" lay-allowClose="true">
            <ul class="layui-tab-title">
            </ul>
            <div class="layui-tab-content layui-bg-white" style="height: 90%">
            </div>
        </div>
    </div>
    <%--下面--%>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © zking.com.T213.axing
    </div>
</div>
</html>
