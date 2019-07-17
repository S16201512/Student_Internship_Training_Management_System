package servlet.teacher;

import javaBean.Student_task;
import javaBean.T_file;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/loadStudentFinishedTask")
public class Load_studentFinishedTaskServlet extends HttpServlet {
    private String sno="";
    private String task_no="";
    private TeacherService service;
    private Student_task studentTask;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new TeacherService();
        if(request.getParameter("sno")!=null&&request.getParameter("task_no")!=null){
            sno=request.getParameter("sno");
            task_no=request.getParameter("task_no");
        }
        studentTask=service.loadStudentFinishedTask(sno,task_no);
        studentTask.setSubmit_file(service.loadStudentSubmitTaskFile(sno,task_no));
        for(T_file file:service.loadStudentSubmitTaskFile(sno,task_no))
            System.out.println("hahahahahahhahahahhahah"+file.getFilename());
        request.getSession().setAttribute("studentTask",studentTask);
        request.getSession().setAttribute("Button1","6");
        response.sendRedirect("/teacher/task.jsp");
    }
}
