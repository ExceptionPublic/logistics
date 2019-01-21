<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/js/warehouse/inventory/register/InventoryAddRegister.js"></script>
</head>
<body>
<form method="post" lay-filter="invenAdd" id="invenAdd" class="layui-form">
    <div class="layui-container layui-form" style="margin-top: 10px;">
        <div class="layui-row">
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">盘点人：</label>
                    <div class="layui-input-block" style="width:200px;" align="center">
                        <%--<input type="hidden" name="creater">--%>
                        <input type="text" name=""
                               disabled="disabled"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">备注：</label>
                    <div class="layui-input-block" style="width:200px;" align="center">
                        <input type="text" name="remark" id="remark"
                               placeholder="请输入"
                               lay-verify="required"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">数量：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="num" id="num" style="width: 200px;"
                               lay-verify="number|required"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">商品：</label>
                    <div class="layui-input-block" style="width: 200px">
                        <select name="goodsuuid"
                                lay-verify="required"
                                id="goodsuuid"
                                lay-filter="goodsuuid">
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">仓库：</label>
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
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">类型：</label>
                    <div class="layui-input-block" style="width: 200px">
                        <select name="type"
                                lay-verify="required"
                                id="type"
                                lay-filter="type">
                            <option value=""></option>
                            <option value="盘盈">盘盈</option>
                            <option value="盘亏">盘亏</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="btn_inventoryAddregister">确认提交</button>
                    <button id="btn_close" class="layui-btn layui-btn-primary">关闭</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
