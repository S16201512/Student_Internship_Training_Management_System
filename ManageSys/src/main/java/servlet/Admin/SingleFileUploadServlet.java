package servlet.Admin;

import service.Admin.ExcelReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet( "/singleFileUpload")
// 表示 对应的上传文件的配置
@MultipartConfig(location = "D:/files/")
public class SingleFileUploadServlet extends HttpServlet {
    private String fileName="";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String path=request.getSession().getServletContext().getRealPath("/");
        String type=request.getParameter("type");

        // 参数一定是 file 组件的名字
        Part p = request.getPart("file");

        new Thread() {
            public void run() {
                try {
                    fileName = p.getSubmittedFileName();
                    // 将 上传的文件 写出到磁盘
                    p.write(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //读取文件数据
        ExcelReader excelReader = new ExcelReader();
        String excelurl = "D:/files/"+fileName;
        //表示输出多少列的数据
        int args;
        if("teacher".equals(type)){
           args = 6;
        }else{
            args = 5;
        }

        //获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf('.') + 1);
        boolean b = false;
        if("xlsx".equals(prefix)){
            b = excelReader.xlsxReader(excelurl,type,args);
        }else{
            b = excelReader.xlsReader(excelurl,type,args);
        }

        response.sendRedirect("/admin/bulkInsert.jsp");
    }
}
