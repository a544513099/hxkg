<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/11 0011
  Time: 上午 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>菜单</title>
    <script src="${pageContext.request.contextPath}/static/js/adapter.js"></script> <!--rem适配js-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/base.css"> <!--初始化文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/menu.css"> <!--主样式-->

</head>
<body>

<div id="menu">
    <!--隐藏菜单-->
    <div id="ensconce">
        <h2>
            <img src="images/show.png" alt="">
            乘车后台管理
        </h2>
    </div>

    <!--显示菜单-->
    <div id="open">
        <div class="navH">
            乘车后台管理
            <span><img class="obscure" src="images/obscure.png" alt=""></span>
        </div>
        <div class="navBox">
            <ul>
                <li>
                    <h2 class="obtain">公司介绍<i></i></h2>
                    <div class="secondary">
                        <h3><a href="${pageContext.request.contextPath}/banci/toManagerBanci.controller" target="rightPage">公司介绍</a></h3>
                        <h3><a href="${pageContext.request.contextPath}/banci/toManagerBanci.controller" target="rightPage">团队架构</a></h3>
                        <h3><a href="${pageContext.request.contextPath}/banci/toManagerBanci.controller" target="rightPage">企业文化</a></h3>
                        <h3><a href="${pageContext.request.contextPath}/banci/toManagerBanci.controller" target="rightPage">荣誉资质</a></h3>

                    </div>

                </li>
                <li>
                    <h2 class="obtain">行业方案<i></i></h2>
                    <div class="secondary">
                        <h3><a href="${pageContext.request.contextPath}/car/doList.controller" target="rightPage">用户留言</a></h3>
                        <h3><a href="${pageContext.request.contextPath}/car/doList.controller" target="rightPage">产品展示</a></h3>

                    </div>

                </li>
                <li>
                    <h2 class="obtain">行业会话<i></i></h2>
                    <div class="secondary">
                        <h3><a href="${pageContext.request.contextPath}/driver/doList.controller" target="rightPage">司机管理</a><br/></h3>
                    </div>
                </li>
                <li>
                    <h2 class="obtain">合作伙伴<i></i></h2>
                    <div class="secondary">
                        <h3> <a href="${pageContext.request.contextPath}/user/doList.controller" target="rightPage">用户管理</a></h3>
                    </div>
                </li>
                <li>
                    <h2 class="obtain">会员注册<i></i></h2>
                    <div class="secondary">
                        <h3><a href="${pageContext.request.contextPath}/count/countUserRideCount.controller" target="rightPage">乘坐统计</a></h3>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/js/menu.js"></script> <!--控制js-->
</body>
</html>