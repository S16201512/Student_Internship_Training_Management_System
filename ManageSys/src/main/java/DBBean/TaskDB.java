package DBBean;

import dao.TaskDao;
import javaBean.Correct_task;
import javaBean.Student_task;
import javaBean.Task;
import util.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 任务状态说明：
 * “A” 代做
 * create table task(
 *           task_no int auto_increment primary key,
 *           task_name varchar(100),
 * 	         tno varchar(24),
 *
 *           task_content varchar(1000),
 *
 *           submit    boolean default 0,
 *           start_time varchar(200),
 *           end_time  varchar(200),
 *           create_time  varchar(200)
 * );
 * create table student_task(
 *               sno varchar(20),
 *               task_no int,
 * 	             task_staus  varchar(100) default('待做'),
 *               submit_content varchar(255),
 *               grade   int,
 *               remake  varchar(255),
 *               submit boolean default 0,
 *               isScored boolean default 0
 *          );
 */
public class TaskDB implements TaskDao {



    String task_table = " task ";
    String studentTask_table = " student_task ";

    String task_view = " task_view ";
    String studentTask_view = " studentTask_view ";
    String allstudent_alltask_view = " allstudent_alltask_view ";
    String eachteacher_maycorrect_view = " eachteacher_maycorrect_view ";
    String eachclass_eachtask_totalpeople_view = " eachclass_eachtask_totalpeople_view ";
    String eachclass_eachtask_submitednum_view = " eachclass_eachtask_submitednum_view ";
    String eachteacher_eachtask_maycorrect_view = " eachteacher_eachtask_maycorrect_view ";
    String allstudent_submitedtasklist_view = " allstudent_submitedtasklist_view ";
    /**
     * 插入任务记录
     * @param task_name
     * @param task_content
     * @param tno
     * @param start_time
     * @param end_time
     * @return
     */
    public String insertTask(String task_name,String task_content,String tno,String start_time,String end_time){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currenttime=df.format(new Date());
        String SQL="insert into "+task_table+" (task_name,tno,task_content,create_time,start_time,end_time) values(?,?,?,?,?,?);";
        ResultSet rs=JDBCHelper.execute2(SQL,true,task_name,tno,task_content,currenttime,start_time,end_time);
        try {
            rs.next();
            return  rs.getInt(1)+"";
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 根据tno号加载已发布任务列表。
     * @param tno
     * @return
     */
    public List<Task> loadAll_submit(String tno, boolean submit){
        String SQL;
        System.out.println("教师的账号是："+tno+submit);
        if(submit) {
            SQL = "select * from "+task_view+" where tno=? and submit=1";
        }else{
            SQL = "select * from "+task_view+" where tno=? and submit=0";
        }
        ResultSet rs= JDBCHelper.query(SQL,tno);
        List<Task> taskList=new ArrayList<>();
        try {
            while(rs.next()){
                Task task=new Task();
                task.setTaskName(rs.getString("task_name"));
                task.setTask_content(rs.getString("task_content"));
                task.setCreate_time(rs.getString("create_time"));
                task.setStart_time(rs.getString("start_time"));
                task.setEnd_time(rs.getString("end_time"));
                task.setId(rs.getString("task_no"));
                task.setTno(rs.getString("tno"));
                task.setSubmit(rs.getString("submit"));
                taskList.add(task);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  taskList;
    }

    /**
     * 根据task_id删除任务
     *
     */
    public boolean deleteTaskByID(String task_id){
        String SQL="delete from "+task_table+" where task_no=?";
        return  JDBCHelper.execute(SQL,Integer.parseInt(task_id));
        }
    /**
     * 更新任务发布状态
      */
    public boolean updateTaskSubmitStaus(String TaskId,boolean submit){
        String SQL;
        if(submit==true) {
            SQL = "update "+task_table+" set submit=1 where task_no=?";
        }else {
            SQL = "update "+task_table+" set submit=0 where task_no=?";

        }
        return JDBCHelper.execute(SQL,TaskId);
    }
    /**
     * 根据学生号加载学生任务链表
     */
    public List<Student_task> loadTaskListBySno(String sno,int page_size,int current_page){
        String SQL="select * from "+allstudent_alltask_view+" where sno = '" + sno+"'";
        ResultSet rs= JDBCHelper.queryByPage(SQL,page_size,current_page);
        List<Student_task> taskList=new ArrayList<>();
        try {
            while(rs.next()){
                Student_task task=new Student_task();
                task.setTaskName(rs.getString("task_name"));
                task.setTask_content(rs.getString("task_content"));
                task.setStart_time(rs.getString("start_time"));
                task.setEnd_time(rs.getString("end_time"));
                task.setId(rs.getString("task_no"));
                task.setTno(rs.getString("tno"));
                task.setGrade(rs.getString("grade"));
                task.setTask_staus(rs.getString("task_staus"));
                //task.setRemark(rs.getString("remark"));
                taskList.add(task);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }
    /**
     * 根据任务ID加载任务
     */
    public Task loadBytask_no(String task_no){
        String SQL="select * from "+task_view+" where task_no=?";
        ResultSet rs= JDBCHelper.query(SQL,task_no);
        Task task=null;
        try {
            while(rs.next()){
                task=new Task();
                task.setId(rs.getString("task_no"));
                task.setTaskName(rs.getString("task_name"));
                task.setTno(rs.getString("tno"));
                task.setTask_content(rs.getString("task_content"));
                task.setSubmit(rs.getString("submit"));
                task.setStart_time(rs.getString("start_time"));
                task.setCreate_time(rs.getString("create_time"));
                task.setEnd_time(rs.getString("end_time"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  task;

    }
    /**
     * 根据任务ID修改任务
     */
    public boolean updateTaskBytask_no(String task_no,String task_name,String task_content,String start_time,String end_time){
        String SQL="update "+task_table+" set task_name=?,task_content=?,start_time=?,end_time=? where task_no=?";
        return  JDBCHelper.execute(SQL,task_name,task_content,start_time,end_time,task_no);
    }


    /**
     *加载老师要批改的任务链表
     */
    public List<Correct_task> loadOutDateTaskList1(String tno){
        int totalPerson=0;
        int submitPerson=0;
        Correct_task task;
        List<Correct_task> taskList=new ArrayList<>();
        String SQL="select * from "+eachteacher_maycorrect_view+" where tno = ?";
        ResultSet rs=JDBCHelper.query(SQL,tno);
        try {

            while (rs.next()){
                task=new Correct_task();
                task.setId(rs.getString("task_no"));
                String SQL2="select count(*) from "+eachclass_eachtask_totalpeople_view+" where tno = ? and task_no = ?";
                ResultSet rs2=JDBCHelper.query(SQL2,tno,rs.getString("task_no"));
                rs2.next();
                task.setTotalPerson(rs2.getInt(1));
                String SQL3="select count(*) from "+eachclass_eachtask_submitednum_view+" where tno = ? and task_no = ?";
                ResultSet rs3=JDBCHelper.query(SQL3,tno,rs.getString("task_no"));
                rs3.next();
                task.setSubmitPerson(rs3.getInt(1));


                task.setTaskName(rs.getString("task_name"));
                task.setTno(rs.getString("tno"));
                task.setTask_content(rs.getString("task_content"));

                task.setStart_time(rs.getString("start_time"));
                task.setCreate_time(rs.getString("create_time"));
                task.setEnd_time(rs.getString("end_time"));

                taskList.add(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;

    }


    /**
     * 获取要批改的作业链表根据任务号，教师号
     */
    public List<Student_task> loadSubmitTaskList(String tno, String  task_no){
        String SQL="select * from "+eachteacher_eachtask_maycorrect_view+" where tno = ? and task_no = ?";
        ResultSet rs=JDBCHelper.query(SQL,tno,Integer.parseInt(task_no));
        List<Student_task> taskList =new ArrayList<>();

        try {
            while(rs.next()){

                Student_task task=new Student_task();
                task.setId(task_no);
                task.setTaskName(rs.getString("task_name"));
                task.setStudentNo(rs.getString("sno"));
                task.setStudentName(rs.getString("name"));
                if(rs.getString("submit_time")!=null)
                    task.setSubmit_time(rs.getString("submit_time"));
                if(rs.getString("grade")!=null)
                    task.setGrade(rs.getString("grade"));
                taskList.add(task);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  taskList;


    }
    /**
     * 加载学生提交的答案 学生姓名、班级号、作业内容、提交附件、作业ID
     */
    public Student_task loadStudentFinishedTask(String sno,String task_no){
        Student_task task=new Student_task();
        String SQL="select * from "+allstudent_submitedtasklist_view+" where sno = ? and task_no = ?";
        ResultSet rs=JDBCHelper.query(SQL,sno,task_no);
        try {
            while (rs.next()){
                System.out.println("有数据！");
                task.setStudentNo(sno);
                task.setCno(rs.getString("cno"));
                task.setStudentName(rs.getString("name"));

                task.setTaskName(rs.getString("task_name"));
                task.setId(task_no);
                task.setTask_content(rs.getString("task_content"));
                if(rs.getString("remake")!=null){
                    task.setRemark(rs.getString("remake"));
                }

                if(rs.getString("submit_content")!=null)
                    task.setAnswer(rs.getString("submit_content"));
                task.setSubmit_time(rs.getString("submit_time"));
                //task.setSubmit_file("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;

    }
    /**
     * 更新shtudent_task学生的成绩
     */
    public boolean updateStudentScore(String sno,String taskno,String score,String remake){
        String SQL="update "+studentTask_table+" set  grade=?,remake=?,isScored=1 where sno=? and task_no=?";
        return  JDBCHelper.execute(SQL,score,remake,sno,taskno);
    }

    /**
     * 加载任务数量
     * @return
     */
    @Override
    public int loadTaskNum(String sno) {
        int count =0;
        String SQL = "select count(*) from " + studentTask_view +"where sno = ? ";
        ResultSet rs =JDBCHelper.query(SQL,sno);
        try{
            while(rs.next()){
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }


}
