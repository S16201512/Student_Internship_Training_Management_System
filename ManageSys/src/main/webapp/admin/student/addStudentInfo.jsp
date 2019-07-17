<%@ page import="javaBean.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/7
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加新学生界面</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="../../JS/jquery.js"></script>
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
<style>
    .per-input{
        margin-left:4%;height: 100%; overflow: hidden;float: left;margin-bottom: 8px;border: 1px #aaa solid;border-radius: 4px;background: 0 0;text-align: left;font-size: 20px;width: 438px;height: 50px;line-height: 2.4;padding: 0 20px;
    }
    .per-text{
        float:left;width: 80px;height: 30px;padding-top: 10px;font-size: 20px;
    }
</style>
<body style="background:url('../../images/topbg.gif') repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/teacher_mana_indexServlet" ><img src="../../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="/student_manage" class="selected"><img src="../../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="/class_management_indexServlet" ><img src="../../images/icon01.png" title="班级管理"/>
            <h2>班级管理</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="/logout">退出</a></li>
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
                <span><img src="../../images/leftico01.png"/></span>管理信息
            </div>
            <ul class="menuson">
                <li class="active"><cite></cite><a href="/admin/student/addStudentInfo.jsp">增加学生</a><i></i></li>
            </ul>
        </dd>
    </dl>


    <div class="main">
        <div style="width: 60%;overflow: hidden;margin: 0 auto;">
            <div style="font-size: 30px;color: #000;text-align: center;padding-top: 20px;padding-right: 75px;">添加学生信息</div>
            <div style="color: #000;text-align: center;padding-top: 20px;">
                <form method="get" action="/addStudent_servlet" name="myForm1">
                    <div style="width:130%;float: left;">
                        <div class="per-text">学号：</div>
                        <div><input class="per-input" name="sno"  type="text"/></div>
                        <div style="padding-top: 10px;color: red;float:left;font-size: 18px;width: 150px;height: 50px;">${addStudentSnoErrorMessage}</div>
                    </div>
                    <div style="width:130%;float: left;">
                        <div class="per-text">密码：</div>
                        <div><input class="per-input" name="password"  type="text"/></div>
                        <div style="padding-top: 14px;color: red;float:left;font-size: 18px;width: 150px;height: 50px;">${addStudentPasswordMessage}</div>
                    </div>
                    <div style="width:130%;float: left;">
                        <div class="per-text">姓名：</div>
                        <div><input class="per-input" name="name" type="text"/></div>
                        <div style="padding-top: 10px;color: red;float:left;font-size: 18px;width: 150px;height: 50px;">${addStudentNameErrorMessage}</div>
                    </div>
                    <div style="width:130%;float: left;">
                        <div class="per-text">电话：</div>
                        <div><input class="per-input" name="phone"  type="text"/></div>
                        <div style="padding-top: 11px;color: red;float:left;font-size: 18px;width: 150px;height: 50px;">${addStudentPhoneErrorMessage}</div>
                    </div>
                    <div style="width:130%;float: left;">
                        <div class="per-text">Q Q：</div>
                        <div><input class="per-input" name="qq"  type="text"/></div>
                    </div>

                    <div style="padding-left: 30%;width:60%;float: left;font-size: 20px;">
                        <a style="font-size: 20px; background: #fff;" href="javascript:void(0)" onclick="myForm1.submit()">添加</a>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
