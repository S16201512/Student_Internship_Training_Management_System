<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
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
    .show{width:100%;overflow:hidden;}
    .show .show-wrap{margin: 0 auto;}
    .per-info{
        font-size: 25px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;
        line-height:50px;height:50px;width:250px;text-align: center
    }
    .per-input{
        margin-left:5%;height: 100%; overflow: hidden;float: left;margin-bottom: 8px;border: 1px #aaa solid;border-radius: 4px;background: 0 0;text-align: left;font-size: 20px;width: 438px;height: 50px;line-height: 2.4;padding: 0 20px;
    }
    .per-text{
        float:left;width: 80px;height: 30px;padding-top: 20px;font-size: 20px;
    }
</style>
<body style="background:url(../../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/teacher_mana_indexServlet" class="selected"><img src="../../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="/student_manage"><img src="../../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="/class_management_indexServlet""><img src="../../images/icon01.png" title="班级管理"/>
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
                <li class="active"><cite></cite><a href="/teacher_mana_indexServlet">教师管理首页</a><i></i></li>
                <li><cite></cite><a href="/admin/teacher_management/teacher_add.jsp">添加教师信息</a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main">
        <div style="width: 50%;overflow: hidden;margin: 0 auto;">
            <div style="color: #000;text-align: center;">
                <form action="/teacher_updateServlet" method="post" name="myForm">
                    <div style="width:130%;float: left;" >
                        <div class="per-text">编号:</div>
                        <div ><input class="per-input" type="text" name="tno" readonly="readonly" value="${teacher.getId()}"></div>
                    </div>

                    <div  style="width:130%;float: left;">
                        <div class="per-text">姓名:</div><div > <input class="per-input" type="text" name="name" value="${teacher.getName()}" ></div>
                    </div>

                    <div  style="width:130%;float: left;">
                        <div class="per-text">电话:</div><div ><input class="per-input" type="text" name="phone" value="${teacher.getPhone()}"></div>
                    </div>

                    <div style="width:130%;float: left;">
                        <div class="per-text">专业:</div><div ><input class="per-input" type="text" name="profession" value="${teacher.getProfession()}"></div>
                    </div>

                    <div style="width:130%;float: left;">
                        <div class="per-text">QQ号:</div><div ><input class="per-input" type="text" name="qq" value="${teacher.getQQ()}"></div>
                    </div>

                    <div style="padding-left:15%;width:35%;float: left;font-size: 20px;">
                        <div style="float: left;"><a style="color: #a00;font-size: 20px; background: #fff" href="javascript:void(0)" onclick="myForm.submit()" >修改</a></div>
                        <c:if test="${not empty null_msg}"><div style="color: #a00;font-size: 20px;">${null_msg}</div></c:if>
                    </div>

                    <div style="width:20%;float: left; font-size: 20px;">
                        <a style="color: #a00;font-size: 20px;" href="" onclick="window.confirm('确定删除吗？')?this.href='/teacher_deleteServlet?tno=${teacher.getId()}':this.href='/teacher_detailServlet?tno=${teacher.getId()}';">删除</a>
                    </div>

                </form>
            </div>
        </div>
        <div></div>
    </div>
</div>
</body>
</html>
