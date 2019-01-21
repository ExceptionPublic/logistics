<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <title>主界面</title>
        <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
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
                                <dd><a id="1423" class="open" lay-url="${ctx}/personnel/dep/toDepManage"
                                       href="javascript:void(0);">部门管理</a>
                                </dd>
                                <dd><a id="1424" class="open" lay-url="${ctx}/personnel/emp/toEmpManage"
                                       href="${ctx}/personnel/emp/toEmpManage">员工管理</a>
                                </dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a href="javascript:;">采购管理</a>
                            <dl class="layui-nav-child">
                                <dd><a id="1806" class="open" lay-url="${ctx}/purchase/toPurchase" href="javascript:void(0);">采购管理</a>
                                </dd>
                                <dd><a id="1807" class="open" lay-url="${ctx}/personnel/emp/toEmpManage" href="javascript:void(0);">退货管理</a>
                                </dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a href="javascript:;">基本信息</a>
                            <dl class="layui-nav-child">
                                <dd><a id="2421" class="open"
                                       lay-url="${ctx}/basicJsp/goodstype/toGoodstypeList"
                                       <%--href="${ctx}/basicJsp/goodstype/toGoodstypeList"--%>
                                >商品类型</a></dd>
                                <dd><a id="2422" class="open" lay-url="${ctx}/basicJsp/goods/toqueryGoods"
                                       <%--href="/basicJsp/goods/toqueryGoods"--%>
                                >商品</a></dd>
                                <dd><a id="2423" class="open" lay-url="${ctx}/basicJsp/supplier/toqueryLstSupplier"
                                       <%--href="${ctx}/basicJsp/supplier/toqueryLstSupplier"--%>
                                >供应商</a></dd>
                                <dd><a id="2424" class="open" lay-url="${ctx}/basicJsp/clients/toqueryClients"
                                       <%--href="/basicJsp/clients/toqueryClients"--%>
                                >客户</a></dd>

                                <dd><a id="2425" class="open" lay-url="${ctx}/basicJsp/store/toqueryStore"
                                       <%--href="/basicJsp/store/toqueryStore"--%>
                                >仓库</a></dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a href="javascript:;">库存管理</a>
                            <dl class="layui-nav-child">
                                <dd><a id="2521" class="open" lay-url="${ctx}/warehouse/storeDetail/toStoreDeList"
                                       <%--href="${ctx}/warehouse/storeDetail/toStoreDeList"--%>
                                >库存查询</a></dd>
                                <dd><a id="2522" class="open" lay-url="${ctx}/warehouse/storeoper/toStoreoperList"
                                       <%--href="${ctx}/warehouse/storeoper/toStoreoperList"--%>
                                >库存变动记录</a></dd>
                                <dd><a id="2523" class="open" lay-url="${ctx}/warehouse/inventory/toInvenListRegister"
                                       <%--href="${ctx}/warehouse/inventory/toInvenListRegister"--%>
                                >盘盈盘亏登记</a></dd>
                                <dd><a id="2525" class="open" lay-url="${ctx}/warehouse/inventory/toInvenListAudit"
                                       <%--href="${ctx}/warehouse/inventory/toInvenListAudit"--%>
                                >盘盈盘亏审核</a></dd>
                                <dd><a id="2524" class="open" lay-url="${ctx}/warehouse/inventory/toInvenList"
                                       <%--href="${ctx}/warehouse/inventory/toInvenList"--%>
                                >盘盈盘亏查询</a></dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a href="javascript:;">角色管理</a>
                            <dl class="layui-nav-child">
                                <dd><a id="3523" class="open" lay-url="${ctx}/roles/role/toRolelist"
                                       href="${ctx}/roles/role/toRolelist"
                                >角色设置</a></dd>
                                <dd><a id="3525" class="open" lay-url="${ctx}/roles/rolepwd/toRolepwd"
                                       <%--href="${ctx}/roles/rolepwd/toRolepwd"--%>
                                >用户密码重置</a></dd>
                                <dd><a id="3524" class="open" lay-url="${ctx}/roles/roleauthority/toRoleAuthority"
                                       <%--href="${ctx}/roles/roleauthority/toRoleAuthority"--%>
                                >角色权限设置</a></dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a href="javascript:;">报表管理</a>
                            <dl class="layui-nav-child">
                                <dd><a id="4523" class="open" lay-url="${ctx}/report/statistics/toStatistics"
                                       <%--href="${ctx}/report/statistics/toStatistics"--%>
                                >销售统计</a></dd>
                                <dd><a id="4525" class="open" lay-url="${ctx}/report/tendency/toTendency"
                                       <%--href="${ctx}/report/tendency/toTendency"--%>
                                >销售趋势</a></dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a href="javascript:;">销售管理</a>
                            <dl class="layui-nav-child">
                                <li class="layui-nav-item">
                                    <a href="javascript:;">销售管理</a>
                                    <dl class="layui-nav-child">

                                        <dd><a id="552301" class="open" lay-url="${ctx}/sell/sellOrder/toSellOrderList"
                                               <%--href="${ctx}/sell/sellOrder/toSellOrderList"--%>
                                        >销售查询</a></dd>
                                        <dd><a id="552502" class="open" lay-url="${ctx}/sell/sellOrder/salesEntry//toSellOrderEntryList"
                                               href="${ctx}/sell/sellOrder/salesEntry/toSellOrderEntryList"
                                        >销售录入</a></dd>
                                        <dd><a id="552503" class="open" lay-url="${ctx}/sell/sellOrder/salesOutbound/toSalesOutboundList"
                                               href="${ctx}/sell/sellOrder/salesOutbound/toSalesOutboundList"
                                        >销售出库</a></dd>
                                    </dl>
                                </li>
                                <li class="layui-nav-item">
                                    <a href="javascript:;">退货管理</a>
                                    <dl class="layui-nav-child">

                                        <dd><a id="552401" class="open" lay-url="${ctx}/personnel/toEmpManage" href="${ctx}/sell/sellOrder/toSellOrderList">退货查询</a></dd>
                                        <dd><a id="552402" class="open" lay-url="${ctx}/personnel/toEmpManage" href="${ctx}">退货申请</a></dd>
                                        <dd><a id="552403" class="open" lay-url="${ctx}/personnel/toEmpManage" href="${ctx}">退货审核</a></dd>
                                        <dd><a id="552404" class="open" lay-url="${ctx}/personnel/toEmpManage" href="${ctx}">退货入库</a></dd>
                                    </dl>
                                </li>
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
    </body>
</html>
