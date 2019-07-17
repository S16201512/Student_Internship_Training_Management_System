<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎使用专业实习实训管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="JS/jquery.js"></script>
    <script src="JS/cloud.js" type="text/javascript"></script>
</head>

<script language="javascript">
    $(function () {
        $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 471) / 2});
        $(window).resize(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 471) / 2});
        })
    });
</script>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>

<div class="logintop">
    <span>欢迎使用专业实习实训管理系统</span>
    <ul>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">
    <span class="systemlogo"></span>
    <div class="loginbox" style="border:1px solid black;height: 400px;">
        <form action="./login" method="post"  >
            <div >
                <img style="width:80px;height:80px;margin: 20px 183px;border-radius: 100%;"id="headImg" src="images/headpic.jpg" />
            </div>
            <ul >
                <li><input name="id" id="username"onkeyup="loadXMLDoc(this.value)" type="text" class="loginuser" placeholder="学号/工号"/></li>
                <li><input name="password" type="password" class="loginpwd" placeholder="密码"/></li>
                <li>
                    <select name="identity" class="loginselect" style="margin-left: 65px;">
                        <option value="admin">管理员</option>
                        <option value="teacher">教师</option>
                        <option value="student">学生</option>
                    </select>
                </li>
                <li>
                    <input style="margin-left: 85px;" type="submit" class="loginbtn" value="登录"/>
                </li>
                <li>
                    <%
                        String loginmsg = (String) request.getAttribute("loginmsg");
                        if (loginmsg!=null) {%>
                            <label style="color: #ff0000"><%=loginmsg%></label>
                    <%}%>
                </li>
            </ul>
        </form>
    </div>
</div>

<div class="loginbm">学习使用</div>

</body>
<script>
    if(document.getElementById("username").value.toLowerCase()==""){
        document.getElementById("headImg").src = "images/headpic.jpg";

    }
    function loadXMLDoc(str) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                myFunction(this,str);
            }
        };
        xhttp.open("GET", "/xml/HeadImg.xml", true);
        xhttp.send();
    }
    function myFunction(xml,str) {
        var i;
        var xmlDoc = xml.responseXML;
        var img="";
        var x = xmlDoc.getElementsByTagName("CD");
        for (i = 0; i <x.length; i++) {
            if (str == x[i].getElementsByTagName("userName")[0].childNodes[0].nodeValue) {
                img = x[i].getElementsByTagName("Headimg")[0].childNodes[0].nodeValue + "";
                document.getElementById("headImg").src = "images/" + img;
                break;
            }else{
                document.getElementById("headImg").src = "images/headpic.jpg";
            }
        }
    }
</script>
</html>
