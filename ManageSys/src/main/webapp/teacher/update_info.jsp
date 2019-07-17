<%--  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/28
  Time: 10:46
  To change this template use File | Settings | File Templates.
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息修改</title>
</head>
<body>

</body>
</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人信息修改</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="../JS/jquery.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        //顶部导航切换
        $(".nav li a").click(function () {
            $(".nav li a.selected").removeClass("selected")
            $(this).addClass("selected");
        })
    })
</script>
<script type="text/javascript">
    $(function () {
        //导航切换
        $(".menuson li").click(function () {
            $(".menuson li.active").removeClass("active")
            $(this).addClass("active");
        });

        $('.title').click(function () {
            var $ul = $(this).next('ul');
            $('dd').find('ul').slideUp();
            if ($ul.is(':visible')) {
                $(this).next('ul').slideUp();
            } else {
                $(this).next('ul').slideDown();
            }
        });
    })
</script>
<style>
    .show{width:100%;overflow:hidden;}
    .show .show-wrap{margin: 0 auto;}
    .show .show-wrap .show-text{width: 100px;height: 30px}
    .per-info{
        font-size: 25px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;
        line-height:50px;height:50px;width:250px;text-align: center;outline: none;
    }
</style>
<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/teacher/teacher_index.jsp"><img src="../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/teacher_InfoServlet" class="selected"><img src="../images/icon02.png" title="个人信息"/>
            <h2>个人信息</h2></a></li>
        <li><a href="/teacher/handle_Button?id=2"><img src="../images/icon03.png"/>
            <h2>任务模块</h2></a></li>
    </ul>
 
    <div class="topright">
        <ul>
            <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="/logout">退出</a></li>
        </ul>
        <div class="user">
            <span>${teacher_no}</span>
        </div>
    </div>
</div>

<div class="container">
    <div class="lefttop"><span></span>列表</div>

    <dl class="leftmenu">
        <dd>
            <div class="title">
                <span><img src="../images/leftico01.png"/></span>管理信息
            </div>
            <ul class="menuson">
                <li><cite></cite><a  href="/teacher_InfoServlet">个人信息</a><i></i></li>
                <li><cite></cite><a href="/teacher/update_psd.jsp">修改密码</a><i></i></li>
                <li class="active"><cite></cite><a href="/get_update_infoServlet">修改个人信息</a><i></i></li>
                <li><cite></cite><a href="/teacher/displayLookBackPath">实习点最短回访路径</a><i></i></li>
            </ul>
        </dd>
    </dl>

    <%--内容模块--%>
    <div class="main">
        <div class="show">
            <div class="show-wrap">
                <form method="post" action="/update_infoServlet" style="text-align: center;font-size:25px;">
                    编号：<input class="per-info"  type="text" name="tno" value="${tno}" readonly="readonly"><br>
                    姓名：<input class="per-info" type="text" name="name" value="${name}" readonly="readonly"><br>
                    电话：<input class="per-info" type="text" name="phone" value="${phone}"><br>
                    qq号：<input class="per-info" type="text" name="qq" value="${qq}"><br>
                    专业：<input class="per-info" type="text" name="profession" value="${profession}"><br>
                    <input class="per-info" style="margin-left:15%;width:100px" type="submit" value="确认">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

