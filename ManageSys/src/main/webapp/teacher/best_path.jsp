<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎！${teacher_no}老师</title>
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
<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/teacher/teacher_index.jsp"><img src="../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/teacher_InfoServlet" class="selected"><img src="../images/icon02.png" title="个人信息"/>
            <h2>个人信息</h2></a></li>
        <li><a href="/teacher/handle_Button?id=2"><img src="../images/icon03.png"/>
            <h2>任务模块</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="/logout">退出</a></li>
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
                <li ><cite></cite><a  href="/teacher_InfoServlet">个人信息</a><i></i></li>
                <li><cite></cite><a href="/teacher/update_psd.jsp">修改密码</a><i></i></li>
                <li><cite></cite><a href="/get_update_infoServlet">修改个人信息</a><i></i></li>
                <li class="active"><cite></cite><a href="/teacher/displayLookBackPath">实习点最短回访路径</a><i></i></li>

            </ul>
        </dd>
    </dl>

    <%--内容模块--%>
    <div class="main">

        <!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
        <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->

        <div id="mainMap" style="height:700px;width: 1200px;padding:10px;background:#1B1B1B;margin: 0 auto;">
        </div>
        <!--Step:2 引入echarts.js-->

        <script type="text/javascript" src="../JS/jquery-1.8.0.js"></script>
        <script src="../JS/echarts.js" charset="UTF-8"></script>
        <script type="text/javascript">
            $('#document').ready(function(){
                getEcharts();
            });
        </script>

        <script type="text/javascript">
            function getEcharts(){
                // Step:3 conifg ECharts's path, link to echarts.js from current page.
                // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
                require.config({
                    paths: {
                        echarts: '../JS'
                    }
                });

                // Step:4 require echarts and use it in the callback.
                // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径
                require(
                    [
                        'echarts',
                        'echarts/chart/map'
                    ],
                    function (ec) {
                        // --- 地图 ---
                        var myChart2 = ec.init(document.getElementById('mainMap'));
                        myChart2.setOption({
                            dataRange: {
                                min : 0,
                                max : 100,
                                calculable : true,
                                color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
                                textStyle:{
                                    color:'#fff'
                                }
                            },
                            series : [
                                {
                                    name: '全国',
                                    type: 'map',
                                    roam: true,
                                    hoverable: false,
                                    mapType: 'china',
                                    itemStyle:{
                                        normal:{
                                            borderColor:'rgba(100,149,237,1)',
                                            borderWidth:0.5,
                                            areaStyle:{
                                                color: '#1b1b1b'
                                            }
                                        }
                                    },
                                    data:[],
                                    markLine : {
                                        smooth:true,
                                        symbol: ['none', 'circle'],
                                        symbolSize : 1,
                                        itemStyle : {
                                            normal: {
                                                color:'#fff',
                                                borderWidth:1,
                                                borderColor:'rgba(30,144,255,0.5)'
                                            }
                                        },
                                        data : [
                                        ],
                                    },
                                    geoCoord: {
                                        '上海': [121.4648,31.2891],
                                        '东莞': [113.8953,22.901],
                                        '东营': [118.7073,37.5513],
                                        '中山': [113.4229,22.478],
                                        '临汾': [111.4783,36.1615],
                                        '临沂': [118.3118,35.2936],
                                        '丹东': [124.541,40.4242],
                                        '丽水': [119.5642,28.1854],
                                        '乌鲁木齐': [87.9236,43.5883],
                                        '佛山': [112.8955,23.1097],
                                        '保定': [115.0488,39.0948],
                                        '兰州': [103.5901,36.3043],
                                        '包头': [110.3467,41.4899],
                                        '北京': [116.4551,40.2539],
                                        '北海': [109.314,21.6211],
                                        '南京': [118.8062,31.9208],
                                        '南宁': [108.479,23.1152],
                                        '南昌': [116.0046,28.6633],
                                        '南通': [121.1023,32.1625],
                                        '厦门': [118.1689,24.6478],
                                        '台州': [121.1353,28.6688],
                                        '合肥': [117.29,32.0581],
                                        '呼和浩特': [111.4124,40.4901],
                                        '咸阳': [108.4131,34.8706],
                                        '哈尔滨': [127.9688,45.368],
                                        '唐山': [118.4766,39.6826],
                                        '嘉兴': [120.9155,30.6354],
                                        '大同': [113.7854,39.8035],
                                        '大连': [122.2229,39.4409],
                                        '天津': [117.4219,39.4189],
                                        '太原': [112.3352,37.9413],
                                        '威海': [121.9482,37.1393],
                                        '宁波': [121.5967,29.6466],
                                        '宝鸡': [107.1826,34.3433],
                                        '宿迁': [118.5535,33.7775],
                                        '常州': [119.4543,31.5582],
                                        '广州': [113.5107,23.2196],
                                        '廊坊': [116.521,39.0509],
                                        '延安': [109.1052,36.4252],
                                        '张家口': [115.1477,40.8527],
                                        '徐州': [117.5208,34.3268],
                                        '德州': [116.6858,37.2107],
                                        '惠州': [114.6204,23.1647],
                                        '成都': [103.9526,30.7617],
                                        '扬州': [119.4653,32.8162],
                                        '承德': [117.5757,41.4075],
                                        '拉萨': [91.1865,30.1465],
                                        '无锡': [120.3442,31.5527],
                                        '日照': [119.2786,35.5023],
                                        '昆明': [102.9199,25.4663],
                                        '杭州': [119.5313,29.8773],
                                        '枣庄': [117.323,34.8926],
                                        '柳州': [109.3799,24.9774],
                                        '株洲': [113.5327,27.0319],
                                        '武汉': [114.3896,30.6628],
                                        '汕头': [117.1692,23.3405],
                                        '江门': [112.6318,22.1484],
                                        '沈阳': [123.1238,42.1216],
                                        '沧州': [116.8286,38.2104],
                                        '河源': [114.917,23.9722],
                                        '泉州': [118.3228,25.1147],
                                        '泰安': [117.0264,36.0516],
                                        '泰州': [120.0586,32.5525],
                                        '济南': [117.1582,36.8701],
                                        '济宁': [116.8286,35.3375],
                                        '海口': [110.3893,19.8516],
                                        '淄博': [118.0371,36.6064],
                                        '淮安': [118.927,33.4039],
                                        '深圳': [114.5435,22.5439],
                                        '清远': [112.9175,24.3292],
                                        '温州': [120.498,27.8119],
                                        '渭南': [109.7864,35.0299],
                                        '湖州': [119.8608,30.7782],
                                        '湘潭': [112.5439,27.7075],
                                        '滨州': [117.8174,37.4963],
                                        '潍坊': [119.0918,36.524],
                                        '烟台': [120.7397,37.5128],
                                        '玉溪': [101.9312,23.8898],
                                        '珠海': [113.7305,22.1155],
                                        '盐城': [120.2234,33.5577],
                                        '盘锦': [121.9482,41.0449],
                                        '石家庄': [114.4995,38.1006],
                                        '福州': [119.4543,25.9222],
                                        '秦皇岛': [119.2126,40.0232],
                                        '绍兴': [120.564,29.7565],
                                        '聊城': [115.9167,36.4032],
                                        '肇庆': [112.1265,23.5822],
                                        '舟山': [122.2559,30.2234],
                                        '苏州': [120.6519,31.3989],
                                        '莱芜': [117.6526,36.2714],
                                        '菏泽': [115.6201,35.2057],
                                        '营口': [122.4316,40.4297],
                                        '葫芦岛': [120.1575,40.578],
                                        '衡水': [115.8838,37.7161],
                                        '衢州': [118.6853,28.8666],
                                        '西宁': [101.4038,36.8207],
                                        '西安': [109.1162,34.2004],
                                        '贵阳': [106.6992,26.7682],
                                        '连云港': [119.1248,34.552],
                                        '邢台': [114.8071,37.2821],
                                        '邯郸': [114.4775,36.535],
                                        '郑州': [113.4668,34.6234],
                                        '鄂尔多斯': [108.9734,39.2487],
                                        '重庆': [107.7539,30.1904],
                                        '金华': [120.0037,29.1028],
                                        '铜川': [109.0393,35.1947],
                                        '银川': [106.3586,38.1775],
                                        '镇江': [119.4763,31.9702],
                                        '长春': [125.8154,44.2584],
                                        '长沙': [113.0823,28.2568],
                                        '长治': [112.8625,36.4746],
                                        '阳泉': [113.4778,38.0951],
                                        '青岛': [120.4651,36.3373],
                                        '韶关': [113.7964,24.7028]
                                    },
                                    markPoint : {
                                        symbol:'emptyCircle',
                                        symbolSize : function (v){
                                            return 10 + v/10
                                        },
                                        effect : {
                                            show: true,
                                            shadowBlur : 0
                                        },
                                        itemStyle:{
                                            normal:{
                                                label:{show:false}
                                            },
                                            emphasis: {
                                                label:{position:'top'}
                                            }
                                        },
                                        data : [

                                            <c:if test="${not empty city_path}">
                                                <c:forEach begin="1" step="1" end="${length}" varStatus="status">
                                                    {name:'${city_path[status.current-1]}',value:${status.current}},
                                                </c:forEach>
                                            </c:if>
                                            <%--<c:if test="${not empty registrationList}">
                                            <c:forEach items="${registrationList}" var="registration">
                                            {name:'${registration.getCity()}',value:${registration.getCount()}},
                                            </c:forEach>
                                            </c:if>--%>

                                            /*{name:'北京',value:95},
                                            {name:'广州',value:90},
                                            {name:'大连',value:80},
                                            {name:'南宁',value:70},
                                            {name:'西安',value:60},
                                            {name:'拉萨',value:50},
                                            {name:'长春',value:40},
                                            {name:'包头',value:30},
                                            {name:'重庆',value:20},
                                            {name:'常州',value:10}*/
                                        ]
                                    }
                                },
                                {
                                    name: '北京 Top10',
                                    type: 'map',
                                    mapType: 'china',
                                    data:[],
                                    markLine : {
                                        smooth:true,
                                        effect : {
                                            show: true,
                                            scaleSize: 1,
                                            period: 30,
                                            color: '#fff',
                                            shadowBlur: 10
                                        },
                                        itemStyle : {
                                            normal: {
                                                label:{show:false},
                                                borderWidth:1,
                                                lineStyle: {
                                                    type: 'solid',
                                                    shadowBlur: 10
                                                }
                                            }
                                        },
                                        data : [
                                            <c:if test="${not empty city_path}">
                                                <c:forEach begin="1" step="1" end="${length-1}" varStatus="status">
                                                        [{name:'${city_path[status.current-1]}'}, {name:'${city_path[status.current]}',value:30}],
                                                </c:forEach>
                                            </c:if>

                                            /*[{name:'北京'}, {name:'南昌',value:95}],
                                            [{name:'广州'}, {name:'南昌',value:90}],
                                            [{name:'大连'}, {name:'南昌',value:80}],
                                            [{name:'南宁'}, {name:'南昌',value:70}],
                                            [{name:'西安'}, {name:'南昌',value:60}],
                                            [{name:'拉萨'}, {name:'南昌',value:50}],
                                            [{name:'长春'}, {name:'南昌',value:40}],
                                            [{name:'包头'}, {name:'南昌',value:30}],
                                            [{name:'重庆'}, {name:'南昌',value:20}],
                                            [{name:'常州'}, {name:'南昌',value:10}]*/
                                        ]
                                    },
                                    markPoint : {
                                        symbol:'emptyCircle',
                                        symbolSize : function (v){
                                            return 0.1
                                        },
                                        effect : {
                                            show: false,
                                            shadowBlur : 0
                                        },
                                        itemStyle:{
                                            normal:{
                                                label:{show:true,
                                                    position:'top',
                                                    textStyle: {
                                                        fontSize: 14
                                                    }
                                                }
                                            },
                                            emphasis: {
                                                label:{show:false}
                                            }
                                        },
                                        data : [
                                            <%--<c:if test="${not empty registrationList}">
                                            <c:forEach items="${registrationList}" var="registration">
                                            {name:'${registration.getCity()}',value:${registration.getCount()}},
                                            </c:forEach>
                                            </c:if>--%>
                                            /*{name:'北京',value:95},
                                            {name:'广州',value:90},
                                            {name:'大连',value:80},
                                            {name:'南宁',value:70},
                                            {name:'西安',value:60},
                                            {name:'拉萨',value:50},
                                            {name:'长春',value:40},
                                            {name:'包头',value:30},
                                            {name:'重庆',value:20},
                                            {name:'常州',value:10}*/
                                        ]
                                    }
                                }
                            ]
                        });
                    });
            }
        </script>
    </div>

</div>
</body>
</html>

