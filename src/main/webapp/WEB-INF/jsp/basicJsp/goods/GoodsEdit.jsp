<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <title>Title</title>
    <script type="text/javascript" src="/js/basicJs/goods/GoodsEdit.js"></script>
</head>
<body>
<form method="post" lay-filter="goodsEdit" id="goodsEdit" class="layui-form">
    <div class="layui-container layui-form" style="margin-top: 10px;">
        <input type="hidden" name="uuid">
        <div class="layui-row">
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">名称：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="name" id="name" style="width: 200px;"
                               placeholder="请输入"
                               lay-verify="name"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">产地：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="origin" id="origin" style="width: 200px;"
                               lay-verify="required"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">厂家：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="producer" id="producer" style="width: 200px;"
                               lay-verify="required"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">计量单位：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="unit" id="unit" style="width: 200px;"
                               lay-verify="required"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">进货价格：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="inprice" id="inprice" style="width: 200px;"
                               lay-verify="number"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">销售价格：</label>
                    <div class="layui-input-block" style="width:40px;" align="center">
                        <input type="text" name="outprice" id="outprice" style="width: 200px;"
                               lay-verify="number"
                               placeholder="请输入"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-form-item">
                    <label class="layui-form-label">商品类型：</label>
                    <div class="layui-input-block" >
                        <select name="goodstypeuuid"
                                lay-verify="required"
                                id="goodstypeuuid"
                                lay-filter="goodstypeuuid"
                                style="width: 40px;">
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="btn_goodsEdit">确认修改</button>
                    <button id="btn_close" class="layui-btn layui-btn-primary">关闭</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
