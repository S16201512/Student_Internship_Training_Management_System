package servlet.Admin;



import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/AdminUpdateInfo_Servlet")
public class AdminUpdateInfo_Servlet extends HttpServlet {

    public AdminUpdateInfo_Servlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ano = (String)request.getSession().getAttribute("admin_no");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String qq = request.getParameter("qq");
        AdminServices adminServices = new AdminServices();
        boolean b = adminServices.updateAdminInfo(ano,name,phone,qq);
        if(b){
            request.getRequestDispatcher("success.jsp").forward(request,response);
            System.out.println("修改成功");
        }else{
            request.getRequestDispatcher("fail.jsp").forward(request,response);
            System.out.println("修改失败");
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
