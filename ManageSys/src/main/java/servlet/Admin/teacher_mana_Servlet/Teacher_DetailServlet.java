package servlet.Admin.teacher_mana_Servlet;

import javaBean.Teacher;
import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher_detailServlet")
public class Teacher_DetailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServices adminServices = new AdminServices();
        String tno = request.getParameter("tno");
        Teacher teacher = adminServices.loadByTno(tno);
        /*根据情况进行页面跳转*/
        if(teacher != null){
            if(request.getAttribute("null_msg")!=null){
                String null_msg = request.getAttribute("null_msg").toString();
                request.setAttribute("null_msg",null_msg);
            }
            request.setAttribute("teacher",teacher);
            request.getRequestDispatcher("/admin/teacher_management/teacher_detail.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("").forward(request,response);
        }
    }
}
