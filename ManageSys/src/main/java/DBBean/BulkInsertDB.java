package DBBean;

import dao.BulkInsertDao;
import util.JDBCHelper;
import java.util.ArrayList;

public class BulkInsertDB implements BulkInsertDao {

    /**
     * 批量插入数据
     * @param arr
     * @param type
     * @return
     */
    public boolean bulkInsert(ArrayList<ArrayList<String>> arr,String type) {
        boolean flag = false;
        //后面的参数代表需要输出哪些列，参数个数可以任意
        String[] s = null;
        String sql = null;
        if("teacher".equals(type)){
            sql = "insert into t_teacher(tno,psd,name,phone,qq,profession) values( ? , ? , ? , ? , ? , ? )";
        }else{
            sql = "insert into t_student(sno,psd,name,phone,qq) values( ? , ? , ? , ? , ? )";
        }
        for(int i=0;i<arr.size();i++){
            ArrayList<String> row=arr.get(i);
            //定义字符数组接收每一行的数据
            s = new String[row.size()];
            for(int j=0;j<row.size();j++){
                s[j]=row.get(j);
            }
            if(JDBCHelper.execute(sql,s)){
                flag = true;
            }
        }
        return flag;
    }
}
