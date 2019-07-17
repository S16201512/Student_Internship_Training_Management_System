package DBBean;

import dao.AdminDao;
import javaBean.Admin;
import javaBean.Clazz;
import javaBean.Student;
import javaBean.Teacher;
import util.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDB implements AdminDao {

    String teacher_TableName = "t_teacher";
    String tableName = "t_admin";
    String student_tableName = "t_student";
    String class_tableName = "t_class";

    //视图创建
    String student_view = "student_view";
    String admin_view = "admin_view";
    String teacher_view = "teacher_view";
    String class_view = "class_view";


    /**
     *加载学生数量
     * @return
     */
    @Override
    public int loadStudentNum() {
        int student_sum = 0;
        String SQL = "select count(*) from " + student_view;
        ResultSet rs = JDBCHelper.query(SQL);
        System.out.print("");
        try{
            while (rs.next()){
                student_sum = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return student_sum;
    }

    /**
     * 新添加学生
     * @param student
     * @return 添加学生是否成功
     */
    @Override
    public boolean addStudent(Student student) {
        boolean flag = false;
        String SQL = "insert into "+student_tableName+" (sno,psd,name,phone,qq) values(?,?,?,?,?)";
        flag = JDBCHelper.execute(SQL,student.getId(),student.getPsd(),student.getName(),student.getPhone(),student.getQQ());
        return  flag;
    }

    /**
     * 删除指定学生
     * @param sno
     * @return 删除学生是否成功
     */
    @Override
    public boolean deleteStudent(String sno) {
        boolean flag = false;
        String SQL = "delete from "+student_tableName+" where sno = ?";
        flag = JDBCHelper.execute(SQL,sno);
        return flag;
    }

    /**
     *
     * @param sno
     * @param name
     * @param phone
     * @param qq
     * @return 修改学生信息是否成功
     */
    @Override
    public boolean updateStudentInfo(String sno, String name, String phone, String qq) {
        boolean flag = false;
        String SQL = "update "+student_tableName+" set name = ?, phone = ?, qq = ? where sno = ?";
        flag = JDBCHelper.execute(SQL,name,phone,qq,sno);
        return flag;
    }

    //根据学号查询学生
    @Override
    public List<Student> loadInfoBySno(String sno) {
        List<Student> studentList = new ArrayList<Student>();
        String SQL = "select * from "+student_view+" where sno = ?";
        ResultSet rs = JDBCHelper.query(SQL,sno);
        try {
            if(rs.next()){
                Student student = new Student();
                student.setId(rs.getString("sno"));
                student.setPsd(rs.getString("psd"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setQQ(rs.getString("qq"));
                studentList.add(student);
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<Student> loadAllStudentByPage(int current_page,int page_size) {
        List<Student> studentList = new ArrayList<Student>();
        String SQL = "select * from "+student_view+ " limit "+(current_page-1)*page_size+" , "+page_size;
        ResultSet rs = JDBCHelper.query(SQL);
        try {
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getString("sno"));
                student.setPsd(rs.getString("psd"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setQQ(rs.getString("qq"));
                studentList.add(student);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
    /**
     * 根据管理员的账号查询到管理员的详细信息
     * @param ano
     * @return 该管理员对象所在的List
     */
    @Override
    public List<Admin> loadInfoByAccount(String ano) {
        System.out.println("************test3:"+ano);
        List<Admin> adminList = new ArrayList<Admin>();
        System.out.println("************test4:"+ano);
        String SQL = "select * from "+admin_view+" where ano = ?";
        ResultSet rs = JDBCHelper.query(SQL,ano);
        try {
            if(rs.next()){
                Admin admin = new Admin();
                admin.setId(rs.getString("ano"));
                admin.setPsd(rs.getString("psd"));
                admin.setName(rs.getString("name"));
                admin.setPhone(rs.getString("phone"));
                admin.setQQ(rs.getString("qq"));
                adminList.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }

    /**
     * 修改管理员的登录密码
     * @param ano
     * @param new_psd
     * @return 修改是否成功
     */
    @Override
    public boolean updateAdminPsd(String ano, String new_psd) {
        boolean flag = false;
        System.out.println("*************1**********"+new_psd);
        String SQL = "update "+admin_view+" set psd = ? where ano = ?";
        flag = JDBCHelper.execute(SQL,new_psd,ano);
        return flag;
    }


    /**
     * 修改管理员的个人信息
     * @param ano
     * @param name
     * @param phone
     * @param qq
     * @return  修改是否成功
     */
    @Override
    public boolean updateAdminInfo(String ano, String name, String phone, String qq) {
        boolean flag = false;
        String SQL = "update "+admin_view+" set name = ?, phone = ?, qq = ? where ano = ?";
        flag = JDBCHelper.execute(SQL,name,phone,qq,ano);
        return flag;
    }

    /**
     *加载班级数量
     * @return
     */
    @Override
    public int loadClassNum() {
        int sum = 0;
        String SQL = "select count(*) from " + class_view;
        ResultSet rs = JDBCHelper.query(SQL);
        try{
            while (rs.next()){
                sum = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return sum;
    }

    /**
     * 加载所有班级信息
     * @return
     */
    @Override
    public List<Clazz> loadAllClassByPage(int current_page,int page_size) {
        List<Clazz> clazzList = new ArrayList<Clazz>();
        String SQL = "select * from "+ class_view + " limit "+(current_page-1)*page_size+" , "+page_size;
        ResultSet resultSet = JDBCHelper.query(SQL);
        Clazz clazz;
        try {
            while(resultSet.next()){
                clazz = new Clazz();
                clazz.setCno(resultSet.getString("cno"));
                clazz.setProfession(resultSet.getString("profession"));
                clazz.setTotalPerson(Integer.parseInt(resultSet.getString("totalPerson")));
                clazzList.add(clazz);
            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clazzList;
    }

    /**
     * 按班级加载所有本班级学生
     * @param cno
     * @return
     */
    @Override
    public List<Student> loadAllStudentByCno(String cno,int current_page,int page_size) {
        List<Student> studentList = new ArrayList<Student>();
        String SQL = "select * from "+ student_view +" where cno = ? limit "+(current_page-1)*page_size+" , "+page_size;
        ResultSet rs = JDBCHelper.query(SQL,cno);
        Student student;
        try{
            while(rs.next()){
                student = new Student();
                student.setId(rs.getString("sno"));
                student.setCno(rs.getString("cno"));
                student.setPsd(rs.getString("psd"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setQQ(rs.getString("qq"));
                studentList.add(student);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return studentList;
    }

    /**
     *加载学生数量
     * @return
     */
    @Override
    public int loadTeacherNum() {
        int student_sum = 0;
        String SQL = "select count(*) from " + teacher_view;
        ResultSet rs = JDBCHelper.query(SQL);
        try{
            while (rs.next()){
                student_sum = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return student_sum;
    }

    /**
     * 加载所有教师信息
     * @return
     */
    @Override
    public List<Teacher> loadAllTeacherByPage(int current_page,int page_size) {
        List<Teacher> teachersList = new ArrayList<Teacher>();
        String SQL = "select * from " + teacher_view + " limit "+(current_page-1)*page_size+" , "+page_size;
        ResultSet rs = JDBCHelper.query(SQL);
        Teacher teacher;
        try{
            while (rs.next()){
                teacher = new Teacher();
                teacher.setId(rs.getString("tno"));
                teacher.setName(rs.getString("name"));
                teacher.setProfession(rs.getString("profession"));
                teacher.setPhone(rs.getString("phone"));
                teachersList.add(teacher);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teachersList;
    }

    /**
     * 根据教师编号加载信息
     * @param tno
     * @return
     */
    @Override
    public Teacher loadByTno(String tno) {
        String SQL = "select * from " + teacher_view + " where tno =?";
        Teacher teacher = new Teacher();
        ResultSet rs = JDBCHelper.query(SQL,tno);
        try{
            while(rs.next()){
                teacher.setId(rs.getString("tno"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setName(rs.getString("name"));
                teacher.setProfession(rs.getString("profession"));
                teacher.setQQ(rs.getString("qq"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public Boolean deleteByTno(String tno) {
        boolean b = false;
        String SQL = "delete from " + teacher_TableName + " where tno =?";
        b = JDBCHelper.execute(SQL,tno);
        return b;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        boolean b = false;
        String SQL = "insert into "+  teacher_TableName + " values(?,?,?,?,?,?)";
        b = JDBCHelper.execute(SQL,teacher.getId(),teacher.getPsd(),teacher.getName(),teacher.getPhone(),teacher.getQQ(),teacher.getProfession());
        return b;
    }
}
