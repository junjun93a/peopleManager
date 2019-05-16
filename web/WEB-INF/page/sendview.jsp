<%@ page import="service.SendService" %>
<%@ page import="service.impl.SendServiceImpl" %>
<%@ page import="model.Visitor" %>
<%@ page import="model.Send" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/16
  Time: 22:38
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
    </style>
</head>
<body>
<span class="menu"><a href="/tosendview?tree=0">查看所有投递招聘</a></span>
<span class="menu"><a href="tosendview?tree=1">查看通知面试招聘</a></span>
<span class="menu"><a href="tosendview?tree=2">查看已录用面试</a></span>
<%
    SendService sendService=new SendServiceImpl();
    Visitor visitor =(Visitor) session.getAttribute("visitor");
    String tree="0";
    String tree1=request.getParameter("tree");
    List<Send> sends = sendService.selectSendbyvisitor(visitor.getT_ID());
    if(tree1!=null){
        tree=tree1;
    }
    if(tree.equals("1")){
        sends = sendService.selectSendbystaffvisitor(1,visitor.getT_ID());
    }else if(tree.equals("2")){
        sends = sendService.selectSendbystaffvisitor(2,visitor.getT_ID());
    }

    if(sends!=null&&sends.size()!=0){
        %>
<ul>
<%
        for (Send send : sends) {
            %>
    <li></li>
<%
        }
        %>
</ul>
<%
    }else {
        %>
<h3>暂无信息，去<a href="/tovrecruit">投递</a> </h3>
<%
    }
%>


</body>
</html>