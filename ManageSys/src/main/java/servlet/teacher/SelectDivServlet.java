package servlet.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/handle_Button")
public class SelectDivServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id=request.getParameter("id");
            if(id.trim().equals("1")){
                request.getSession().setAttribute("Button1","1");
                response.sendRedirect("/teacher/task.jsp");
            }else if(id.trim().equals("2")){
                request.getSession().setAttribute("Button1","2");
                response.sendRedirect("/teacher/task.jsp");
            }else if(id.trim().equals("3")){
                request.getSession().setAttribute("Button1","3");
                response.sendRedirect("/teacher/task.jsp");

            }
        }
    }

