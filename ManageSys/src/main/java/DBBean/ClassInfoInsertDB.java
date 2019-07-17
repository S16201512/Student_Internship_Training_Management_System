package DBBean;

import dao.ClassInfoInsertDao;
import jdk.nashorn.internal.scripts.JD;
import util.JDBCHelper;

import java.util.ArrayList;

public class ClassInfoInsertDB implements ClassInfoInsertDao {
    /**
     * 批量插入数据
     * @param arr
     * @return
     */
    public boolean classInfoInsert(ArrayList<ArrayList<String>> arr) {
        boolean flag = false;
        //后面的参数代表需要输出哪些列，参数个数可以任意
        String[] s = null;
        String cno="",sno="",profession="";
        String sql1 = "insert into t_tc(cno,tno) values( ? , ? )", sql2="update t_student set cno = ? where sno = ?",
        sql3 = "insert into t_class(cno,profession,totalPerson) values(?,?,?) ";
        for(int i=0;i<arr.size();i++){
            ArrayList<String> row=arr.get(i);
            //定义字符数组接收每一行的数据
            s = new String[2];
            for(int j=0;j<row.size();j++){
                if(j<2){
                    s[j]=row.get(j);
                    if(j==0){
                        cno=row.get(j);
                    }
                }else{
                    if(j==2){
                        sno=row.get(j);
                    }
                    if(j==3){
                        profession=row.get(j);
                    }
                }
            }
            if(i==0){
                flag=JDBCHelper.execute(sql1,s);
            }
            JDBCHelper.execute(sql2,cno,sno);
        }
        JDBCHelper.execute(sql3,cno,profession,arr.size());
        return flag;
    }
}
