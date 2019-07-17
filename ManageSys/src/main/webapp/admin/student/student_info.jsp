<%@ page import="javaBean.Admin" %>
<%@ page import="javaBean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/7
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生信息界面</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/updateInfo_form.css" rel="stylesheet" type="text/css">
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
        <li><a href="/class_management_indexServlet"><img src="../../images/icon01.png" title="班级管理"/>
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
        <%
            List<Student> studentList = (List<Student>)request.getAttribute("studentList");
            Student student = studentList.get(0);
        %>
        <div class="form_wrap">
            <form class="form_info" action="/student_updateInfo_servlet" method="post" name="form1">
                <div class="each_line">
                    <span class="info_title">学号：</span>
                    <input style="margin-top: 8px;" class="input_info" type="text" name="sno" readonly="readonly" value="<%=student.getId()%>">

                </div>

                <div class="each_line">
                    <span class="info_title">密码：</span>
                    <input class="input_info" type="text" name="password" value="<%=student.getPsd()%>">
                    <span style="color: red;font-size: 18px;padding-top: 10px;">${updateStudentPasswordMessage}</span>
                </div>

                <div class="each_line">
                    <span class="info_title">名字：</span>
                    <input class="input_info" type="text" name="name" value="<%=student.getName()%>">
                    <span style="color: red;font-size: 18px;padding-top: 10px;">${updateStudentNameErrorMessage}</span>
                </div>

                <div class="each_line">
                    <span class="info_title">电话：</span>
                    <input class="input_info" type="text" name="phone" value="<%=student.getPhone()%>">
                    <span style="color: red;font-size: 18px;padding-top: 10px;">${updateStudentPhoneErrorMessage}</span>
                </div>

                <div class="each_line">
                    <span class="info_title">QQ：&nbsp;</span>
                    <input class="input_info" type="text" name="qq" value="<%=student.getQQ()%>">
                </div>
                <div  style="padding-left: 16%;width:10%;float: left;font-size: 20px;">
                    <div style="float: left;"><a style="color: #000;font-size: 20px; background: #fff" href="javascript:void(0)" onclick="form1.submit()">修改</a></div>
                </div>
                <div style="padding-left: 20%;width:30%;float: left; font-size: 20px;">
                    <div style="color: #a00;font-size: 20px;"><a style="background-color: #fff;color:#000;font-size: 20px;text-decoration: none;" onclick="return confirm('确定要删除么')" href="/delete_studentInfo_servlet?sno=<%=student.getId()%>">删除学生</a></div>
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>
