<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/updatePsd_form.css" rel="stylesheet" type="text/css">
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
        <li><a href="/teacher_mana_indexServlet" class="selected"><img src="../images/icon02.png" title="教师管理"/>
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
                <span><img src="../images/leftico01.png"/></span>管理信息
            </div>
            <ul class="menuson">
                <li><cite></cite><a href="/admin/AdminInfo_Servlet">查看个人信息</a><i></i></li>
                <li><cite></cite><a href="/admin/Admin_GetUpdateInfo">修改个人信息</a><i></i></li>
                <li class="active"><cite></cite><a href="/admin/admin_updatePsd.jsp">修改个人密码</a><i></i></li>
                <li><cite></cite><a href="/admin/bulkInsert.jsp">导入人员信息</a><i></i></li>
                <li><cite></cite><a href="/admin/summary_graphServlet">实习地点统计图</a><i></i></li>
            </ul>
        </dd>
    </dl>

    <div class="main">
        <div class="form_wrap">
            <form class="form_info" id="form_info" enctype="multipart/form-data" action="/admin/AdminUpdatePsd_Servlet" method="post">
                <div >
                    <input type="file" name="file" accept=".png,.jpg,.gif" onchange="OnInput(this)" id="upHeadImg" style="display: none">
                    <label for="upHeadImg">
                        <c:if test="${not empty IamgeName}">
                            <img style="width:80px;height:80px;position:relative;right:120px;margin:20px 0px;border:1px solid black;border-radius: 100%;"id="headImg" src="../images/headpic.jpg" />
                        </c:if>
                        <c:if test="${empty IamgeName}">
                            <img style="width:80px;height:80px;position:relative;right:120px;margin:20px 0px;border:1px solid black;border-radius: 100%;"id="headImg" src="../images/headpic.jpg" />
                        </c:if>
                    </label>

                </div>
                <div><input class="input_info" type="password" name="old_psd" placeholder="请输入原始密码"><span style="padding-right: 50px;padding-top: 10px;" class="error_message">${updatePsd_message1}</span></div>
                <div><br><input class="input_info" type="password" name="new_psd" placeholder="请输入新密码"><span style="padding-top: 48px;" class="error_message">${updatePsd_message2}</span></div>
                <div><br><input class="input_info" type="password" name="confirm_psd" placeholder="请再次输入新密码"><span style="padding-right: 10px;padding-top: 40px;" class="error_message">${updatePsd_message3}</span></div>
                  <div class="confirm_button_wrap">

                    <input style="" class="confirm_button" type="submit" value="确认"/>
                  </div>
            </form>
        </div>

    </div>
</div>
</body>

<%--Ajax来实现异步实时刷新用户头像--%>
<script>
    var str=${admin_no}
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            myFunction(this,str);
        }
    };
    xhttp.open("GET", "/xml/HeadImg.xml", true);
    xhttp.send();

    function myFunction(xml,str) {
        var i;
        var xmlDoc = xml.responseXML;
        var img="";
        var x = xmlDoc.getElementsByTagName("CD");
        for (i = 0; i <x.length; i++) {

            if (str == x[i].getElementsByTagName("userName")[0].childNodes[0].nodeValue) {

                img = x[i].getElementsByTagName("Headimg")[0].childNodes[0].nodeValue + "";

                document.getElementById("headImg").src = "../images/" + img;
                break;
            }
        }
        if(i>=x.length){
            document.getElementById("headImg").src = "../images/headpic.jpg" + img;
        }
    }
</script>

<%--实现上传头像刷新界面头像--%>

<script type="text/javascript">
    // Firefox, Google Chrome, Opera, Safari, Internet Explorer from version 9
    function OnInput (obj) {
        document.getElementById("headImg").src = window.URL.createObjectURL(obj.files[0]);
        document.getElementById("form_info").action="/admin/updateHeandImg"
        document.getElementById("form_info").submit();
    }
</script>
</html>