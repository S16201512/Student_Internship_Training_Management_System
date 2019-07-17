package DBBean;

import dao.UserLoginDao;
import javaBean.User;
import util.JDBCHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLoginBean implements UserLoginDao {

    String student_view = "student_view";
    String admin_view = "admin_view";
    String teacher_view = "teacher_view";
    /**
     * 根据ID查询数据库
     * @param id
     * @param identity
     * @return
     */
    public User loadById(String id, String identity) {

        String sql;
        User u = null;
        if (identity.equals("admin")) {
            sql = "select ano , psd from "+admin_view+" where ano = " + id;
        } else if (identity.equals("teacher")) {
            sql = "select tno , psd from "+teacher_view+" where tno = " + id;
        } else {
            sql = "select sno , psd from "+student_view+" where sno = " + id;
        }


            ResultSet rs = JDBCHelper.query(sql);
            u = wrap(rs, identity);
        return u;
    }

    /**
     * 封装数据
     * @param rs
     * @param identity
     * @return
     */
    public User wrap(ResultSet rs, String identity) {
        User u = null;
        if (rs != null) {
            try {
                if (identity.equals("admin")) {
                    while (rs.next()) {
                        u = new User();
                        u.setId(rs.getString("ano"));
                        u.setPsd(rs.getString("psd"));
                    }
                } else {
                    if (identity.equals("teacher")) {
                        while (rs.next()) {
                            u = new User();
                            u.setId(rs.getString("tno"));
                            u.setPsd(rs.getString("psd"));
                        }
                    } else {
                        while (rs.next()) {
                            u = new User();
                            u.setId(rs.getString("sno"));
                            u.setPsd(rs.getString("psd"));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return u;
    }
}
