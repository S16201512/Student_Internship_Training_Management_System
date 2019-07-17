package servlet.Admin;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@WebServlet("/admin/updateHeandImg")
@MultipartConfig
public class AdminUpdateHeadImgServlet extends HttpServlet {
    private String imagName=null;
    private String fileType;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ano = (String) request.getSession().getAttribute("admin_no");//获取该用户的账号
        Part p=request.getPart("file");
        if(p.getSubmittedFileName()!=null) {
            new Thread() {
                public void run() {
                    FilesWriteProcess(p);//将头像图片写入/images文件夹里
                }
            }.start();
            imagName = p.getSubmittedFileName();
            fileType=p.getSubmittedFileName().substring(p.getSubmittedFileName().indexOf(".")+1,p.getSubmittedFileName().length());
        }
        if(imagName!=null){  //将头像文件名写入数据库
            new Thread() {
                public void run() {
                    writeToXml(ano,imagName);//更新xml文件
                }

            }.start();

            //request.getRequestDispatcher("/admin/admin_updatePsd.jsp").forward(request,response);
            response.setHeader("refresh","0;url=/admin/admin_updatePsd.jsp");

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
            String fileName = p.getSubmittedFileName();
            //获得存储上传文件的文件夹路径
            String fileSavingFolder = this.getServletContext().getRealPath("/images");
            //System.out.println("fileSavingFolder" + fileSavingFolder);
            //获得存储上传文件的完整路径（文件夹路径+文件名）
            //文件夹位置固定，文件夹采用与上传文件的原始名字相同
            String fileSavingPath = fileSavingFolder + "\\" + fileName;
            //System.out.println("fileSavingPath" + fileSavingPath);
            File file = new File(fileSavingPath);
            int str;
            OutputStream os = new FileOutputStream(file);

            while ((str = is.read()) != -1) {
                os.write(str);
            }
            os.close();
            is.close();

        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 用用户名，头像名更新xml文件
     * @param username
     * @param Imagename
     * @return
     */
    public synchronized boolean writeToXml(String username,String Imagename){
        Document doc=null;
        try {
            SAXReader reader = new SAXReader();
            doc = reader.read(new File(this.getServletContext().getRealPath("/xml")+"//Headimg.xml"));
            Element root = doc.getRootElement();
            List<Element> empCDList = root.elements("CD");
            Element exitUseremp=null;
            for(Element cd:empCDList){//判断xml中是否已经拥有此用户
                if(cd.element("userName").getText().equals(username)){
                    exitUseremp=cd;
                    cd.remove(cd.element("Headimg"));
                    Element headimg=cd.addElement("Headimg");
                    headimg.addText(Imagename);
                }
            }
            if(exitUseremp==null) {//如果xml中没有此用户，将此用户添加进去
                Element newCD = root.addElement("CD");
                Element nameEle = newCD.addElement("userName");
                nameEle.addText(username);
                Element ImageEle = newCD.addElement("Headimg");
                ImageEle.addText(Imagename);
            }
            //将改动写入XML文件
            XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
            FileOutputStream fos = new FileOutputStream(this.getServletContext().getRealPath("/xml")+"//Headimg.xml");
            writer.setOutputStream(fos);
            writer.write(doc);
            //System.out.println("写出完毕!");
            fos.close();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }

        return true;
    }

}
