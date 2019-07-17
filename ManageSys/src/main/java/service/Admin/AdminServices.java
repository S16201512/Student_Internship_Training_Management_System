package service.Admin;

import dao.AdminDao;
import dao.Factory;
import javaBean.Admin;
import javaBean.Clazz;
import javaBean.Student;
import javaBean.Teacher;

import java.util.List;

public class AdminServices {

    AdminDao adminDB = Factory.getFactory().getInstance(AdminDao.class);

    /**
     * 加载班级数目
     */
    public int loadClassNum(){
        return adminDB.loadClassNum();
    }

    /**
     * 根据班级加载该班级所有学生
     */
    public  List<Student> loadAllStudentByCno(String cno,int current_page,int page_size){
        return adminDB.loadAllStudentByCno(cno,current_page,page_size);
    }

    /**
     * 加载所有班级
     * @return
     */
    public List<Clazz> loadAllClassByPage(int current_page,int page_size){
        return adminDB.loadAllClassByPage(current_page,page_size);
    }

    /**
     * 加载学生数量
     * @param
     * @param
     * @return
     */
    public int loadStudentNum(){
        return adminDB.loadStudentNum();
    }

    //加载所有学生
    public List<Student> loadAllStudentByPage(int current_page,int page_size) {
        return adminDB.loadAllStudentByPage(current_page,page_size);
    }

    //根据学生的学号查询学生
    public List<Student> loadInfoBySno(String sno) {
        return adminDB.loadInfoBySno(sno);
    }

    //修改学生信息
    public boolean updateStudentInfo(String sno, String name, String phone, String qq) {
        return adminDB.updateStudentInfo(sno,name,phone,qq);
    }

    //删除学生
    public boolean deleteStudent(String sno) {
        return adminDB.deleteStudent(sno);
    }

    //添加学生
    public boolean addStudent(Student student){
        return  adminDB.addStudent(student);
    }


    /**
     * 加载教师数目
     */
    public int loadTeacherNum(){
        return adminDB.loadTeacherNum();
    }

    /**
     *
     */
    public boolean addTeacher(Teacher teacher){
        return adminDB.addTeacher(teacher);
    }
    /**
     * 根据教师编号删除教师信息
     * @param tno
     * @return
     */
    public boolean deleteByTno(String tno){
        return adminDB.deleteByTno(tno);
    }

    /**
     * 根据教师编号加载信息z
     * @param tno
     * @return
     */
    public Teacher loadByTno( String tno){
        return adminDB.loadByTno(tno);
    }
    /**
     * 加载所有教师信息
     * @param
     * @return
     */
    public  List<Teacher> loadAllTeacherByPage(int current_page,int page_size){
        return adminDB.loadAllTeacherByPage(current_page,page_size);
    }

    //根据管理员账号查询该管理员的身份信息
    public List<Admin> loadInfoByAccount(String ano){
        System.out.println("************testServices:"+ano);
        return adminDB.loadInfoByAccount(ano);
    }

    //修改管理员的密码
    public boolean updateAdminPsd(String ano,String new_psd){
        return adminDB.updateAdminPsd(ano,new_psd);
    }

    //修改管理员的信息
    public boolean updateAdminInfo(String ano,String name,String phone,String qq){
        return  adminDB.updateAdminInfo(ano,name,phone,qq);
    }
}
