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

@WebServlet("/admin/Admin_GetUpdateInfo")
public class Admin_GetUpdateInfo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ano = (String) request.getSession().getAttribute("admin_no");//获取该用户的账号
        System.out.println(ano);
        AdminServices adminServices = new AdminServices();
        List<Admin> adminList = new ArrayList<Admin>();
        adminList = adminServices.loadInfoByAccount(ano);
        Admin admin = adminList.get(0);
        if (adminList==null && adminList.size()<1){
            response.sendRedirect("/Admin/fail.jsp");
        }else{
            request.setAttribute("admin",admin);
            request.getRequestDispatcher("/admin/admin_updateInfo.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        doGet(request,response);
    }
}
