/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.8.v20171121
 * Generated at: 2019-01-16 08:55:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("file:/D:/maven/repository/taglibs/standard/1.1.2/standard-1.1.2.jar", Long.valueOf(1545911286725L));
    _jspx_dependants.put("jar:file:/D:/maven/repository/taglibs/standard/1.1.2/standard-1.1.2.jar!/META-INF/c.tld", Long.valueOf(1098682290000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n");
      out.write("    <title>欢迎使用专业实习实训管理系统</title>\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <script language=\"JavaScript\" src=\"JS/jquery.js\"></script>\n");
      out.write("    <script src=\"JS/cloud.js\" type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<script language=\"javascript\">\n");
      out.write("    $(function () {\n");
      out.write("        $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 471) / 2});\n");
      out.write("        $(window).resize(function () {\n");
      out.write("            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 471) / 2});\n");
      out.write("        })\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<body style=\"background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;\">\n");
      out.write("\n");
      out.write("<div id=\"mainBody\">\n");
      out.write("    <div id=\"cloud1\" class=\"cloud\"></div>\n");
      out.write("    <div id=\"cloud2\" class=\"cloud\"></div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"logintop\">\n");
      out.write("    <span>欢迎使用专业实习实训管理系统</span>\n");
      out.write("    <ul>\n");
      out.write("        <li><a href=\"#\">帮助</a></li>\n");
      out.write("        <li><a href=\"#\">关于</a></li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"loginbody\">\n");
      out.write("    <span class=\"systemlogo\"></span>\n");
      out.write("    <div class=\"loginbox\" style=\"border:1px solid black;height: 400px;\">\n");
      out.write("        <form action=\"./login\" method=\"post\"  >\n");
      out.write("            <div >\n");
      out.write("                <img style=\"width:80px;height:80px;margin: 20px 183px;border-radius: 100%;\"id=\"headImg\" src=\"images/headpic.jpg\" />\n");
      out.write("            </div>\n");
      out.write("            <ul >\n");
      out.write("                <li><input name=\"id\" id=\"username\"onkeyup=\"loadXMLDoc(this.value)\" type=\"text\" class=\"loginuser\" placeholder=\"学号/工号\"/></li>\n");
      out.write("                <li><input name=\"password\" type=\"password\" class=\"loginpwd\" placeholder=\"密码\"/></li>\n");
      out.write("                <li>\n");
      out.write("                    <select name=\"identity\" class=\"loginselect\" style=\"margin-left: 65px;\">\n");
      out.write("                        <option value=\"admin\">管理员</option>\n");
      out.write("                        <option value=\"teacher\">教师</option>\n");
      out.write("                        <option value=\"student\">学生</option>\n");
      out.write("                    </select>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <input style=\"margin-left: 85px;\" type=\"submit\" class=\"loginbtn\" value=\"登录\"/>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    ");

                        String loginmsg = (String) request.getAttribute("loginmsg");
                        if (loginmsg!=null) {
      out.write("\n");
      out.write("                            <label style=\"color: #ff0000\">");
      out.print(loginmsg);
      out.write("</label>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"loginbm\">学习使用</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("<script>\n");
      out.write("    if(document.getElementById(\"username\").value.toLowerCase()==\"\"){\n");
      out.write("        document.getElementById(\"headImg\").src = \"images/headpic.jpg\";\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    function loadXMLDoc(str) {\n");
      out.write("        var xhttp = new XMLHttpRequest();\n");
      out.write("        xhttp.onreadystatechange = function() {\n");
      out.write("            if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                myFunction(this,str);\n");
      out.write("            }\n");
      out.write("        };\n");
      out.write("        xhttp.open(\"GET\", \"/xml/HeadImg.xml\", true);\n");
      out.write("        xhttp.send();\n");
      out.write("    }\n");
      out.write("    function myFunction(xml,str) {\n");
      out.write("        var i;\n");
      out.write("        var xmlDoc = xml.responseXML;\n");
      out.write("        var img=\"\";\n");
      out.write("        var x = xmlDoc.getElementsByTagName(\"CD\");\n");
      out.write("        for (i = 0; i <x.length; i++) {\n");
      out.write("            if (str == x[i].getElementsByTagName(\"userName\")[0].childNodes[0].nodeValue) {\n");
      out.write("                img = x[i].getElementsByTagName(\"Headimg\")[0].childNodes[0].nodeValue + \"\";\n");
      out.write("                document.getElementById(\"headImg\").src = \"images/\" + img;\n");
      out.write("                break;\n");
      out.write("            }else{\n");
      out.write("                document.getElementById(\"headImg\").src = \"images/headpic.jpg\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("</script>\n");
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
