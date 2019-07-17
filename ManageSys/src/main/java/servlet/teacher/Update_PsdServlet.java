package servlet.teacher;


import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_PsdServlet")
public class Update_PsdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        TeacherService teacherService = new TeacherService();
        String tno = request.getSession().getAttribute("teacher_no").toString();

        String old_psd = request.getParameter("old_psd");
        String new_psd = request.getParameter("new_psd");
        String new_psd_confirm = request.getParameter("new_psd_confirm");
        String real_old_psd = teacherService.loadPsdByTno(tno);
        boolean b = false ;

        /*确认旧密码正确，同时确认两次输入的新密码一致*/
        if("".equals(new_psd.trim()) || "".equals(new_psd_confirm.trim()) ||"".equals(old_psd.trim())){
            request.setAttribute("null_psd_error","请注意：输入密码不能为null");
            request.getRequestDispatcher("teacher/update_psd.jsp").forward(request,response);

        }
        else if (!new_psd.trim().equals(new_psd_confirm.trim())){
            request.setAttribute("new_psd_error_msg","请注意：两次输入的密码不符");
            request.getRequestDispatcher("teacher/update_psd.jsp").forward(request,response);
        }
        else if(!old_psd.trim().equals(real_old_psd)){

            request.setAttribute("old_psd_error_msg","请注意：输入密码与旧密码不符");
            request.getRequestDispatcher("teacher/update_psd.jsp").forward(request,response);
        }
        else if(old_psd.trim().equals(new_psd.trim())){
            request.setAttribute("old_new_psd_charge","请注意：新密码不能与旧密码相同");
            request.getRequestDispatcher("teacher/update_psd.jsp").forward(request,response);
        }
        else{
            /*当条件都符合时，进行修改*/
            b = teacherService.updatePsdByTno(tno,new_psd);
        }
        /*根据根性结果进行相应跳转*/
        if ( b== true){
            request.setAttribute("msg","修改密码成功，3秒后回到初始页面");
            request.getRequestDispatcher("sucess/sucess.jsp").forward(request,response);
        }
    }
}
