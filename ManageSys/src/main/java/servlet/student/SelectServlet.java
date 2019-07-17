package servlet.student;



import service.student.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/*
*学生信息查询操作
* @Author 雷发根
 */
@WebServlet("/student/selectMassage")
public class SelectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        String sno = request.getSession().getAttribute("student_no").toString();
        StudentService studentService = new StudentService();
        try {
            request.setAttribute("list",studentService.massageSelect(sno));
            request.getRequestDispatcher("st_mass_sel.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        this.doGet(request,response);
    }
}
