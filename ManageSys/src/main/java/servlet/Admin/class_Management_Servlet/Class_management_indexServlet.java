package servlet.Admin.class_Management_Servlet;

import javaBean.Clazz;
import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/class_management_indexServlet")
public class Class_management_indexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServices adminServices = new AdminServices();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //定义 页面数、当前页面数、以及页面大小
        int current_page,page_num,page_size=15;

        //查询班级数目
        int count = adminServices.loadClassNum();

        //初始化获取页面数
        if(count%page_size!=0) {
            page_num = count/page_size +1;
        }else {
            page_num = count/page_size;
        }

        //获取当前的是哪个页面
        if(request.getParameter("current_page")!=null && !("".equals(request.getParameter("current_page")))&& Integer.parseInt(request.getParameter("current_page"))>0 &&Integer.parseInt(request.getParameter("current_page"))<=page_num) {
            current_page = Integer.parseInt(request.getParameter("current_page").toString());
        }else {
            current_page =1;
        }

        List<Clazz> clazzList ;
        clazzList = adminServices.loadAllClassByPage(current_page,page_size);
        if(clazzList!=null){
            request.setAttribute("clazzList",clazzList);
            request.setAttribute("current_page",current_page);
            request.setAttribute("page_num",page_num);
            request.getRequestDispatcher("admin/class/class_management_index.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("error/500.jsp").forward(request,response);
        }
    }
}
