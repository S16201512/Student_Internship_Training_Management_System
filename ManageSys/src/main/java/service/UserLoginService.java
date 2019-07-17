package service;

import dao.Factory;
import dao.TaskDao;
import dao.UserLoginDao;
import javaBean.Student_task;
import javaBean.Task;
import javaBean.User;

import java.util.List;

public class UserLoginService {

    UserLoginDao userLoginBean= Factory.getFactory().getInstance(UserLoginDao.class);
    TaskDao taskDB= Factory.getFactory().getInstance(TaskDao.class);
    public boolean load(String id, String password, String identity) {
        User u = userLoginBean.loadById(id, identity);
        if (u != null) {
            String psd = u.getPsd();
            // 判断两次密码是否相等
            if (psd.equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取任物链表根据教师号，任务发布状态
     * @param tno
     * @return
     */
    public List<Task> loadAlltaskByTno(String tno, boolean submit){
        return  taskDB.loadAll_submit(tno,submit);
    }
    /**
     *
     * 加载学生任务链表
     */
    public List<Student_task> loadAlltaskBySno(String sno,int page_size,int current_page){
        return  taskDB.loadTaskListBySno(sno,page_size,current_page);
    }
}
