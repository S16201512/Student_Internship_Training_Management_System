package servlet.Admin.student_Management;

import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_studentInfo_servlet")
public class Delete_StudentInfo_Servlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        AdminServices adminServices = new AdminServices();
        boolean b = adminServices.deleteStudent(sno);
        if(b){
            request.getRequestDispatcher("sucess/admin_student_sucess.jsp").forward(request,response);
            System.out.println("修改成功!!");
        }else{
            request.getRequestDispatcher("sucess/admin_student_fail.jsp").forward(request,response);
            System.out.println("修改失败!");
        }
    }

    @Override
    protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
