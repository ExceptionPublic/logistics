<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工添加或者修改界面</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <script src="${ctx}/js/personnel/emp/insertOrUpdateEmp.js"></script>
</head>
<body>
<%--form表单--%>
<form class="layui-form" lay-filter="emp" id="emp">
    <%--总容器--%>
    <div class="layui-container" style="margin-top: 10px;">
        <%--隐藏id--%>
        <input type="hidden" name="uuid"/>
        <%--行容器--%>

        <%--第一行--%>
        <div class="layui-row layui-col-space10">
            <%--第一列--%>
            <div class="layui-col-md6">
                <div class="layui-form-item">
                    <label class="layui-form-label" id="username">登陆账号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" class="layui-input" lay-verify="username">
                    </div>
                </div>
            </div>
            <%--第二列--%>
            <div class="layui-col-md6">
                <div class="layui-form-item">
                    <label class="layui-form-label" id="pwd">登陆密码：</label>
                    <div class="layui-input-block">
                        <input type="password" name="pwd" class="layui-input" lay-verify="password">
                    </div>
                </div>
            </div>
        </div>

        <%--第二行--%>
        <div class="layui-row layui-col-space10">
            <%--第一列--%>
            <div class="layui-col-md6">
                <div class="layui-form-item">
                    <label class="layui-form-label" id="name">真实姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" class="layui-input" lay-verify="required">
                    </div>
                </div>
            </div>
            <%--第二列--%>
            <div class="layui-col-md6">
                <div class="layui-form-item">
                    <label class="layui-form-label" id="gender">性 别：</label>
                    <div class="layui-input-block" id="checkboxs">
                        <input type="radio" name="gender" value="0" title="男" checked>
                        <input type="radio" name="gender" value="1" title="女">
                    </div>
                </div>
            </div>
        </div>

        <%--第三行--%>
        <div class="layui-row layui-col-space10">
            <%--第一列--%>
            <div class="layui-col-md6">
                <div class="layui-form-item">
                    <label class="layui-form-label" id="birthday">出生日期：</label>
                    <div class="layui-input-block">
                        <input type="text" name="birthday" class="layui-input" lay-verify="date|required">
                    </div>
                </div>
            </div>
            <%--第二列--%>
            <div class="layui-col-md6">
                <div class="layui-form-item">
                    <label class="layui-form-label" id="depuuid">所属部门：</label>
                    <div class="layui-input-block">
                        <select name="depuuid" id="dep" lay-filter="depuuid" lay-verify="required">
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div>
        </div>

        <%--第四行--%>
        <div class="layui-row layui-col-space10">
            <%--第一列--%>
            <div class="layui-col-md6">
                <div class="layui-form-item">
                    <label class="layui-form-label" id="email">邮 箱：</label>
                    <div class="layui-input-block">
                        <input type="text" name="email" class="layui-input" lay-verify="email|required">
                    </div>
                </div>
            </div>
            <%--第二列--%>
            <div class="layui-col-md6">
                <div class="layui-form-item">
                    <label class="layui-form-label" id="tele">手机号码：</label>
                    <div class="layui-input-block">
                        <input type="text" name="tele" class="layui-input" lay-verify="phone|required">
                    </div>
                </div>
            </div>
        </div>
        <%--第五行--%>
        <div class="layui-row layui-col-space10">
            <%--第一列--%>
            <div class="layui-col-md12">
                <div class="layui-form-item">
                    <label class="layui-form-label" id="address">家庭住址：</label>
                    <div class="layui-input-block">
                        <input type="text" name="address" class="layui-input" lay-verify="required">
                    </div>
                </div>
            </div>
        </div>
        <%--第六行--%>
        <div class="layui-row layui-col-space10">
            <%--第一列--%>
            <div class="layui-col-md1 layui-col-md-offset3">
                <button class="layui-btn" lay-submit lay-filter="btn_saveEmp">
                    <i class="layui-icon "> &#x1005;</i>保存
                </button>
            </div>
            <%--第二列--%>
            <div class="layui-col-md1 layui-col-md-offset4">
                <button class="layui-btn" lay-filter="btn_close" id="btn_close">
                    <i class="layui-icon"title="关闭">&#x1007;</i>关闭
                </button>
            </div>
        </div>
    </div>
</form>

</body>
</html>
