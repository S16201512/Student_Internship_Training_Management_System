package servlet.Admin;

import javaBean.T_registration;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/summary_graphServlet")
public class Summary_graphServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        List<T_registration> registrationList;
        registrationList = teacherService.loadAllRegistration();
        request.setAttribute("registrationList",registrationList);
        request.getRequestDispatcher("/admin/summary_graph.jsp").forward(request,response);

    }
}
