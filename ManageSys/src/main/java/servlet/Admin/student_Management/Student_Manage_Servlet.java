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


@WebServlet("/student_manage")
public class Student_Manage_Servlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServices adminServices = new AdminServices();

        //定义 页面数、当前页面数、以及页面大小
        int current_page,page_num,page_size=15;

        //查询班级数目
        int count = adminServices.loadStudentNum();

        //初始化获取页面数
        if(count%page_size!=0) {
            page_num = count/page_size +1;
        }else {
            page_num = count/page_size;
        }

        //获取当前的是哪个页面
        if(request.getParameter("current_page")!=null && !("".equals(request.getParameter("current_page"))) && Integer.parseInt(request.getParameter("current_page"))>0&&Integer.parseInt(request.getParameter("current_page"))<=page_num) {
            current_page = Integer.parseInt(request.getParameter("current_page"));
        }else {
            current_page =1;
        }

        List<Student> studentList = new ArrayList<Student>();
        studentList = adminServices.loadAllStudentByPage(current_page,page_size);
        if(studentList==null || studentList.size()<1){
            request.setAttribute("msg","当前无学生信息，请进行学生信息导入");
            request.getRequestDispatcher("admin/student/manageStudent_index.jsp").forward(request,response);
        }else{
            request.setAttribute("current_page",current_page);
            request.setAttribute("page_num",page_num);
            request.setAttribute("studentList",studentList);
            request.getRequestDispatcher("admin/student/manageStudent_index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
