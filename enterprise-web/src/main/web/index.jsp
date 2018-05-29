<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/6 0006
  Time: 下午 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>校园乘车系统</title>

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/xcConfirm.css"/>
  <script src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
  <script src="${pageContext.request.contextPath}/static/js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
  <style type="text/css">
    .sgBtn{width: 135px; height: 35px; line-height: 35px; margin-left: 10px; margin-top: 10px; text-align: center; background-color: #0095D9; color: #FFFFFF; float: left; border-radius: 5px;}
  </style>
  <style type="text/css">
    body,td,th { font-family: "Source Sans Pro", sans-serif; }
    body { background-color: #2B2B2B; }
  </style>
</head>
<body>

<div class="wrapper">

  <div class="container">
    <h1>Welcome</h1>
    <form class="form" method="post" action="${pageContext.request.contextPath}/user/login.controller">
      <input type="text" placeholder="Username" name="username" autocomplete="off">
      <input type="password" placeholder="Password" name="password" autocomplete="off">
      <button  type="submit" id="login-button">Login</button>
    </form>
  </div>

  <ul class="bg-bubbles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
  </ul>

</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
    $('#login-button').click(function(){
        $(".form").action("${pageContext.request.contextPath}/user/login.controller").submit;
    });
</script>
<script>

</script>
</body>
  <script>
    var message="${message}";
    if(message.length>0){
            var txt=  "用户名或者密码错误";
            window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    }
  </script>
</html>