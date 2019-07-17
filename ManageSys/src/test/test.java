import dao.Factory;
import dao.StudentDao;
import util.JDBCHelper;

import java.sql.ResultSet;

public class test {
    public static void main(String[] args) throws  Exception{
        StudentDao sd= Factory.getFactory().getInstance(StudentDao.class);
        String SQL="select * from t_admin";
        ResultSet rs= JDBCHelper.query(SQL);
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }

    }

}
