<%@ page import="javaBean.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
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
    .main ul {margin-top: 20px;}
    .main ul li{font-size: 15px; margin-top: 10px; margin-left: 400px;}
    .main ul li a {font-size: 15px; margin-left: 10px;text-decoration: none;}
    .main ul hr{  height:1px;border:none;border-top:1px solid #555555; margin-top: 10px;width: 80%;margin-left: 230px;position: absolute;}
</style>


<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="main.jsp"><img src="../images/home.png" width="64" height="64" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/student/main.jsp" class="selected"><img src="../images/icon02.png" title="1"/>
            <h2>个人信息</h2></a></li>
        <li><a href="/student/loadTask"><img src="../images/icon03.png" title="2"/>
            <h2>任务模块</h2></a></li>
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
                <li class="active"><cite></cite><a href="/student/selectMassage">查找信息</a><i></i></li>
                <li><cite></cite><a href="st_psd_up.jsp">修改密码</a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main">
        <form action="" method="get">
            <%
                List<Student> list1 = (List<Student>)request.getAttribute("list");
                for (Student s :list1){
            %>
            <ul>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账号:&nbsp;&nbsp;&nbsp;&nbsp;<%out.print(s.getId());%></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名:&nbsp;&nbsp;&nbsp;&nbsp;<%out.print(s.getName());%></li>
                <li>联系电话:&nbsp;&nbsp;&nbsp;&nbsp;<%out.print(s.getPhone());%></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;qq:&nbsp;&nbsp;&nbsp;&nbsp;<%out.print(s.getQQ());%></li>
            </ul>
            <%}%>
        </form>
    </div>
</div>
</body>
</html>
