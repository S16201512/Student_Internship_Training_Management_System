package servlet.teacher;

import javaBean.T_file;
import javaBean.Task;
import service.teather.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.List;

@WebServlet("/teacher/Update_task_info")
@MultipartConfig
public class Update_task_IfoServlet extends HttpServlet {
    private String task_no;
    private String task_name;
    private String task_content;
    private String end_time;
    private String start_time;
    private TeacherService service;
    private List<T_file>  fileList;
    private String tno;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new TeacherService();
        if(request.getParameter("task_name")!=null&&request.getParameter("end_time")!=null){
           task_name=request.getParameter("task_name");
           end_time=request.getParameter("end_time");
       }
       if(request.getParameter("task_content")!=null&&request.getParameter("start_time")!=null){
           task_content=request.getParameter("task_content");
           start_time=request.getParameter("start_time");

       }
       if(request.getSession().getAttribute("teacher_no")!=null){
           tno=(String)request.getSession().getAttribute("teacher_no");
       }
       if(request.getParameter("task_no")!=null){
           task_no=request.getParameter("task_no");
       }
       //将该任务之前的文件删除
       if(request.getSession().getAttribute("fileList")!=null) {
           fileList=(List)request.getSession().getAttribute("fileList");
           for(T_file file:fileList) {
               String fileSavingFolder = this.getServletContext().getRealPath("/teacher/TaskFile");
               String fileSavingPath = fileSavingFolder + "\\" + file.getFilename();
               File delFile=new File(fileSavingPath);
               delFile.delete();
           }

       }


       new Thread() {
            public  void run() {

                service.deleteFileByTaskNoAndTno(task_no,tno);
                try

                {
                    /**
                     * 获取文件并将文件写入服务器
                     */
                    Collection<Part> partList = request.getParts();
                    if (partList.size() > 0)
                        for (Part p : partList) {
                            if (p.getSubmittedFileName() != null && !(p.getSubmittedFileName().trim().equals(""))) {
                                System.out.println("文件的名字：" + p.getSubmittedFileName());
                                //System.out.println("Part中有内容！");
                                String fileType = p.getSubmittedFileName().substring(p.getSubmittedFileName().indexOf(".") + 1, p.getSubmittedFileName().length());
                                if (service.addFile(p.getSubmittedFileName(), fileType, task_no, tno))
                                    FilesWriteProcess(p);

                            }
                        }
                } catch (IOException e)

                {
                    e.printStackTrace();
                } catch (ServletException e){
                    e.printStackTrace();
                }
            }
       }.start();
       if(task_name!=null&&task_content!=null&&end_time!=null&&start_time!=null){
           if(service.updateTaskByTask_no(task_no,task_name,task_content,start_time,end_time)){
               List<Task> tasklist=service.loadAlltaskByno(tno,false);
               List<Task> tasklist2=service.loadAlltaskByno(tno,true);
               request.getSession().setAttribute("tasklist",tasklist);
               request.getSession().setAttribute("tasklist2",tasklist2);
               request.getSession().setAttribute("Button1","2");
               response.sendRedirect("/teacher/task.jsp");
           }


       }
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
            String fileSavingFolder = this.getServletContext().getRealPath("/teacher/TaskFile");
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


