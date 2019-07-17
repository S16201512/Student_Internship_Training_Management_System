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
    /*.main .font_size{font-size: 25px;}
    .main input  {background: #ddfff8;  !*设置输入框背景色*!font-size: 25px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;line-height:50px;height:50px;width:250px;text-align: center}
    .main button  {background: #ddfff8;  !*设置输入框背景色*!font-size: 20px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;margin-top: 10px;width: 50px;}
*/ .main input  {font-size: 10px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;line-height:50px;height:30px;width:150px;text-align: center}
    .main button  {background: #ddfff8;  /*设置输入框背景色*/font-size: 20px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;margin-top: 10px;width: 50px;}
    .main .ul .li{margin-top: 20px}
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
                <li><cite></cite><a href="/student/selectMassage?sno=${student_no}">查找信息</a><i></i></li>
                <li class="active"><cite></cite><a href="st_psd_up.jsp">修改密码</a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main">
        <div style="margin-left:auto;margin-right:auto;margin-top:50px;background-color: #D2E9FF;width: 500px;height: 400px">
            <div style="background-color: #C0E1FF;width: 500px;height: 80px;margin-top: 50px">
                <h1 style="font-size: 24px;text-align: center;">密码修改</h1>
            </div>
            <form action="/student/studentUpdate" method="post">
                <div class="font_size">
                    <ul style="margin-top: 20px;">
                        <li style=" margin-left: 25%;font-size: 15px;letter-spacing:23px">账号：<input style="margin-left: -10px" type="text" name="sno" value="${student_no}" readonly="readonly"><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px;letter-spacing:10px">原密码：<input type="text" name="Apsd" value="" placeholder="请输入原密码"><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px;letter-spacing:10px">新密码：<input type="text" name="Npsd" value="" placeholder="请输入新密码"><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px;letter-spacing:5px">  确认密码：<input type="text" name="SNpsd" value="" placeholder="请确认新密码"><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px"><button type="submit">确认</button> <button type="reset" style="margin-left: 140px">清空</button></li>
                    </ul>





                </div>
            </form>
        </div>
    </div>


</div>
</body>
</html>
