<%@ page import="javaBean.Admin" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/27
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/updateInfo_form.css" rel="stylesheet" type="text/css">
    <script language="JavaScript" src="../JS/jquery.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        //顶部导航切换
        $(".nav li a").click(function () {
            $(".nav li a.selected").removeClass("selected");
            $(this).addClass("selected");
        })
    })
</script>
<script type="text/javascript">
    $(function () {
        //导航切换
        $(".menuson li").click(function () {
            $(".menuson li.active").removeClass("active");
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
        <a href="/admin/admin_index.jsp"><img src="../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/teacher_mana_indexServlet"><img src="../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="/student_manage"><img src="../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="/class_management_indexServlet" ><img src="../../images/icon01.png" title="班级管理"/>
            <h2>班级管理</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="../index.jsp" target="_parent">退出</a></li>
        </ul>
        <div class="user">
            <span>${admin_no}</span>
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
                <li><cite></cite><a href="/admin/AdminInfo_Servlet">查看个人信息</a><i></i></li>
                <li class="active"><cite></cite><a href="/admin/Admin_GetUpdateInfo">修改个人信息</a><i></i></li>
                <li><cite></cite><a href="/admin/admin_updatePsd.jsp">修改个人密码</a><i></i></li>
                <li><cite></cite><a href="/admin/bulkInsert.jsp">导入人员信息</a><i></i></li>
                <li><cite></cite><a href="/admin/summary_graphServlet">实习信息统计图</a><i></i></li>
            </ul>
        </dd>
    </dl>

    <div class="main">
        <div class="form_wrap">
            <form class="form_info" action="/admin/AdminUpdateInfo_Servlet" method="post">
                <div class="each_line"><span class="info_title">账号：</span><input style="margin-top: 8px;" class="input_info" type="text" name="ano" readonly="readonly" value="${admin_no}"></div>
                <div class="each_line"><span class="info_title">姓名：</span><input class="input_info" type="text" name="name" value="${admin.getName()}"></div>
                <div class="each_line"><span class="info_title">电话：</span><input class="input_info" type="text" name="phone" value="${admin.getPhone()}"></div>
                <div class="each_line"><span class="info_title">QQ：&nbsp;</span><input class="input_info" type="text" name="qq" value="${admin.getQQ()}"></div>
                <div  class="confirm_button_wrap">
                    <input style="margin-left: -100px;" class="confirm_button" type="button" onclick="javascript:history.back(-1)" value="返回">
                     <input class="confirm_button" type="submit" value="确认">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>