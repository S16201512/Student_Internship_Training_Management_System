package DBBean;

import dao.TeacherDao;
import javaBean.T_registration;
import javaBean.Teacher;
import util.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * TeacherDB用于有关Teacher的数据库操作
 */
public class TeacherDB implements TeacherDao {
    String tableName="t_teacher";
    String registrationTableName = "t_registration";


    String teacher_view = " teacher_view ";
    String registration_view = " registration_view ";
    /**
     * 加载用户的旧密码
     * @param tno
     * @return
     */
    public String loadPsdByTno(String tno){
        String old_psd = null;
        String sql = "select psd from "+ teacher_view + " where tno = ?";
        ResultSet rs = JDBCHelper.query(sql,tno);
        try{
            while(rs.next()){
                old_psd = rs.getString(1);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  old_psd;
    }

    /**
     *
     * @return
     */
    @Override
    public List<T_registration> loadAllRegistration() {
        List<T_registration> registrationList = new ArrayList<T_registration>();
        String SQL = "select distinct city from " + registration_view;
        int i = 1;
        String Sql1 = "select count(*) as city from " + registration_view +" group by city";
        ResultSet rs = JDBCHelper.query(SQL);
        T_registration registration;
        try {
            while (rs.next()){
                registration = new T_registration();
                registration.setCity(rs.getString("city"));
                registrationList.add(registration);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        rs = JDBCHelper.query(Sql1 );
        try{
            while(rs.next()){
                registrationList.get(i-1).setCount(rs.getString(1));
                i=i+1;
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return registrationList;
    }

    /**
     * 用于修改个人信息
     * @param tno
     * @param new_psd
     * @return
     */
    @Override
    public boolean updatePsdByTno(String tno,String new_psd){
        boolean b = false;
        String sql = "update "+ tableName + " set psd = ? where tno = ?";
        b = JDBCHelper.execute(sql,new_psd,tno);
        return b;
    }

    @Override
    public boolean updateInfo(String tno, String name, String phone, String qq, String profession) {
        boolean b = false;
        String sql = "update " + tableName + " set name = ? , phone = ? , qq = ? , profession = ?  where tno=?";
        b = JDBCHelper.execute(sql,name,phone,qq,profession,tno);
        return b;
    }

    /**
     *
     * 用于根据教师编号个人信息的查询
     * @param tno
     * @return
     */
    @Override
    public Teacher loadByTno(String tno) {
        String sql = "select * from "+teacher_view+" where tno= ? " ;
        ResultSet rs = JDBCHelper.query(sql,tno);
        Teacher teacher = new Teacher();
        try{
            if(rs.next()){
                teacher.setId(tno);
                teacher.setName(rs.getString("name"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setProfession(rs.getString("profession"));
                teacher.setPsd(rs.getString("psd"));
                teacher.setQQ(rs.getString("qq"));
            }
            rs.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return teacher;
    }
}
