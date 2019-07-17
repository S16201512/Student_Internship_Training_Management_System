package servlet.Admin.student_Management;

import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student_updateInfo_servlet")
public class Student_UpdateInfo_Servlet extends HttpServlet {

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
        String Errormessage = "";

        if("".equals(password)){
            //如果密码设置空
            Errormessage = "密码不能为空";
            request.setAttribute("updateStudentPasswordMessage",Errormessage);
            request.getRequestDispatcher("/student_info_servlet").forward(request,response);
            return;
        }

        if("".equals(name)){
            //如果姓名为空
            Errormessage = "姓名不能为空";
            request.setAttribute("updateStudentNameErrorMessage",Errormessage);
            request.getRequestDispatcher("/student_info_servlet").forward(request,response);
            return;
        }

        if("".equals(phone)){
            //如果电话为空
            Errormessage = "电话不能为空";
            request.setAttribute("updateStudentPhoneErrorMessage",Errormessage);
            request.getRequestDispatcher("/student_info_servlet").forward(request,response);
            return;
        }

        if("".equals(qq)){

        }
        AdminServices adminServices = new AdminServices();
        boolean b =false;
        b = adminServices.updateStudentInfo(sno,name,phone,qq);
        if(b){
            request.getRequestDispatcher("sucess/admin_student_sucess.jsp").forward(request,response);
            System.out.println("更新成功!");
        }else{
            request.getRequestDispatcher("sucess/admin_student_fail.jsp").forward(request,response);
            System.out.println("更新失败!");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
