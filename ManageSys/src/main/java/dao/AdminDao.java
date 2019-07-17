package dao;

import javaBean.Admin;
import javaBean.Clazz;
import javaBean.Student;
import javaBean.Teacher;

import java.util.List;

public interface AdminDao {

    public List<Admin> loadInfoByAccount(String ano);

    public boolean updateAdminPsd(String ano, String new_psd);

    public boolean updateAdminInfo(String ano, String name, String phone, String qq);

    /**
     * Class
     */
    public int loadClassNum();

    public List<Clazz> loadAllClassByPage(int current_page,int page_size);

    public List<Student> loadAllStudentByCno(String cno,int current_page,int page_size);

    /**
     * Teacher
     * @return
     */

    public int loadTeacherNum();

    public List<Teacher> loadAllTeacherByPage(int current_page,int page_size);

    public Teacher loadByTno(String tno);

    public Boolean deleteByTno(String tno);

    public boolean addTeacher(Teacher teacher);

    /**
     * Student
     * @return
     */

    public int loadStudentNum();

    public List<Student> loadAllStudentByPage(int current_page,int page_size);

    public List<Student> loadInfoBySno(String sno);

    public boolean updateStudentInfo(String sno,String name,String phone,String qq);

    public boolean deleteStudent(String sno);

    public boolean addStudent(Student student);

}
