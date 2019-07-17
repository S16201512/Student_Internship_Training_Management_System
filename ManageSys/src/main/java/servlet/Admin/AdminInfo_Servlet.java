package servlet.Admin;

import javaBean.Admin;
import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/AdminInfo_Servlet")
public class AdminInfo_Servlet extends HttpServlet {
    //用于显示用户个人信息的Servlet

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ano = (String) request.getSession().getAttribute("admin_no");//获取该用户的账号
        AdminServices adminServices = new AdminServices();
        List<Admin> adminList = new ArrayList<Admin>();
        adminList = adminServices.loadInfoByAccount(ano);
        Admin admin = adminList.get(0);
        if (adminList==null && adminList.size()<1){
            response.sendRedirect("/admin/fail.jsp");
        }else{
            request.getSession().setAttribute("admin_self",admin);
            response.sendRedirect("/admin/admin_personalInfo.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        doGet(request,response);
    }


}
