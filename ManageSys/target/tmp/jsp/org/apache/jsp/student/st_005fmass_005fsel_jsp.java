/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.8.v20171121
 * Generated at: 2019-01-16 09:00:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javaBean.Student;
import java.util.List;

public final class st_005fmass_005fsel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("javaBean.Student");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>main</title>\n");
      out.write("    <link href=\"../css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <script language=\"JavaScript\" src=\"../JS/jquery.js\"></script>\n");
      out.write("</head>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function () {\n");
      out.write("        //顶部导航切换\n");
      out.write("        $(\".nav li a\").click(function () {\n");
      out.write("            $(\".nav li a.selected\").removeClass(\"selected\")\n");
      out.write("            $(this).addClass(\"selected\");\n");
      out.write("        })\n");
      out.write("    })\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function () {\n");
      out.write("        //导航切换\n");
      out.write("        $(\".menuson li\").click(function () {\n");
      out.write("            $(\".menuson li.active\").removeClass(\"active\")\n");
      out.write("            $(this).addClass(\"active\");\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $('.title').click(function () {\n");
      out.write("            var $ul = $(this).next('ul');\n");
      out.write("            $('dd').find('ul').slideUp();\n");
      out.write("            if ($ul.is(':visible')) {\n");
      out.write("                $(this).next('ul').slideUp();\n");
      out.write("            } else {\n");
      out.write("                $(this).next('ul').slideDown();\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    })\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    .main ul {margin-top: 20px;}\n");
      out.write("    .main ul li{font-size: 15px; margin-top: 10px; margin-left: 400px;}\n");
      out.write("    .main ul li a {font-size: 15px; margin-left: 10px;text-decoration: none;}\n");
      out.write("    .main ul hr{  height:1px;border:none;border-top:1px solid #555555; margin-top: 10px;width: 80%;margin-left: 230px;position: absolute;}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body style=\"background:url(../images/topbg.gif) repeat-x;\">\n");
      out.write("<div class=\"top\">\n");
      out.write("    <div class=\"topleft\">\n");
      out.write("        <a href=\"main.jsp\"><img src=\"../images/home.png\" width=\"64\" height=\"64\" title=\"系统首页\"/></a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <ul class=\"nav\">\n");
      out.write("        <li><a href=\"/student/main.jsp\" class=\"selected\"><img src=\"../images/icon02.png\" title=\"1\"/>\n");
      out.write("            <h2>个人信息</h2></a></li>\n");
      out.write("        <li><a href=\"/student/loadTask\"><img src=\"../images/icon03.png\" title=\"2\"/>\n");
      out.write("            <h2>任务模块</h2></a></li>\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <div class=\"topright\">\n");
      out.write("        <ul>\n");
      out.write("            <li><span><img src=\"../images/help.png\" title=\"帮助\" class=\"helpimg\"/></span><a href=\"#\">帮助</a></li>\n");
      out.write("            <li><a href=\"#\">关于</a></li>\n");
      out.write("            <li><a href=\"../index.jsp\" target=\"_parent\">退出</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"user\">\n");
      out.write("            <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"lefttop\"><span></span>列表</div>\n");
      out.write("\n");
      out.write("    <dl class=\"leftmenu\">\n");
      out.write("        <dd>\n");
      out.write("            <div class=\"title\">\n");
      out.write("                <span><img src=\"../images/leftico01.png\"/></span>管理信息\n");
      out.write("            </div>\n");
      out.write("            <ul class=\"menuson\">\n");
      out.write("                <li class=\"active\"><cite></cite><a href=\"/student/selectMassage\">查找信息</a><i></i></li>\n");
      out.write("                <li><cite></cite><a href=\"st_psd_up.jsp\">修改密码</a><i></i></li>\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </dd>\n");
      out.write("    </dl>\n");
      out.write("\n");
      out.write("    <div class=\"main\">\n");
      out.write("        <form action=\"\" method=\"get\">\n");
      out.write("            ");

                List<Student> list1 = (List<Student>)request.getAttribute("list");
                for (Student s :list1){
            
      out.write("\n");
      out.write("            <ul>\n");
      out.write("                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账号:&nbsp;&nbsp;&nbsp;&nbsp;");
out.print(s.getId());
      out.write("</li>\n");
      out.write("                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名:&nbsp;&nbsp;&nbsp;&nbsp;");
out.print(s.getName());
      out.write("</li>\n");
      out.write("                <li>联系电话:&nbsp;&nbsp;&nbsp;&nbsp;");
out.print(s.getPhone());
      out.write("</li>\n");
      out.write("                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;qq:&nbsp;&nbsp;&nbsp;&nbsp;");
out.print(s.getQQ());
      out.write("</li>\n");
      out.write("            </ul>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
