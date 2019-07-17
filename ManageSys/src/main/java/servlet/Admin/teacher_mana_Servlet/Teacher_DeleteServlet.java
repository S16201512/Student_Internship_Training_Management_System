package servlet.Admin.teacher_mana_Servlet;

import javaBean.Admin;
import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher_deleteServlet")
public class Teacher_DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServices adminServices = new AdminServices();
        String tno = request.getParameter("tno");
        boolean b = false;
        b = adminServices.deleteByTno(tno);
        if (b!=false){
            request.setAttribute("msg","删除教师信息成功！3秒后返回页面");
            request.getRequestDispatcher("sucess/admin_sucess.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("error/500.jsp").forward(request,response);
        }
    }
}
