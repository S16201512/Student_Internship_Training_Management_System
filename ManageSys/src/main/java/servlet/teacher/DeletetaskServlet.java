package servlet.teacher;

import javaBean.Task;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/deleteTaskServlet")
public class DeletetaskServlet extends HttpServlet {
    private String task_id;
    private TeacherService service;
    private String tno;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new TeacherService();
        tno=(String)request.getSession().getAttribute("teacher_no");
        if(request.getParameter("id")!=null){
            task_id=request.getParameter("id");
        }
        if(service.deleteTaskByno(task_id)){
            List<Task> tasklist=service.loadAlltaskByno(tno,false);
            List<Task> tasklist2=service.loadAlltaskByno(tno,true);
            request.getSession().setAttribute("tasklist",tasklist);
            request.getSession().setAttribute("tasklist2",tasklist2);
            request.getSession().setAttribute("Button1","2");
            response.sendRedirect("/teacher/task.jsp");
        }
    }
}
