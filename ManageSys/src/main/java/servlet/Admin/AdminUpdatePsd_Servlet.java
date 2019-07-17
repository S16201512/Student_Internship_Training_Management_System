package servlet.Admin;

import javaBean.Admin;
import service.Admin.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/AdminUpdatePsd_Servlet")
@MultipartConfig
public class AdminUpdatePsd_Servlet extends HttpServlet {
    //处理修改密码业务的Servlet
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ano = (String) request.getSession().getAttribute("admin_no");//获取该用户的账号
        String old_psd = request.getParameter("old_psd");//原始密码
        System.out.println("旧密码："+old_psd);
        String new_psd = request.getParameter("new_psd");//新密码
        String confirm_psd = request.getParameter("confirm_psd");//确认密码
        String message = "";
        AdminServices adminServices = new AdminServices();
        List<Admin> adminList = adminServices.loadInfoByAccount(ano);
        if (adminList==null && adminList.size()<1){//查询是否存在该用户
            response.sendRedirect("/admin/fail.jsp");
            return;
        }
        Admin admin = adminList.get(0);

        if("".equals(old_psd) || "".equals(new_psd)|| "".equals(confirm_psd)){
            //输入框不允许为空
            message = "密码不允许为空";
            request.setAttribute("updatePsd_message1",message);
            request.getRequestDispatcher("../admin/admin_updatePsd.jsp").forward(request,response);
            return;
        }

        if(!admin.getPsd().equals(old_psd)){
            //原始密码输入有误
            message = "原始密码输入有误";

            System.out.println("旧密码lalala："+admin.getPsd());
            request.setAttribute("updatePsd_message1",message);
            request.getRequestDispatcher("../admin/admin_updatePsd.jsp").forward(request,response);
            return;
        }

        if(admin.getPsd().equals(new_psd)){
            //修改密码不能与原密码一致
            message = "修改密码不能与原密码一致";
            request.setAttribute("updatePsd_message2",message);
            request.getRequestDispatcher("../admin/admin_updatePsd.jsp").forward(request,response);
            return;
        }

        if(!new_psd.equals(confirm_psd)){
            //若确认密码和新密码不一致
            message = "确认密码和新密码不一致";
            request.setAttribute("updatePsd_message3",message);
            request.getRequestDispatcher("../admin/admin_updatePsd.jsp").forward(request,response);
            return;
        }

        //准备修改密码
        boolean b = adminServices.updateAdminPsd(ano,new_psd);
        if(b){
            //修改密码成功
            message = "修改密码成功";
            request.setAttribute("updatePsd_message",message);
            response.sendRedirect("../admin/success.jsp");
        }else{
            //修改密码成功
            message = "修改密码失败";
            request.setAttribute("updatePsd_message",message);
            response.sendRedirect("../admin/fail.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
