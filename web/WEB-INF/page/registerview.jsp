<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/14
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<body>
<form action="registerS" method="post" onsubmit="return checkAll()">
    账 户 名:<input type="text" name="T_ACCOUNT" id="username"  required placeholder="请输入注册账号"/>
    <span id="span_name"></span><br/>

    密　　码:<input type="password" name="T_PASS" id="password" disabled required placeholder="请输入设置密码"/>
    <span id="span_password"></span><br/>

    性　别: <input id=sex1 type="radio" name="T_SEX" value="男" checked>男
    <input id=sex2 type="radio" name="T_SEX" value="女">女<br/>
    真实姓名：<input type="text" name="T_NAME" required placeholder="请输入真实姓名">
    <input id="butt" type="submit" value="注册完成"/><br>
    <a href="toindex">返回</a>
</form>

</body>
</html>