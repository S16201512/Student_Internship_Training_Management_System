package dao;

import javaBean.Correct_task;
import javaBean.Student_task;
import javaBean.Task;

import java.util.List;

public interface TaskDao {

    public String insertTask(String task_name, String task_content, String tno, String start_time, String end_time);
    public List<Task> loadAll_submit(String tno, boolean submit);
    public boolean deleteTaskByID(String task_id);
    public boolean updateTaskSubmitStaus(String TaskId, boolean submit);
    public List<Student_task> loadTaskListBySno(String sno,int page_size,int current_page);
    public Task loadBytask_no(String task_no);
    public boolean updateTaskBytask_no(String task_no, String task_name, String task_content, String start_time, String end_time);
    public List<Correct_task> loadOutDateTaskList1(String tno);
    public List<Student_task> loadSubmitTaskList(String tno, String task_no);
    public Student_task loadStudentFinishedTask(String sno, String task_no);
    public boolean updateStudentScore(String sno, String taskno, String score, String remake);

    public int loadTaskNum(String sno);


}
