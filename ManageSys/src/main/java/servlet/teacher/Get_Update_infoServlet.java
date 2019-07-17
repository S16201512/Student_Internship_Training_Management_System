package servlet.teacher;

import javaBean.Teacher;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取原本的个人信息
 */
@WebServlet("/get_update_infoServlet")
public class Get_Update_infoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");

        String tno = request.getSession().getAttribute("teacher_no").toString();
        Teacher teacher;
        teacher = teacherService.loadByTno(tno);
        if(teacher != null){
            //将信息传到修改界面
            request.setAttribute("tno",tno);
            request.setAttribute("name",teacher.getName());
            request.setAttribute("phone",teacher.getPhone());
            request.setAttribute("qq",teacher.getQQ());
            request.setAttribute("profession",teacher.getProfession());
            request.getRequestDispatcher("teacher/update_info.jsp").forward(request,response);
        }else{
            response.sendRedirect("error/500.jsp");
        }

    }
}
