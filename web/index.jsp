<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/8
  Time: 16:52
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
<a href="tologinview">游客登陆</a>
<a href="toregisterv">游客注册</a>
</body>
</html>