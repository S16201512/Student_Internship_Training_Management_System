package servlet.teacher;

import javaBean.Teacher;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher_InfoServlet")
public class Teacher_InfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        TeacherService teacherService = new TeacherService();
        String tno = request.getSession().getAttribute("teacher_no").toString();
        Teacher teacher = null;
        teacher  = teacherService.loadByTno(tno);
        if(teacher != null){
            request.setAttribute("tno",tno);
            request.setAttribute("name",teacher.getName());
            request.setAttribute("phone",teacher.getPhone());
            request.setAttribute("qq",teacher.getQQ());
            request.setAttribute("profession",teacher.getProfession());
            request.getRequestDispatcher("teacher/display_info.jsp").forward(request,response);
        }else{
            response.sendRedirect("error/500.jsp");
        }
    }
}
