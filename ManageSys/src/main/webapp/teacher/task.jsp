<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/2
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎！老师</title>
    ${teacher_no}
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="../JS/jquery.js"></script>
    <style>
        .elegant-aero {
            margin-left:auto;
            margin-right:auto;
            max-width: 500px;
            background: #D2E9FF;
            padding: 20px 20px 20px 20px;
            font: 12px Arial, Helvetica, sans-serif;
            color: #666;
        }
        .elegant-aero h1 {
            font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
            padding: 10px 10px 10px 20px;
            display: block;
            background: #C0E1FF;
            border-bottom: 1px solid #B8DDFF;
            margin: -20px -20px 15px;
        }
        .elegant-aero h1>span {
            display: block;
            font-size: 11px;
        }

        .elegant-aero label>span {
            float: left;
            margin-top: 10px;
            color: #5E5E5E;
        }
        .elegant-aero label {
            display: block;
            margin: 0px 0px 5px;
        }
        .elegant-aero label>span {
            float: left;
            width: 20%;
            text-align: right;
            padding-right: 15px;
            margin-top: 10px;
            font-weight: bold;
        }
        .elegant-aero input[type="text"], .elegant-aero input[type="email"], .elegant-aero textarea, .elegant-aero select {
            color: #888;
            width: 70%;
            padding: 0px 0px 0px 5px;
            border: 1px solid #C5E2FF;
            background: #FBFBFB;
            outline: 0;
            -webkit-box-shadow:inset 0px 1px 6px #ECF3F5;
            box-shadow: inset 0px 1px 6px #ECF3F5;
            font: 200 12px/25px Arial, Helvetica, sans-serif;
            height: 30px;
            line-height:15px;
            margin: 2px 6px 16px 0px;
        }
        .elegant-aero textarea{
            height:100px;
            padding: 5px 0px 0px 5px;
            width: 70%;
        }
        .elegant-aero .button{
            padding: 10px 30px 10px 30px;
            background: #66C1E4;
            border: none;
            color: #FFF;
            box-shadow: 1px 1px 1px #4C6E91;
            -webkit-box-shadow: 1px 1px 1px #4C6E91;
            -moz-box-shadow: 1px 1px 1px #4C6E91;
            text-shadow: 1px 1px 1px #5079A3;

        }
        .elegant-aero .button:hover{
            background: #3EB1DD;
        }
    </style>
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

<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="teacher_index.jsp">
            <img src="../images/home.png" width="64" height="64" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/teacher_InfoServlet"><img src="../images/icon02.png" title="个人信息"/>
            <h2>个人信息</h2></a></li>
        <li><a href="/teacher/handle_Button?id=2" class="selected"><img src="../images/icon03.png"/>
            <h2>任务模块</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span>
                <a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>

            <li><a href="/logout" target="_parent">退出</a></li>
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
                <li id="a">
                    <cite></cite><a href="/teacher/handle_Button?id=1">创建任务</a><i></i></li>
                <li id="aa">
                    <cite></cite><a href="/teacher/handle_Button?id=2">管理任务</a><i></i></li>
                <li id="aaa">
                    <cite></cite><a href="/teacher/loadCorrectTaskList">批改任务</a><i></i></li>
            </ul>
        </dd>
    </dl>

    <%--内容模块--%>
    <c:if test="${Button1=='1'}">
        <div id="div1" class="main">
            <h1>任务创建</h1>
            <form method="post" name="baseForm" action="/teacher/createTaskServlet" enctype="multipart/form-data"
                  class="elegant-aero">
                <h1>Task Form
                    <span>Please fill all the texts in the fields.</span>
                </h1>
                <label>
                    <span>任务名：</span>
                    <input  id="task_name" name="task_name" type="text">
                </label>
                <label>
                    <span>任务内容:</span>
                    <textarea onclick="setCursorPosition(this, 0)" id="task_content" name="task_content" placeholder="任务内容">

                    </textarea>
                </label>
                <input type="hidden" name="tno" multiple value=${teacher_no}>
                <label >
                    <span style="margin-left: 10px">任务附件：</span> 
                     <lable for="task_file" id="displayFile" style="display:block;margin-left:23.5%;background-color: snow;width: 70%;height: 16px">
                         -----请选择任务附件-----
                     </lable>                
                     <input id="task_file"name="task_file" onchange="javascript:
                    if(this.value!=null)
                            var str='';
                            var t_files = this.files;
                            for (var i = 0, len = t_files.length; i < len; i++) {

                             str += t_files[i].name+';   ';}
                            document.getElementById('displayFile').innerHTML=str;
                        "
                            style="border: 1px solid black;margin-left:-82px;margin-top: 7px;display: none" multiple="multiple" type="file">                           
                </label>
                <label style="margin-top: 20px">
                    <span style="margin-left: 10px">开始时间：</span>
                    <input name="start_time" id="start_time" style="margin-top: 7px;margin-left: -6px;"type="datetime-local">
                </label>
                <label style="margin-left: 12px">
                    <span >截止时间：</span>
                    <input name="end_time" id="end_time"style="margin-top: 7px;margin-left: -6px;" type="datetime-local">
                </label>
                <label style="margin-top: 17px;margin-left: 50px;">
                    <input type="button" class="button" value="立即创建" onclick="check()">
                </label>


            </form>

        </div>
    </c:if>
    <c:if test="${Button1=='2'}">
        <div id="div2" class="main">
            <h1 style="background-color: #57c1f6;color:#fff;">管理任务</h1>
            <div style="width: 100%;height: 100%;border-bottom:1px solid black;float:left; ">

                <div style="width: 100%;height: 4.5%;border: 0px solid black  ">
                    <div style="margin-left: 60px;width:18%;float:left" > 任务名称</div>
                    <div style="width:18%;float:left" > 创建时间</div>
                    <div style="width:18%;float:left" > 开始时间</div>
                    <div style="width:18%;float:left" > 结束时间</div>
                    <div style="width:18%;float:left" > 操作</div>
                </div>

                <div style="width: 100%;height: 47%;border: 0px solid black ;">
                    <c:if test="${empty tasklist}">
                        <div style="text-align: center">
                            暂无任务

                        </div>

                    </c:if>
                    <c:if test="${not empty tasklist}">


                        <c:forEach items="${tasklist}" var="task" varStatus = "v">
                            <c:if test="${v.count%2=='1'}">

                                <div style="padding-left: 60px;width:18% ;float:left">
                                        ${task. getTaskName()}

                                </div>
                                <div style="width:18% ;float:left">
                                        ${task.getCreate_time()}
                                </div>
                                <div style="width:18% ;float:left">
                                        ${task.getStart_time()}
                                </div>
                                <div style="width:18% ;float:left">
                                        ${task.getEnd_time()}

                                </div>
                                <div style="width:23.2% ;float:left;">
                                    <div style="width:33%;float:left;">
                                        <a style="text-decoration:none;text-align: center" href="/teacher/publishTask?id=${task.getId()}">
                                            发布
                                        </a>
                                    </div>
                                    <div style="width:33%;float:left;">
                                        <a style="text-decoration:none;text-align: center" href="/teacher/updateTask?id=${task.getId()}">
                                            修改
                                        </a>
                                    </div>
                                    <div style="width:33%;float:left;">
                                        <a style="text-decoration:none;text-align: center" href="/teacher/deleteTaskServlet?id=${task.getId()}">
                                            删除
                                        </a>
                                    </div>



                                </div>
                            </c:if>
                            <c:if test="${v.count%2=='0'}">

                                <div style="padding-left: 60px;background-color: #57c1f6;width:18% ;float:left">
                                        ${task.getTaskName()}

                                </div>
                                <div style="width:18% ;background-color: #57c1f6;float:left">
                                        ${task.getCreate_time()}
                                </div>
                                <div style="width:18% ;background-color: #57c1f6;float:left">
                                        ${task.getStart_time()}
                                </div>
                                <div style="width:18% ;background-color: #57c1f6;float:left">
                                        ${task.getEnd_time()}

                                </div>

                                <div style="width:23.2% ;background-color: #57c1f6;float:left;">
                                    <div style="width:33%;float:left;">
                                        <a style="text-decoration:none;text-align: center" href="/teacher/publishTask?id=${task.getId()}">
                                            发布
                                        </a>
                                    </div>
                                    <div style="width:33%;float:left;">
                                        <a style="text-decoration:none;text-align: center" href="/teacher/updateTask?id=${task.getId()}">
                                            修改
                                        </a>
                                    </div>
                                    <div style="width:33%;float:left;">
                                        <a style="text-decoration:none;text-align: center" href="/teacher/deleteTaskServlet?id=${task.getId()}">
                                            删除
                                        </a>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </div>
                <div style="width: 100%;height: 47%;border-top: 1px solid #57c1f6">
                    <div style="padding-bottom: 20px;border-bottom: 1px solid #57c1f6;text-align: center;">
                        <div style="padding-left: 60px;width:18% ;float:left">任务名称
                        </div>
                        <div style="width:18% ;float:left">
                            创建时间
                        </div>
                        <div style="width:18% ;float:left">
                            开始时间
                        </div>
                        <div style="width:18% ;float:left">
                            截止时间
                        </div>
                        <div style="width:23.2% ;float:left;">
                            <div style="width:50%;float:left;">
                                操作
                            </div>
                                <%--<div style="width:50%;float:left;">
                                    <a  style="text-decoration:none " href="/teacher/cancleTask?id=${task.getId()}">
                                        查看
                                    </a>
                                </div>--%>
                        </div>
                    </div>
                    <c:if test="${empty tasklist2}">
                        <div style="text-align: center">
                            暂无发布任务
                        </div>

                    </c:if>
                    <c:if test="${not empty tasklist2}">
                        <c:forEach items="${tasklist2}" var="task" varStatus = "vs">
                            <c:if test="${vs.count%2=='1'}">
                                <div style="text-align: center">
                                    <div style="padding-left: 60px;background-color: #57c1f6;width:18% ;float:left">
                                            ${task. getTaskName()}

                                    </div>
                                    <div style="width:18% ;background-color: #57c1f6;float:left">
                                            ${task.getCreate_time()}
                                    </div>
                                    <div style="width:18% ;background-color: #57c1f6;float:left">
                                            ${task.getStart_time()}
                                    </div>
                                    <div style="width:18% ;background-color: #57c1f6;float:left">
                                            ${task.getEnd_time()}

                                    </div>
                                    <div style="width:23.2% ;background-color: #57c1f6;float:left;">
                                        <div style="width:50%;float:left;">
                                            <a  style="text-decoration:none " href="/teacher/cancleTask?id=${task.getId()}">
                                                撤销发布
                                            </a>
                                        </div>
                                            <%--<div style="width:50%;float:left;">
                                                <a  style="text-decoration:none " href="/teacher/cancleTask?id=${task.getId()}">
                                                    查看
                                                </a>
                                            </div>--%>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${vs.count%2=='0'}">
                                <div style="text-align: center;">
                                    <div style="margin-left: 60px;width:18% ;float:left">
                                            ${task. getTaskName()}

                                    </div>
                                    <div style="width:18% ;float:left">
                                            ${task.getCreate_time()}
                                    </div>
                                    <div style="width:18% ;float:left">
                                            ${task.getStart_time()}
                                    </div>
                                    <div style="width:18% ;float:left">
                                            ${task.getEnd_time()}

                                    </div>
                                    <div style="width:23.2% ;float:left;">
                                        <div style="width:50%;float:left;">
                                            <a  style="text-decoration:none;text-align: center " href="/teacher/cancleTask?id=${course.getId()}">
                                                撤销发布
                                            </a>
                                        </div>
                                            <%--<div style="width:50%;float:left;">
                                                <a  style="text-decoration:none " href="/teacher/cancleTask?id=${task.getId()}">
                                                    查看
                                                </a>
                                            </div>--%>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </div>
        </div>
    </c:if>
            <c:if test="${Button1=='3'}">
                <div style="width: 60%;margin: 0 auto;overflow: hidden;margin-left: 9%;" id="div3" class="main">

                    <h2 style="font-size: 16px;color: #202020;margin-bottom: 3%;height: 42px;border-bottom: solid 2px #70c6d9;padding-top: 12px;line-height: 42px;">我的任务</h2>
                    <!--列表内容-->

                    <div class="task_content" style="height: 200px;">
                        <c:if test="${not empty taskList3}">
                            <c:forEach items="${taskList3}" var="task">
                                <div class="each_task_wrap" style=" float:left;border: 0px solid #fff;box-shadow: 0px 2px 2px #ccc; width: 30%;height: 130px;margin: 10px 15px;">
                                    <div class="each_task_info" style="margin-bottom: 5%;">

                                        <div style="margin: 2px;color: #333;font-weight: bold;font-size: 16px;">${task.getTaskName()}</div>
                                        <div style="margin: 4px;">开始时间:${task.getStart_time()}</div>
                                        <div name="endTime"style="margin: 4px;">截止时间:${task.getEnd_time()}</div>
                                        <div style="margin: 4px;">提交人数:${task.getSubmitPerson()}/${task.getTotalPerson()}</div>
                                    </div>
                                    <div class="select_task" style="height: 40px;text-align: right;background-color: #38adda;">
                                            <a href="/teacher/loadCorrentTaskList?taskno=${task.getId()}"style="line-height: 40px;font-size: 16px;padding: 10px;">
                                                查看
                                            </a>

                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>

                </div>


            </c:if>

        <%-- 任务查看模块结束--%>
    <c:if test="${Button1=='4'}">
          <div id="div3" class="main">
                    <h1>任务修改</h1>

              <form method="post" name="baseForm" action="/teacher/Update_task_info" enctype="multipart/form-data"
                    class="elegant-aero">
                  <h1>Task Form
                      <span>Please fill all the texts in the fields.</span>
                  </h1>
                  <label>
                      <span>任务名：</span>
                      <input   name="task_name" type="text" value="${task.getTaskName()}">
                  </label>
                  <label>
                      <span>任务内容:</span>
                      <textarea onclick="setCursorPosition(this, 0)"  name="task_content" placeholder="任务内容">${task.getTask_content()}

                    </textarea>
                  </label>
                  <input type="hidden" name="task_no" value=${task.getId()}>
                  <label>
                      <span style="margin-left: 10px">任务附件：</span> 
                      <c:if test="${not empty fileList}">
                          <lable for="task_file" id="displayFile2" style="display:block;margin-left:23.5%;background-color: snow;width: 70%;height: 16px">
                              <c:forEach items="${fileList}" var="file">
                                  ${file.getFilename()};
                              </c:forEach>
                          </lable> 
                      </c:if>
                      <c:if test="${empty fileList}">
                          <lable for="task_file" id="displayFile2" style="display:block;margin-left:23.5%;background-color: snow;width: 70%;height: 16px">
                              -----请选择任务附件-----
                          </lable> 
                      </c:if>

                                     
                       <input name="task_file" onchange="javascript:
                    if(this.value!=null)
                            var str='';
                            var t_files = this.files;
                            for (var i = 0, len = t_files.length; i < len; i++) {

                             str += t_files[i].name+';   ';}
                            document.getElementById('displayFile2').innerHTML=str;
                        " style="border: 1px solid black;margin-left:-82px;margin-top: 7px;display: none" multiple="multiple" type="file">                           
                  </label>
                  <label style="margin-top: 20px">
                      <span style="margin-left: 10px">开始时间：</span>
                      <input name="start_time" value="2017-06-30T13:30:00"  style="margin-top: 7px;margin-left: -6px;"type="datetime-local">
                  </label>
                  <label style="margin-left: 12px">
                      <span >截止时间：</span>
                      <input name="end_time" value="${task.getEnd_time()}" style="margin-top: 7px;margin-left: -6px;" type="datetime-local">
                  </label>
                  <label style="margin-top: 17px;margin-left: 50px;">
                      <input type="button" class="button" value="保存修改" onclick="check()">
                  </label>
              </form>

          </div>
    </c:if>
            <c:if test="${Button1=='5'}">

            <div id="div2" class="main">
                <h1>批改任务</h1>
                <div style="width: 100%;height: 100%;border-bottom:1px solid black;float:left;background-color: rgba(218,255,253,0.81) ">

                    <div style="width: 100%;height: 4.5%;border: 0px solid black  ">
                        <div style="margin-left: 60px;width:13%;float:left" > 任务名称</div>
                        <div style="width:13%;float:left" > 学生学号</div>
                        <div style="width:13%;float:left" > 学生姓名</div>
                        <div style="width:13%;float:left" > 上交时间</div>
                        <div style="width:13%;float:left" > 成绩</div>
                        <div style="width:13%;float:left" > 操作</div>
                    </div>

                    <div style="width: 100%;height: 47%;border: 0px solid black ;">
                        <c:if test="${empty tasklist7}">
                            <div style="text-align: center">
                                暂无批改任务

                            </div>

                        </c:if>
                        <c:if test="${not empty tasklist7}">


                            <c:forEach items="${tasklist7}" var="task" varStatus = "v">
                                <c:if test="${v.count%2=='1'}">

                                    <div style="padding-left: 60px;background-color: #1babb3;width:13% ;float:left">
                                            ${task. getTaskName()}

                                    </div>
                                    <div style="width:13% ;background-color: #1babb3;float:left">
                                            ${task.getStudentNo()}
                                    </div>
                                    <div style="width:13% ;background-color: #1babb3;float:left">
                                            ${task.getStudentName()}
                                    </div>
                                    <div style="width:13% ;background-color: #1babb3;float:left">
                                            ${task.getSubmit_time()}

                                    </div>
                                    <c:if test="${not empty task.getGrade()}">
                                        <div style="width:13% ;background-color: #1babb3;float:left">
                                                ${task.getGrade()}
                                        </div>
                                    </c:if>
                                    <c:if test="${empty task.getGrade()}">
                                        <div style="width:13% ;background-color: #1babb3;float:left">
                                            --
                                        </div>
                                    </c:if>

                                    <div style="width:23.2% ;background-color: #1babb3;float:left;">
                                        <div style="width:33%;float:left;">
                                            <a style="text-decoration:none;text-align: center" href="/teacher/loadStudentFinishedTask?sno=${task.getStudentNo()}&task_no=${task.getId()}">
                                                批阅
                                            </a>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${v.count%2=='0'}">

                                    <div style="padding-left: 60px;background-color: rgba(218,255,253,0.81);width:13% ;float:left">
                                            ${task.getTaskName()}

                                    </div>
                                    <div style="width:13% ;background-color: rgba(218,255,253,0.81);float:left">
                                            ${task.getStudentNo()}
                                    </div>
                                    <div style="width:13% ;background-color: rgba(218,255,253,0.81);float:left">
                                            ${task.getStudentName()}
                                    </div>
                                    <div style="width:13% ;background-color: rgba(218,255,253,0.81);float:left">
                                            ${task.getSubmit_time()}

                                    </div>

                                    <div style="width:23.2% ;background-color: rgba(218,255,253,0.81);float:left;">
                                        <div style="                                width:33%;float:left;">
                                            <a style="text-decoration:none;text-align: center" href="/teacher/loadStudentFinishedTask?sno=${task.getStudentNo()}&task_no=${task.getId()}">
                                                批阅
                                            </a>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                </c:if>

            <c:if test="${Button1=='6'}">
                    <div style="width: 60%;margin: 0 auto;overflow: hidden;margin-left: 10%;" class="main">
                        <!--第一行--标题-->
                        <div>
                            <h2 style="color: #333;font-weight: bold;font-size: 16px;margin-bottom: 3%;height: 42px;border-bottom: solid 2px #70c6d9;padding-top: 12px;line-height: 42px;">任务名</h2>
                            <div style="float: right;"><a style="" href="/teacher/loadCorrentTaskList?taskno=${studentTask.getId()}">返回</a></div>
                        </div>

                        <!--第二行--个人信息板块-->
                        <div style="height: 60px;border-bottom: 1px solid #85bdda;">
                            <p>
                                <span style="float: left;margin-right: 30px;color: #888888;">姓名：<i style="color: #333;font-weight: normal;font-style: normal;text-decoration: none;">${studentTask.getStudentName()} </i></span>
                                <span style="float: left;color: #888888;">班级：<i style="color: #333;font-weight: normal;font-style: normal;text-decoration: none;">${studentTask.getCno()} </i></span>
                            </p>
                        </div>

                        <!--第三行内容板块-->
                        <div style="width: 80%;margin: 0 auto;">
                            <h2 style="text-align: center;color: #333;font-size: 18px;height: 42px;padding-top: 12px;">任务名${studentTask.getTaskName()}</h2>

                            <div style="width: 100%;margin: 0 auto;font-size: 15px;word-wrap: break-word; word-break:break-all;overflow: hidden;">
                                <div style="margin-bottom: 20px;color: #333;font-weight: bold;font-style: normal;text-decoration: none;font-size: 14px;">任务内容:
                 ${studentTask.getTask_content()}</div>

                                <div style="letter-spacing:2px;font-size: 15px;font-family: 宋体;word-wrap: break-word; word-break:break-all;overflow: hidden;">
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>

                                </div>

                            </div>

                            <!--学生提交内容板块-->
                            <div style="margin-top: 30px;">
                                <p><i style="color: #333;font-weight: bold;font-style: normal;text-decoration: none;font-size: 14px;">学生答案：</i></p>
                                <div style="font-size: 15px;font-family: 仿宋; word-wrap: break-word; word-break:break-all;overflow: hidden;">
                                    <c:if test="${not empty studentTask.getSubmit_file()}">
                                      <h3> 文件部分：</h3>
                                        <c:forEach items="${studentTask.getSubmit_file()}" var="fl" varStatus="vs">

                                            <p style="">

                                                    ${vs.count})   <a href="/student/TaskFile/${fl.getFilename()}" style="font-size: 15px;font-family: 仿宋;"  download="${fl.getFilename()}">${fl.getFilename()}</a>
                                            </p>

                                        </c:forEach>
                                    </c:if>
                                    <h3>  提交答案：</h3>
                                    <c:if test="${not empty studentTask.getAnswer()}">
                                        ${studentTask.getAnswer()}
                                    </c:if>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>

                                </div>
                            </div>

                            <!--批改板块-->
                            <div style="box-shadow:  0px 2px 2px #ccc;">
                                <form action="/teacher/ScoredTask" method="post">
                                    <div style="text-align: center;line-height: 30px;box-shadow: 1px 1px 1px 0px #ccc;margin-bottom: 1px;overflow: hidden;">
                                        <span style="float: left;color: #333;font-weight: bold;font-style: normal;text-decoration: none;font-size: 14px;">评分：</span>
                                        <input style="width: 90%;height:30px;float: left;border: 0px;outline: none;" type="number" value="0" name="score">
                                    </div>
                                    <input type="hidden" name="sno" value="${studentTask.getStudentNo()}">
                                    <input type="hidden" name="task_no" value="${studentTask.getId()}">

                                    <div>
                                        <textarea style="text-align: unset;min-height:50px;
                                        height:auto; width: 100%;outline: none;"  name="remark" placeholder="请输入评语"></textarea>


                                    </div>

                                    <input
                                            style=" display: inline-block;height: 28px;padding: 0 10px;background: #367e9e;font-size: 14px;color: #FFF;line-height: 28px;cursor: pointer;border-radius: 3px;" type="submit" value="提交">
                                </form>
                            </div>
                        </div>
                    </div>
        </c:if>


            </div>
</body>
<script type="text/javascript">
    function check(){
        var name=document.getElementsByName("task_name")[0].value;
        var content=document.getElementsByName("task_content")[0].value;
        var beginDate=document.getElementsByName("start_time")[0].value;
        var endDate=document.getElementsByName("end_time")[0].value;
        var d1 = new Date(beginDate.replace(/\-/g, "\/"));
        var d2 = new Date(endDate.replace(/\-/g, "\/"));
        var a1=beginDate.split("T");
        var b1=endDate.split("T");
        if(name.trim()==""){
            alert('任务名不能为空!');
            document.baseForm.name.focus();
        }else if(content.trim()==""){
            alert('任务内容不能为空');
            if(beginDate==""||endDate==""){
                alert(d1+","+d2);
            }
        }else if(beginDate==""||endDate==""){
            alert(d1+","+d2);

        }else if(beginDate!=""&&endDate!="") {
            if (a1[0] > b1[0]) {
                alert("开始时间大于结束时间,error!");

            }
            else if (a1[0] == b1[0]) {
                if (a1[1] > b1[1]) {
                    alert("开始时间大于结束时间");
                }
                else if (a1[1]==b1[1]) {
                    alert("开始时间等于结束时间");
                }
                else if((a1[1] < b1[1]))
                    document.getElementsByName("baseForm")[0].submit();
            }else
                document.getElementsByName("baseForm")[0].submit();

            } else {
                document.getElementsByName("baseForm")[0].submit();
            }
        }


</script>
<script>
/*
* 设置输入域(input/textarea)光标的位置
* @param {HTMLInputElement/HTMLTextAreaElement} elem
* @param {Number} index
*/
function setCursorPosition(elem, index) {
        var val = elem.value;
        var len = val.length;

        // 超过文本长度直接返回
        if (len < index) return
            setTimeout(function() {
            elem.focus();
        if (elem.setSelectionRange) { // 标准浏览器
            elem.setSelectionRange(index, index)
        } else { // IE9-
            var range = elem.createTextRange()
            range.moveStart("character", -len)
            range.moveEnd("character", -len)
            range.moveStart("character", index)
            range.moveEnd("character", 0)
            range.select()
        }
        }, 10)
        }
</script>
<%--控制开始时间不能小于结束时间--%>
<script>

    /*beginDate可以是"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm","yyyy-MM-dd HH","yyyy-MM-dd"*/
</script>



<script type="text/javascript">
    var selectbutton=${Button1}

    if(selectbutton=='1'){
        $(".menuson li.active").removeClass("active");
        $('#a').addClass("active");
    }else if(selectbutton=='2'){
        $(".menuson li.active").removeClass("active");
        $('#aa').addClass("active");
    }else if(selectbutton=='3'){
        $(".menuson li.active").removeClass("active");
        $('#aaa').addClass("active");
    }
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

<script>
    $(".upload .upload-input-file").change(function () {
        if ($(this).parent().html().indexOf("class=\"upload-url\"") != -1) {
            var fileUrl = $(this).val();
            $(this).parent().children(".upload-url").val(fileUrl);
        }
        else {
            var fileUrl = $(this).val();
            var urlArr = fileUrl.split("\\");
            var getName = urlArr[urlArr.length - 1];//截取路径并获取文件的名字 
            $(this).parent().children(".upload-tip").text(getName).fadeIn("slow");
            //$(this).parent().children(".upload-btn").val(getName);//按钮上变成文件名称
            timeout = setTimeout(function () {
                $(".upload-tip").fadeOut("slow");
            }, 5000);
        }
    });
</script>
</html>
