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

@WebServlet("/teacher/publishTask")
public class PublishTaskServlet  extends HttpServlet {
    private String taskId="";
    private TeacherService service;
    private String tno;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new TeacherService();
        if(request.getParameter("id")!=null){
            taskId=request.getParameter("id");
        }
        if(request.getSession().getAttribute("teacher_no")!=null){
            tno=(String)request.getSession().getAttribute("teacher_no");
        }
        if(service.updateTaskSubmitStaus(taskId,true)){
            List<Task> tasklist=service.loadAlltaskByno(tno,false);
            List<Task> tasklist2=service.loadAlltaskByno(tno,true);
            request.getSession().setAttribute("tasklist",tasklist);
            request.getSession().setAttribute("tasklist2",tasklist2);
            request.getSession().setAttribute("Button1","2");
            response.sendRedirect("/teacher/task.jsp");
        }


    }
}
