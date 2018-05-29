<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/6 0006
  Time: 下午 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<frameset rows="15%,*"  frameborder="0" border=0 framespacing="0" bordercolor="#008000">
    <frame src="${pageContext.request.contextPath}/turnPage/trunTop.controller"/>
    <frameset cols="16%,*"  frameborder="0" border=0 framespacing="0" bordercolor="#008000">
        <frame src="${pageContext.request.contextPath}/turnPage/trunLeft.controller"/>
        <frame name="rightPage"/>
    </frameset>
</frameset>
<body>

</body>
</html>
