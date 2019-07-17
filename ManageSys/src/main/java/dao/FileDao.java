package dao;

import javaBean.T_file;

import java.util.List;

public interface FileDao {
    public String insertFile(String filename, String fileType);
    public T_file LoadByNo(String fileno);
    public T_file LoadByTime(String currenttime);
    public boolean insertFile1(String submittedFileName, String fileType, String task_no, String sno);
    public List<T_file> loadByTask_no(String task_no);
    public List<T_file> loadStudentSubmitTaskFile(String sno,String task_no);
    public boolean updateFile(String submittedFileName, String fileType, String task_no, String sno);


    public boolean deleteFileByTaskNoAndTno(String task_no,String tno);
}
