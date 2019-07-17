package servlet.teacher;

import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于处理个人信息更新
 */
@WebServlet("/update_infoServlet")
public class Update_infoServlet extends HttpServlet {
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
        if(tno==null || name==null||phone ==null||qq==null||profession==null){
            request.setAttribute("null_msg","修改内容不能为空");
            request.getRequestDispatcher("teacher/update_info.jsp").forward(request,response);
        }else{
            /*没有空数据则进行更新*/
            b = teacherService.updateInfo(tno,name,phone,qq,profession);
        }

        /*根据不同的情况进行跳转*/
        if(b){
            request.setAttribute("msg","修改信息成功");
            request.getRequestDispatcher("sucess/sucess.jsp").forward(request,response);
        }
        else{
            response.sendRedirect("error/500.jsp");
        }
    }
}
