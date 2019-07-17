package servlet.student;

import javaBean.Student_task;
import service.student.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/LoadStudentTask")
public class LoadStudentTaskServlet extends HttpServlet {
    private String sno;
    private String task_no;
    private String type;
    private StudentService service;
    private Student_task task;
    private Student_task task2;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new StudentService();
        if(request.getParameter("task_no")!=null){
            task_no=request.getParameter("task_no");
        }
        if(request.getParameter("type")!=null){
            type=request.getParameter("type");
        }
        if(request.getSession().getAttribute("student_no")!=null){
            sno=(String)request.getSession().getAttribute("student_no");
        }
        task2=service.loadStudentFinishedTask(sno,task_no);
        if(task_no!=null&&sno!=null){
            task=service.LoadStudentTask(sno,task_no);
            if(service.LoadTaskFileByTask_no(task_no).size()!=0) {
                task.setTask_file(service.LoadTaskFileByTask_no(task_no));
                task2.setTask_file(service.LoadTaskFileByTask_no(task_no));
                //System.out.println(service.LoadTaskFileByTask_no(task_no).get(0).getFilename());
            }

            task2.setSubmit_file(service.loadStudentSubmitTaskFile(sno,task_no));


            if(type.equals("dofinished")){
                request.getSession().setAttribute("studentTask",task);
                response.sendRedirect("/student/finish_massion.jsp");
            }
            if (type.equals("unfinished")){
                request.getSession().setAttribute("studentTask2",task2);
                response.sendRedirect("/student/update_massion.jsp");
            };
            if(type.equals("lookfinished")){
                request.getSession().setAttribute("studentTask2",task2);
                response.sendRedirect("/student/check_massion.jsp");
            }

        }
    }
}
