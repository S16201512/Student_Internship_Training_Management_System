package servlet.student;

import javaBean.Student_task;
import javaBean.Task;
import service.student.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/loadTask")
public class LoadTaskList extends HttpServlet {
    private String sno;
    private StudentService service;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new StudentService();
        if(request.getSession().getAttribute("student_no")!=null)
              sno=(String)request.getSession().getAttribute("student_no");
        //定义 页面数、当前页面数、以及页面大小
        int current_page,page_num,page_size=9;

        //查询班级数目
        int count = service.loadTaskNum(sno);
        System.out.println("****1****"+count);

        //初始化获取页面数
        if(count%page_size!=0) {
            page_num = count/page_size +1;
        }else {
            page_num = count/page_size;
        }
        System.out.println("****2****"+page_num);

        //获取当前的是哪个页面
        if(request.getParameter("current_page")!=null && !("".equals(request.getParameter("current_page")))&& Integer.parseInt(request.getParameter("current_page"))>0 &&Integer.parseInt(request.getParameter("current_page"))<=page_num) {
            current_page = Integer.parseInt(request.getParameter("current_page").toString());
        }else {
            current_page =1;
        }
        System.out.println("****3****"+current_page);
        List<Student_task> tasklist=service.loadAlltaskByno(sno,page_size,current_page);
        request.setAttribute("current_page",current_page);
        request.setAttribute("page_num",page_num);
        request.getSession().setAttribute("tasklist",tasklist);
        request.getRequestDispatcher("/student/look_mission.jsp").forward(request,response);
    }
}
