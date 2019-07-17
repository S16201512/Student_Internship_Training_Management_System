package DBBean;

import dao.StudentDao;
import javaBean.Student;
import util.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDB implements StudentDao {



    String student_table = " t_student ";
    String registration_table = " t_registration ";

    String student_view = " student_view ";
    String registration_view = " registration_view ";
    String allstudent_studyplace_view = " allstudent_studyplace_view ";
    @Override
    //学生信息查询
    public List<Student> massageSelect(String sno){
        List<Student> studentList = new ArrayList<Student>() ;
        String SQL ="select * from "+student_view+" where sno = ?";
        ResultSet rs = JDBCHelper.query(SQL,sno);
       try {
           while (rs.next()) {
               Student student = new Student();
               student.setCno(rs.getString("cno"));
               student.setId(rs.getString("sno"));
               student.setPsd(rs.getString("psd"));
               student.setName(rs.getString("name"));
               student.setPhone(rs.getString("phone"));
               student.setQQ(rs.getString("qq"));
               studentList.add(student);
           }
       }catch(SQLException e){
           e.printStackTrace();
       }
        return studentList;
    }

    @Override
    //学生修改密码
    public boolean massageUpdate(String sno, String psd) {
        String SQl = "update "+student_table+" set psd = ? where sno = ?";
        return  JDBCHelper.execute(SQl,psd,sno);
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
    @Override
    public boolean registrationInfo(String rno, String province, String city, String company, String linkman, String linkmanphone) {
        String SQl = "insert into "+registration_table+" (rno,province,city,company,linkman,linkmanphone) VALUES(?,?,?,?,?,?)";
        return JDBCHelper.execute(SQl,rno,province,city,company,linkman,linkmanphone);
    }
    /**
     * 根据教师号加载该班全部的学生
     */
    public ArrayList<String> loadLookBackPoint(String tno){
        String SQL="select * from "+allstudent_studyplace_view+" where tno = ?";
        ResultSet rs=JDBCHelper.query(SQL,tno);
        ArrayList<String> pointList=new ArrayList<>();
        try {
            while (rs.next()){
                String point=rs.getString("city");
                pointList.add(point);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  pointList;
    }

}
