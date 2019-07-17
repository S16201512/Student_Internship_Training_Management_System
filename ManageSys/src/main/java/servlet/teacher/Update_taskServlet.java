package servlet.teacher;

import javaBean.T_file;
import javaBean.Task;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/updateTask")

public class Update_taskServlet extends HttpServlet {
    private String taskId="";
    private TeacherService service;
    private String tno;
    private Task task;
    private List<T_file> fileList;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new TeacherService();

        if(request.getParameter("id")!=null){
            taskId=request.getParameter("id");
            task=service.LoadByTask_no(taskId);
            fileList=service.loadFileByTask_no(taskId);
        }
        if(request.getSession().getAttribute("teacher_no")!=null){
            tno=(String)request.getSession().getAttribute("teacher_no");
        }
        if(task!=null){

            request.getSession().setAttribute("Button1","4");
            request.getSession().setAttribute("task",task);
            request.getSession().setAttribute("fileList",fileList);
            response.sendRedirect("/teacher/task.jsp");
        }



    }
}
