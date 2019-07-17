package servlet.Admin.student_Management;

import javaBean.Student;
import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent_servlet")
public class AddStudent_Servlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String qq = request.getParameter("qq");
        String addStudentMessage = "";
        if("".equals(sno)){
            //如果学号为空
            addStudentMessage = "学号不能为空";
            System.out.println(addStudentMessage);
            request.setAttribute("addStudentSnoErrorMessage",addStudentMessage);
            request.getRequestDispatcher("admin/student/addStudentInfo.jsp").forward(request,response);
            return;
        }

        if("".equals(password)){
            //如果密码设置空
            addStudentMessage = "密码不能为空";
            System.out.println(addStudentMessage);
            request.setAttribute("addStudentPasswordMessage",addStudentMessage);
            request.getRequestDispatcher("admin/student/addStudentInfo.jsp").forward(request,response);
            return;
        }

        if("".equals(name)){
            //如果姓名为空
            addStudentMessage = "姓名不能为空";
            System.out.println(addStudentMessage);
            request.setAttribute("addStudentNameErrorMessage",addStudentMessage);
            request.getRequestDispatcher("admin/student/addStudentInfo.jsp").forward(request,response);
            return;
        }

        if("".equals(phone)){
            //如果电话为空
            addStudentMessage = "电话不能为空";
            System.out.println(addStudentMessage);
            request.setAttribute("addStudentPhoneErrorMessage",addStudentMessage);
            request.getRequestDispatcher("admin/student/addStudentInfo.jsp").forward(request,response);
            return;
        }

        if("".equals(qq)){

        }
        AdminServices adminServices = new AdminServices();
        Student student = new Student();
        student.setId(sno);
        student.setPsd(password);
        student.setName(name);
        student.setPhone(phone);
        student.setQQ(qq);
        boolean b = adminServices.addStudent(student);
        if(b){
            request.getRequestDispatcher("sucess/admin_student_sucess.jsp").forward(request,response);
            System.out.println("添加成功!!");
        }else{
            request.getRequestDispatcher("sucess/admin_student_fail.jsp").forward(request,response);
            System.out.println("添加失败!");
        }
    }

    @Override
    protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
