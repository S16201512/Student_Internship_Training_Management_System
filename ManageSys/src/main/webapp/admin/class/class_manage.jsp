<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>班级管理</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/other.css" rel="stylesheet" type="text/css"/>
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
<body style="background:url(../../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/teacher_mana_indexServlet"><img src="../../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="/student_manage"><img src="../../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="/class_management_indexServlet" class="selected"><img src="../../images/icon01.png" title="班级管理"/>
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
                <li ><cite></cite><a href="/class_management_indexServlet">班级管理</a><i></i></li>
                <li class="active"><cite></cite><a href="#">班级信息导入</a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main">
        <form id="classFileUpload" class="classFile" name="classFileUpload" action="/classFileUpload" method="post" enctype="multipart/form-data">
            <p>
                <input type="text" id="filetext" class="filetext" disabled>
                <input id="classInfoFile" class="classFileUpload" name="classInfoFile" type="file" multiple="multiple" accept=".xls,.xlsx" onchange="show()"/>
            </p>
            <p>
                <input type="button" class="fileButton" value="提交" onclick="filecheck()"/>
                <input type="reset" class="fileButton" value="重置"/>
            </p>
        </form>
    </div>
    <script type="text/javascript">
        function filecheck() {
            var file = document.getElementById("classInfoFile");
            if (file.value == "") {
                alert("请选择您需要上传的文件！");
            }else{
                document.classFileUpload.submit();
            }
        }
        function show() {
            var obj=document.getElementById("classInfoFile");
            var len=obj.files.length;
            var fileName="";
            for (var i=0;i<len;i++){
                var path=obj.files[i].name;
                var temp=path.substring(path.lastIndexOf("\\")+1);
                if(i==0){
                    fileName=temp;
                }else{
                    fileName=fileName+","+temp;
                }
            }
            document.getElementById("filetext").value=fileName;
        }
    </script>
</div>
</body>
</html>
