package dao;

import javaBean.T_registration;
import javaBean.Teacher;

import java.util.List;

public interface TeacherDao {
    public Teacher loadByTno(String tno);
    public boolean updatePsdByTno(String tno, String new_psd);
    public boolean updateInfo(String tno, String name, String phone, String qq, String profession);
    public String loadPsdByTno(String tno);

    public List<T_registration> loadAllRegistration();
}
