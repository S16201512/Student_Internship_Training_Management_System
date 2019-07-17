package dao;

import javaBean.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentDao {
    public List<Student> massageSelect(String sno);

    public boolean massageUpdate(String sno, String psd);

    public  boolean registrationInfo(String rno, String province, String city, String company, String linkman, String linkmanphone);
    public ArrayList<String> loadLookBackPoint(String tno);
}
