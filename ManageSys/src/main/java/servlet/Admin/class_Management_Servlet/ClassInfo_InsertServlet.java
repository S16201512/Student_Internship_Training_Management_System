package servlet.Admin.class_Management_Servlet;

import service.Admin.ExcelReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/classFileUpload")
@MultipartConfig(location = "D:/files/class/")
public class ClassInfo_InsertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //String path=request.getSession().getServletContext().getRealPath("/");

        // 参数一定是 file 组件的名字
        new Thread(){
            public void run() {
                // 参数一定是 file 组件的名字

                try {
                    Collection<Part> c = request.getParts();
                    for (Part p : c) {
                        String fileName = p.getSubmittedFileName();
                        String fileurl = "D:/files/class/" + fileName;
                        // 将 上传的文件 写出到磁盘
                        p.write(fileName);

                        //读取文件数据
                        ExcelReader excelReader = new ExcelReader();
                        //表示输出多少列的数据
                        int args = 4;

                        //获取文件后缀
                        String prefix = fileName.substring(fileName.lastIndexOf('.') + 1);
                        boolean b = false;
                        if ("xlsx".equals(prefix)) {
                            b = excelReader.classxlsxReader(fileurl, args);
                        } else {
                            b = excelReader.classxlsReader(fileurl, args);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ServletException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        response.sendRedirect("/admin/class/class_manage.jsp");
    }
}
