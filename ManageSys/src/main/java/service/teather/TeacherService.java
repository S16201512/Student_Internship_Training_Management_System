package service.teather;

import dao.*;
import javaBean.*;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    TeacherDao teacherDB= Factory.getFactory().getInstance(TeacherDao.class);
    FileDao fileDB= Factory.getFactory().getInstance(FileDao.class);
    TaskDao taskDB= Factory.getFactory().getInstance(TaskDao.class);
    StudentDao studentDB=Factory.getFactory().getInstance(StudentDao.class);


    /**
     * 加载所有实习信息
     */
    public List<T_registration> loadAllRegistration(){
        return teacherDB.loadAllRegistration();
    }

    /**
     *
     * @param tno
     * @return
     */

    public Teacher loadByTno(String tno){
        return teacherDB.loadByTno(tno);
    }

    public boolean updatePsdByTno(String tno,String new_psd){
        return teacherDB.updatePsdByTno(tno,new_psd);
    }

    public  boolean updateInfo(String tno,String name,String phone,String qq,String profession){
        return teacherDB.updateInfo(tno,name,phone,qq,profession);
    }

    public String loadPsdByTno(String tno){
        return teacherDB.loadPsdByTno(tno);
    }

    /**
     * 根据任务信息增加任务
     * @param task_name
     * @param task_content
     * @param tno

     * @param start_time
     * @param end_time
     * @return
     */
    public String  addTask(String task_name, String task_content, String tno,String start_time,String end_time) {

        return taskDB.insertTask(task_name,task_content,tno,start_time,end_time);
    }

    /**
     * 根据文件名，文件类型增加文件
     * @param submittedFileName
     * @param fileType
     * @return
     */

    public boolean addFile(String submittedFileName, String fileType,String task_no,String owe_perNo) {

        return fileDB.insertFile1(submittedFileName,fileType,task_no,owe_perNo);

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

    /**
     * 根据ID号与发布状态加载任务
     * @param tno
     * @param submit
     * @return
     */
    public List<Task> loadAlltaskByno(String tno, boolean submit){
        return  taskDB.loadAll_submit(tno,submit);
    }
    /**
     * 根据任务ID获取文件
     */
    public List<T_file> loadFileByTask_no(String taskId){
        return  fileDB.loadByTask_no(taskId);

    }
    /**
     * 根据任务ID删除任务
     * @param task_id
     * @return
     */
    public boolean deleteTaskByno(String task_id){
        return  taskDB.deleteTaskByID(task_id);
    }
    /**
     * 根据任务ID加载任务
     */
     public Task LoadByTask_no(String task_no){
         return  taskDB.loadBytask_no(task_no);
     }
    /**
     * 更新任务发布状态
     * @param taskId
     * @return
     */
    public boolean updateTaskSubmitStaus(String taskId,boolean submit){
        return taskDB.updateTaskSubmitStaus(taskId,submit);
    }

    /**
     * 根据任务id修改任务
     */
    public boolean updateTaskByTask_no(String task_no,String task_name,String task_content,String start_time,String end_time){
        return taskDB.updateTaskBytask_no(task_no,task_name,task_content,start_time,end_time);
    }
    /**
     *加载老师批改的任务链表
     */
    public List<Correct_task> loadOutDateTaskList(String tno){
        return taskDB.loadOutDateTaskList1(tno);
    }
    /**
     * 按任务号，教师号加载某一次任务提交的班级作业链表
     */
    public List<Student_task> loadSubmitTaskList(String tno, String task_no){
        return taskDB.loadSubmitTaskList(tno,task_no);

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
     * 给学生作业打分
     */
    public boolean scoredStudentTask(String sno,String taskno,String score,String remake){
        return taskDB.updateStudentScore(sno,taskno,score,remake);

    }

    /**
     * 获取该老师所带班内学生的全部实习地点
     */
    public ArrayList<String> loadLookBackPoint(String tno) {
        return studentDB.loadLookBackPoint(tno);
    }






}

