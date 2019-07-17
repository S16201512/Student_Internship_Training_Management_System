package DBBean;

import dao.StudentTaskDao;
import util.JDBCHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentTaskDB implements StudentTaskDao {



    String task_table = " task ";
    String studentTask_table = " student_task ";
    String studentTask_view = " studentTask_view ";
    @Override
    public boolean addTask(String submit_content,int task_no,String sno) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currenttime=df.format(new Date());
        String SQL="update "+studentTask_table+" set task_staus=?,submit_content=?,submit_time=?,IsSubmit=? ,isScored=? where task_no=? and sno=?";
        System.out.println("更新于巨执行完毕");
        String task_staus="完成";
        Boolean IsSubmit=true;
        Boolean isScored =true;

        return JDBCHelper.execute(SQL,task_staus,submit_content,currenttime,IsSubmit,isScored,task_no,sno);
    }
}
