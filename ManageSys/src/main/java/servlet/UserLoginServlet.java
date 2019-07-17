package servlet;

import javaBean.Student_task;
import javaBean.Task;
import service.UserLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private List<Student_task> tasklist;
    UserLoginService userLoginService = new UserLoginService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String identity = request.getParameter("identity");
        String loginmsg="";

        if ("".equals(id) || "".equals(password)) {
            loginmsg="用户名或密码不能为空!";
            request.setAttribute("loginmsg", loginmsg);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            boolean b = userLoginService.load(id, password, identity);
            if (b) {

                if (identity.equals("admin")) {
                    request.getSession().setAttribute("admin_no", id);
                    request.getRequestDispatcher("/admin/admin_index.jsp").forward(request, response);
                } else {
                    if (identity.equals("teacher")) {
                        request.getSession().setAttribute("teacher_no", id);
                        List<Task> tasklist=userLoginService.loadAlltaskByTno(id,false);
                        List<Task> tasklist2=userLoginService.loadAlltaskByTno(id,true);
                        request.getSession().setAttribute("tasklist",tasklist);
                        request.getSession().setAttribute("tasklist2",tasklist2);
                        request.getSession().setAttribute("Button1","2");
                        response.sendRedirect("teacher/teacher_index.jsp");
                    } else {
                        //List<T_file> fileList=userLoginService.load
                        if(userLoginService.loadAlltaskBySno(id,9,1)!=null) {
                            request.getSession().setAttribute("student_no", id);
                            tasklist = userLoginService.loadAlltaskBySno(id,9,1);
                            request.getSession().setAttribute("tasklist",tasklist);
                        }


                        request.getRequestDispatcher("student/main.jsp").forward(request, response);
                    }
                }
            } else {
                // 没有这个用户
                loginmsg="用户名或密码错误!";
                request.setAttribute("loginmsg", loginmsg);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
    }
}
