package servlet.teacher;

import javaBean.Correct_task;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/loadCorrectTaskList")
public class LoadOutdatetaskList extends HttpServlet {
    private String tno;
    private List<Correct_task> taskList;
    private TeacherService service;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new TeacherService();
        if(request.getSession().getAttribute("teacher_no")!=null){
            tno=(String)request.getSession().getAttribute("teacher_no");
            System.out.println("教师编号："+tno);
            taskList=service.loadOutDateTaskList(tno);

        }
        request.getSession().setAttribute("taskList3",taskList);
        request.getSession().setAttribute("Button1","3");
        response.sendRedirect("/teacher/task.jsp");
    }
}
