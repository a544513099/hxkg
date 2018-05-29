<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/9 0009
  Time: 下午 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: black    ">
<div style="width: 30%;height: 100%;float: left;">
</div>
<div style="width: 50%;height: 100%;float: left">
    <h1 align="center" style="color: white">后台管理</h1>
</div>
<div style="width: 18%;height: 100%;float: left">
    <h4 align="center" style="color: white">欢迎${realName}登录，
        <a href="${pageContext.request.contextPath}" target="_parent">退出</a>
    </h4>
</div>
</body>
</html>
