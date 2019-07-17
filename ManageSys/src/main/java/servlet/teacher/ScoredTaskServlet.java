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

@WebServlet("/teacher/ScoredTask")
public class ScoredTaskServlet extends HttpServlet {
    private String score;
    private String remake=" ";
    private String sno;
    private String taskno;
    TeacherService service;
    private Student_task studentTask;
    private String tno=" ";
    private List<Student_task> studentTaskList;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new TeacherService();
        if(request.getParameter("score")!=null){
            score=request.getParameter("score");

        }
        if(request.getParameter("remark")!=null)
            remake=request.getParameter("remark");
        if(request.getParameter("sno")!=null&&request.getParameter("task_no")!=null){
            sno=request.getParameter("sno");
            taskno=request.getParameter("task_no");
        }
        if(request.getSession().getAttribute("teacher_no")!=null){
            tno=(String)request.getSession().getAttribute("teacher_no");
        }
        System.out.println("tno:"+tno+"taskno:"+taskno);
        if(service.scoredStudentTask(sno,taskno,score,remake)){
            if(service.loadSubmitTaskList(tno,taskno)!=null) {
                studentTaskList = service.loadSubmitTaskList(tno, taskno);
                request.getSession().setAttribute("tasklist7", studentTaskList);
            }
            request.getSession().setAttribute("Button1","5");
            response.sendRedirect("/teacher/task.jsp");
        }

    }
}
