package servlet.student;

import javaBean.Student;
import service.student.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/student/studentUpdate")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String psd = request.getParameter("Apsd");  //旧密码值
        String Npsd = request.getParameter("Npsd");  //新密码值
        String SNpsd = request.getParameter("SNpsd"); //确认新密码的值
        String sno = request.getParameter("sno");   //学生账号
        System.out.print(Npsd);
        StudentService studentService = new StudentService();
        List<Student> list = null;
        try {
            list = studentService.massageSelect(sno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String Apsd = list.get(0).getPsd(); //从数据库中获得的旧密码值
        System.out.print("*******"+Apsd);
        System.out.print("*#######*"+psd);
        if (Apsd.equals(psd)){
            if(Apsd.equals(Npsd)) {
                System.out.print("输入的新密码与原密码一致");
            }else if(Npsd.equals(SNpsd)){
                studentService.massageUpdate(sno,Npsd);
                System.out.print("修改成功");
            }
        }else {
            System.out.print("输入的原密码与原密码不一致");
        }
        request.getRequestDispatcher("/student/main.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        this.doGet(request,response);
    }
}
