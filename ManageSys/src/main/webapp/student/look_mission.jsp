<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="javaBean.Task" %>
<%@ page import="javaBean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/student_css.css" rel="stylesheet" type="text/css"/>
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
    .main  .size{width: 89%;height: 745px;background: #90a2bc;margin-left: 200px;padding-top: 10px;}
    .main .size .view{width: 30%;height: 40%;background-color: #b7d5df;margin-left: 30px;margin-top: 20px;float: left;}
    .main .size .view button{position:relative;left: 270px;top: 90px;width: 150px;height: 60px}
    .main .size .view li{font-size: 26px}
</style>

<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="main.jsp"><img src="../images/home.png" width="64" height="64" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/student/main.jsp" ><img src="../images/icon02.png" title="1"/>
            <h2>个人信息</h2></a></li>
        <li><a href="/student/loadTask"class="selected"><img src="../images/icon03.png" title="2"/>
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
                <li class="active"><cite></cite><a href="/student/loadTask">查看任务</a><i></i></li>
                <li ><cite></cite><a href="/student/RegistrationInfo.jsp">登记实训信息 </a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main">
        <div style="width: 60%;margin: 0 auto;overflow: hidden;margin-left: 9%;" id="div3" class="main">

            <h2 style="font-size: 16px;color: #202020;margin-bottom: 3%;height: 42px;border-bottom: solid 2px #70c6d9;padding-top: 12px;line-height: 42px;">我的任务</h2>
            <!--列表内容-->
            <div class="task_content" style="height: 200px;">
                <c:if test="${not empty tasklist}">
                <c:forEach items="${tasklist}" var="task">
                <div class="each_task_wrap" style=" margin:10px;float:left;border: 0px solid #fff;box-shadow: 0px 2px 2px #ccc; width: 30%;height: 130px;">
                    <div class="each_task_info" style="margin-bottom: 5%;">

                        <div style="margin: 2px;color: #333;font-weight: bold;font-size: 16px;">${task.getTaskName()}</div>
                        <div style="margin: 4px;">开始时间:${task.getStart_time()}</div>
                        <div name="endTime"style="margin: 4px;">截止时间:${task.getEnd_time()}</div>
                        <div style="margin: 4px;">任务状态:${task.getTask_staus()}</div>
                    </div>
                    <div class="select_task" style="height: 40px;text-align: right;background-color: #38adda;">
                        <c:if test="${not empty task.getGrade()}">
                        <span style=" color: red;font-weight: bold;font-size: 16px;line-height: 45px;float: left;padding-left: 6px;padding-bottom: 4px;">
                            ${task.getGrade()}分
                        </span>
                        </c:if>
                        <c:if test="${task.getTask_staus()=='待做'}">

                            <a href="/student/LoadStudentTask?task_no=${task.getId()}&type=dofinished" style="line-height: 40px;font-size: 16px;padding: 10px;">
                                做作业
                            </a>
                        </c:if>
                        <c:if test="${task.getTask_staus()=='完成'}">
                            <a href="/student/LoadStudentTask?task_no=${task.getId()}&type=unfinished" style="line-height: 40px;font-size: 16px;padding: 10px;">
                                修改
                            </a>
                        </c:if>
                        <c:if test="${task.getTask_staus()=='已过期'}">
                            <a href="/student/LoadStudentTask?task_no=${task.getId()}&type=lookfinished" style="line-height: 40px;font-size: 16px;padding: 10px;">
                                查看
                            </a>
                        </c:if>
                    </div>
                </div>
                </c:forEach>
                </c:if>

            </div>

        </div>


        <!-- 动态生成页面跳转标签 -->
        <div style="padding-left:187px;width: 76%;overflow: hidden;margin: 0 auto;border: 1px solid #000;position: absolute;top: 96%;background-color: #3cc3f6;color: #fff;">
            <div style="height:30px;line-height:30px;">
                <div style="padding-left: 21.3%;height:30px;line-height:30px;width: 80px;float: left;"><%="第 "%>${current_page}<%=" 页"%></div>
                <div style="height:30px;line-height:30px;width: 80px;float: left;"><%="共 "%>${page_num}<%=" 页"%></div>
                <div style="float: left">
                    <a style="padding-left: 40px;" href="/student/loadTask?current_page=${1}">首页</a>
                    <a style="padding-left: 10px;padding-right: 10px;" href="/student/loadTask?current_page=${current_page>1 ? current_page-1:1}"><%="上一页 "%></a>
                    <c:forEach step="1" begin="1" end="${page_num}"  varStatus="status">
                        <c:if test="${status.current==current_page}">
                            <a style="color:#a00" href="/student/loadTask?current_page=${status.current}"><%=" "%>${status.current}<%=" "%></a>
                        </c:if>
                        <c:if test="${status.current!=current_page}">
                            <a href="/student/loadTask?current_page=${status.current}}"><%=" "%>${status.current}<%=" "%></a>
                        </c:if>
                    </c:forEach>
                    <a style="padding-left: 10px;padding-right: 10px;"  href="/student/loadTask?current_page=${current_page<page_num ? current_page+1:page_num}"><%=" 下一页"%></a>
                    <a  href="/student/loadTask?current_page=${page_num}">尾页</a>
                </div>
                <div style="height:30px;line-height:30px;width: 120px;float: left;padding-left: 50px;">
                    <div style="float: left;"><%="到"%></div>
                    <div style="float: left;padding-right: 10px;"><%="第"%></div>
                    <div style="float: left;">
                        <form style="padding-top: 2.5px;line-height:30px;height: 25px;width: 25px;float:left" action="/student/loadTask" method="post" name="form1">
                            <input type="text" name="current_page" style="border:1px solid #000;line-height:30px;height: 25px;width: 25px;text-align: center">
                        </form>
                    </div>
                    <div style="float: left;padding-right: 10px;padding-left: 10px;"><%="  页"%></div>
                    <a style="border: 1px solid #fcf5f5" href="javascript:void(0)" onclick="form1.submit()">确定</a>
                </div>


            </div>
        </div>
    </div>
</div>
</body>
</html>
