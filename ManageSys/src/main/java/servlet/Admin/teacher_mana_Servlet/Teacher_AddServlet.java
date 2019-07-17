package servlet.Admin.teacher_mana_Servlet;

import javaBean.Admin;
import javaBean.Teacher;
import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher_addServlet")
public class Teacher_AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServices adminServices = new AdminServices();
        Teacher teacher = new Teacher();
        String tno = request.getParameter("tno");
        String psd = request.getParameter("psd");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String profession = request.getParameter("profession");
        String qq = request.getParameter("qq");

        boolean b = false;
        if("".equals(tno) ||"".equals(name) || "".equals(phone)||"".equals(profession)||"".equals(qq)){
            request.setAttribute("null_msg","添加内容不能为空");
            request.getRequestDispatcher("admin/teacher_management/teacher_add.jsp").forward(request,response);
        }else{
            //没有空则进行添加数据操作
            teacher.setId(tno);
            teacher.setPsd(psd);
            teacher.setName(name);
            teacher.setProfession(profession);
            teacher.setQQ(qq);
            teacher.setPhone(phone);
            b= adminServices.addTeacher(teacher);
        }
        //根据返回结果进行相应页面跳转
        if(b){
            request.setAttribute("msg","添加信息成功！3秒后返回界面");
            request.getRequestDispatcher("sucess/admin_sucess.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("error/500.jsp");
        }
    }
}
