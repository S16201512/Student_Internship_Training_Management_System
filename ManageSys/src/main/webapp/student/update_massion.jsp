<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>finis_massion</title>
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
    .main .massion { width: 1000px;height: 500px;background-color: #e9f7f5;margin-left: 80px}

</style>
<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="main.jsp"><img src="../images/home.png" width="64" height="64" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/student/main.jsp" ><img src="../images/icon02.png" title="1"/>
            <h2>个人信息</h2></a></li>
        <li><a href="/student/look_mission.jsp" class="selected"><img src="../images/icon03.png" title="2"/>
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

                <li class="active"><cite></cite><a href="/student/massionServlet">查看任务</a><i></i></li>
                <li ><cite></cite><a href="/student/RegistrationInfo.jsp">登记实训信息 </a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main">

            <div style="width: 80%;margin: 0 auto;overflow: hidden;margin-left: 9%;" id="div3" class="main">
                <h2 style="font-size: 16px;color: #202020;margin-bottom: 3%;height: 42px;border-bottom: solid 2px #70c6d9;padding-top: 12px;line-height: 42px;">任务内容:<br> </h2>
                <div >
                    <p>${studentTask2.getTask_content()}</p>
                    <%--任务附件部分--%>
                    <c:if test="${not empty studentTask2.getTask_file()}">
                        <c:forEach items="${studentTask2.getTask_file()}" var="fl" varStatus="vs">
                            <p style="">
                               ${vs.count})  <a href="/teacher/TaskFile/${fl.getFilename()}" download="${fl.getFilename()}">${fl.getFilename()}</a>
                            </p>
                        </c:forEach>
                    </c:if>
                    <h2 style="font-size: 16px;color: #202020;margin-bottom: 6%;height: 80px;border-bottom: solid 2px #70c6d9;padding-top: 12px;line-height: 42px;"></h2>
                    <%--任务附件结束--%>
                    <form action="/student/updateTask" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="task_no" value="${studentTask2.getId()}">
                    任务附件：<input id="file" multiple="multiple" name="task_file"   type="file" style="margin-top: 20px"><br>
                    <div>
                        <c:if test="${not empty studentTask2.getSubmit_file()}">
                        <textarea onclick="change()" style="border: 1px solid black" id="task_content"name="task_content"   cols="70" rows="10" >  ${studentTask2.getAnswer()}
                        </textarea><br>
                        </c:if>
                        <c:if test="${empty studentTask2.getSubmit_file()}">
                            <textarea  onclick="change()" style="border: 1px solid black" id="task_content"name="task_content"   cols="70" rows="10" > ${studentTask2.getAnswer()}
                            </textarea><br>
                        </c:if>
                        <input type="submit" value="保存修改" style="width: 50px; height: 20px;margin-left: 400px;margin-top: 10px">
                    </form>
                    </div>
                </div>
            </div>

    </div>
</div>
</body>
<script type="text/javascript">
    function change(){
        var obj=document.getElementById("file");
        var len=obj.files.length;
        var textArea=document.getElementById("task_content");
        var fileName="";
        if((textArea.value.trim()=="")) {
            for (var i = 0; i < len; i++) {
                var path = obj.files[i].name;
                var temp = path.substring(path.lastIndexOf("\\") + 1);
                if (i == 0) {
                    fileName = temp;
                } else {
                    fileName = fileName + "\n" + temp;
                }
            }
            document.getElementById("task_content").value = fileName;
        }
        //document.getElementById("task_content").value = document.getElementById("file").value;
    }
</script>
</html>
