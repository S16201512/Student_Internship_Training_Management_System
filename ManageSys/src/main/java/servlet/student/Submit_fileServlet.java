package servlet.student;

import service.student.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.Date;

@WebServlet("/student/Submit_fileServlet")
@MultipartConfig
public class Submit_fileServlet extends HttpServlet {
    private String task_no;
    private String task_staus;
    private int grade;
    private Date submit_time;
    private String remake;
    private String submit_content;
    private String sno ;
    private boolean IsSubmit;
    private boolean isScored;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        StudentService service = new StudentService();
        sno = (String) request.getSession().getAttribute("student_no");
        submit_time=new Date();
        submit_content = request.getParameter("task_content");
        task_no = request.getParameter("task_no");
        System.out.println("task_no"+task_no+"："+submit_content+"sno:"+sno);
       // System.out.print(submit_content);

        new Thread() {
            public void run() {
                try {
                    /**
                     * 获取文件并将文件写入服务器
                     */
                    if(request.getContentType()!=null) {
                        Collection<Part> partList = request.getParts();
                        if (partList.size() != 0)
                            for (Part p : partList) {
                                if (p.getSubmittedFileName() != null) {
                                    //System.out.println("文件的名字：" + p.getSubmittedFileName());
                                    //System.out.println("Part中有内容！");
                                    String fileType = p.getSubmittedFileName().substring(p.getSubmittedFileName().indexOf(".") + 1, p.getSubmittedFileName().length());
                                    service.addFile(p.getSubmittedFileName(), fileType, task_no, sno);
                                    FilesWriteProcess(p);
                                }
                            }
                    }
                    /**
                     * 将任务相关的信息插入数据库
                     */
                    service.addTask(submit_content, Integer.parseInt(task_no), sno);
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (ServletException e){
                    e.printStackTrace();
                }
            }
        }.start();
        response.sendRedirect("/student/loadTask");

    }


    /**
     * 将文件写入服务器
     * @param p
     * @return
     */
    public synchronized boolean FilesWriteProcess(Part p) {
        try {
            InputStream is = p.getInputStream();
            BufferedInputStream bis=new BufferedInputStream(is);
            String fileName = p.getSubmittedFileName();
            //获得存储上传文件的文件夹路径
            String fileSavingFolder = this.getServletContext().getRealPath("/student/Task_file");
            System.out.println("fileSavingFolder" + fileSavingFolder);
            //获得存储上传文件的完整路径（文件夹路径+文件名）
            //文件夹位置固定，文件夹采用与上传文件的原始名字相同
            String fileSavingPath = fileSavingFolder + "\\" + fileName;
            System.out.println("fileSavingPath" + fileSavingPath);
            File file = new File(fileSavingPath);
            int size;
            byte[] buffer=new byte[10240];

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

            while((size=bis.read(buffer))!=-1){
                bos.write(buffer, 0, size);
            }
            bos.flush();
            bos.close();
            bis.close();

        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
