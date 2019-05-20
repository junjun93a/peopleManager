<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/20
  Time: 10:04
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

    <style>
        ul{
            list-style-type: none;
        }
        li{
            border:1px solid #A8CAEE;
        }
        .menu{
            margin-left: 20px;
        }
    </style>
</head>
<body>
<span class="menu"><a href="toasendview?tree=0">查看所有投递</a></span>
<span class="menu"><a href="toasendview?tree=1">查看未读投递</a></span>
<span class="menu"><a href="toasendview?tree=2">查看已读投递</a></span>
<span class="menu"><a href="toasendview?tree=3">查看已通知面试投递</a></span>
<span class="menu"><a href="toasendview?tree=4">查看已面试投递</a></span>

</body>
</html>