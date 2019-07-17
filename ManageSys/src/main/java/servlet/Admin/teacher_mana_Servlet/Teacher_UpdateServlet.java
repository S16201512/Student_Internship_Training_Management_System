package servlet.Admin.teacher_mana_Servlet;

import javaBean.Teacher;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher_updateServlet")
public class Teacher_UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");

        String tno = request.getParameter("tno");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String qq = request.getParameter("qq");
        String profession = request.getParameter("profession");

        boolean b = false;
        /*假如有输入框为空*/
        if("".equals(tno) || "".equals(name)||"".equals(phone)||"".equals(profession)||"".equals(qq)){
            request.setAttribute("null_msg","修改内容不能为空");
            request.getRequestDispatcher("/teacher_detailServlet").forward(request,response);
        }else{
            /*没有空数据则进行更新*/
            b = teacherService.updateInfo(tno,name,phone,qq,profession);
        }

        /*根据不同的情况进行跳转*/
        if(b){
            request.setAttribute("msg","修改信息成功!3秒后返回界面，请稍等....");
            request.getRequestDispatcher("sucess/admin_sucess.jsp").forward(request,response);
        }
        else{
            response.sendRedirect("error/500.jsp");
        }
    }
}
