<%@ page import="javaBean.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/student_css.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="../JS/jquery.js"></script>
</head>
<style>
    .size{width:200px;hight:200px;background-color: #90a2bc}
</style>
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
<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/student/main.jsp"><img src="../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="#" class="selected"><img src="../images/icon02.png" title="1"/>
            <h2>1</h2></a></li>
        <li><a href="#"><img src="../images/icon03.png" title="2"/>
            <h2>2</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="../index.jsp" target="_parent">退出</a></li>
        </ul>
        <div class="user">
            <span>${student_no}</span>
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
                <li ><cite></cite><a href="/student/selectMassage">查找信息</a><i></i></li>
                <li><cite></cite><a href="/student/st_psd_up.jsp">修改密码</a><i></i></li>
                <li class="active"><cite></cite><a href="/student/teacher_mission.jsp">任务栏</a><i></i></li>
            </ul>
        </dd>
    </dl>

    <div class="main">
        <%List<Task> list = (List<Task>)request.getAttribute("list");
            for(Task t :list){
        %>
        <div class="size">
            <a></a>
        </div>
        <% }%>
    </div>
</div>
</body>
</html>
