package servlet.student;

import service.student.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/RegistrationInfo")

public class RegistrationInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        String rno = (String) request.getSession().getAttribute("student_no");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String company = request.getParameter("company");
        String linkman = request.getParameter("linkman");
        String linkmanphone = request.getParameter("linkmanphone");
        /*System.out.print("******"+ rno);
        System.out.print("******"+ linkman);*/
        StudentService studentService = new StudentService();
        request.setAttribute("list",studentService.registrationInfo(rno,province,city,company,linkman,linkmanphone));
        request.getRequestDispatcher("RegistrationInfo.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        this.doGet(request,response);
    }
}
