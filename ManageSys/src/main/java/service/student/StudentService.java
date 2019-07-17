package service.student;

import dao.*;
import javaBean.Student;
import javaBean.Student_task;
import javaBean.T_file;
import javaBean.Task;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
   // StudentDBBean studentDBBean = new StudentDBBean();
    FileDao fileDB=Factory.getFactory().getInstance(FileDao.class);
    StudentDao studentDBBean=Factory.getFactory().getInstance(StudentDao.class);
    TaskDao taskDB=Factory.getFactory().getInstance(TaskDao.class);
    StudentTaskDao studentTaskDB =Factory.getFactory().getInstance(StudentTaskDao.class);


    /**
     * 加载任务数量
     */
    public int loadTaskNum(String sno){
        return taskDB.loadTaskNum(sno);
    }

    /**
     * 根据任务号和所属人号删除文件表中的文件
     * @param task_no
     * @param tno
     * @return
     */
    public boolean deleteFileByTaskNoAndTno(String task_no,String tno){
        return fileDB.deleteFileByTaskNoAndTno(task_no,tno);
    }

    //学生信息查询
    public List<Student> massageSelect(String sno) throws SQLException {

        return  studentDBBean.massageSelect(sno);
    }

    //学生修改密码
    public boolean massageUpdate(String sno ,String psd){

        return studentDBBean.massageUpdate(sno ,psd);
    }

    /**
     *
     * 加载任务链表
     */
    public List<Student_task> loadAlltaskByno(String sno,int page_size,int current_page){
        return  taskDB.loadTaskListBySno(sno,page_size,current_page);
    }

    /**
     * 实习信息注册
     * @param rno
     * @param province
     * @param city
     * @param company
     * @param linkman
     * @param linkmanphone
     * @return
     */
    public boolean registrationInfo(String rno, String province, String city, String company, String linkman, String linkmanphone) {
        return studentDBBean.registrationInfo(rno,province,city,company,linkman,linkmanphone);
    }

    /*
     * 文件添加
     * */
    public boolean addFile(String submittedFileName,String fileType,String task_no, String sno) {

        return fileDB.insertFile1(submittedFileName,fileType,task_no,sno);
    }
    /*
        学生提交任务
     */
    public boolean addTask(String submit_content,int task_no,String sno) {

        return studentTaskDB.addTask(submit_content,task_no,sno);
    }

    /**
     * 加载学生的任务
     */
    public Student_task LoadStudentTask(String sno, String task_no){
        return taskDB.loadStudentFinishedTask(sno,task_no);

    }
    /**
     * 加载任务的附件
     */
    public List<T_file> LoadTaskFileByTask_no(String task_no){
        return fileDB.loadByTask_no(task_no);
    }
    /**
     * 加载学生完成的作业
     */

    public Student_task loadStudentFinishedTask(String sno, String task_no){
        return taskDB.loadStudentFinishedTask(sno,task_no);

    }
    /**
     * 加载学生提交的作业附件
     */
    public List<T_file> loadStudentSubmitTaskFile(String sno, String task_no){
        return fileDB.loadStudentSubmitTaskFile(sno,task_no);
    }
    /**
     * 跟新学生提交文件内容
     */
    public boolean updateFile(String submittedFileName, String fileType, String task_no, String sno){
        return fileDB.updateFile(submittedFileName,fileType,task_no,sno);
    }

}
