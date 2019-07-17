package servlet.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/city_pathServlet")
public class City_Path extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getSession().getAttribute("bestPath").toString();
        path="南昌-"+path.trim()+"南昌";
        /*System.out.println("测试1："+path);*/
        String[] city_path = path.split("-");
        /*for(int i=0,len=city_path.length;i<len;i++){
            System.out.println(city_path[i]);
        }*/
        request.setAttribute("city_path",city_path);
        request.setAttribute("length",city_path.length);
        request.getRequestDispatcher("teacher/best_path.jsp").forward(request,response);
    }
}
