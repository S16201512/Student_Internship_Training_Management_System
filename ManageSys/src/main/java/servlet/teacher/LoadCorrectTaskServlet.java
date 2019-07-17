package servlet.teacher;

import javaBean.Student_task;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/loadCorrentTaskList")
public class LoadCorrectTaskServlet extends HttpServlet {
    private String tno;
    private String task_no;
    private TeacherService service;
    private List<Student_task> studentTaskList;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        service=new TeacherService();
        if(request.getSession().getAttribute("teacher_no")!=null){
            tno=(String)request.getSession().getAttribute("teacher_no");
        }
        if(request.getParameter("taskno")!=null)
        task_no=request.getParameter("taskno");
        if(service.loadSubmitTaskList(tno,task_no)!=null) {
            studentTaskList = service.loadSubmitTaskList(tno, task_no);
            request.getSession().setAttribute("tasklist7", studentTaskList);
        }
        request.getSession().setAttribute("Button1","5");
        response.sendRedirect("/teacher/task.jsp");

    }
}
