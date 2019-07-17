package servlet.Admin.student_Management;

import javaBean.Student;
import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student_info_servlet")
public class Student_Info_Servlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sno = request.getParameter("sno");
        AdminServices adminServices = new AdminServices();
        List<Student> studentList = new ArrayList<Student>();
        studentList = adminServices.loadInfoBySno(sno);
        if(studentList==null || studentList.size()<1){
            response.sendRedirect("admin/fail.jsp");
        }else{
            System.out.println("学生结果如下！");
            request.setAttribute("studentList",studentList);
            request.getRequestDispatcher("admin/student/student_info.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
