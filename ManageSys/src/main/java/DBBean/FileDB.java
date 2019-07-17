package DBBean;

import dao.FileDao;
import javaBean.T_file;
import util.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
create table t_file(fno int auto_increment primary key,
        filename varchar(100),
        filetype varchar(30),
        time varchar(100)
        );
*/
public class FileDB implements FileDao {

    String file_table = " t_file ";

    String file_view = " file_view ";
    public String insertFile(String filename,String fileType){
        System.out.println("DBfilename"+filename+"," +
                "fileType"+fileType);
        String SQL="insert into "+file_table+"(filename,filetype,time) values(?,?,?)";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currenttime=df.format(new Date());
        JDBCHelper.execute(SQL,filename,fileType,currenttime);
        String fno=LoadByTime(currenttime).getFno();
        return fno;
    }

    /**
     * 根据文件创建时间加载文件
     * @param currenttime
     * @return
     */
    public T_file LoadByTime(String currenttime){
        String SQL="select * from "+file_view+" where time='"+currenttime+"'";
        System.out.println("currenttime"+currenttime);
        ResultSet rs=JDBCHelper.query(SQL);
        T_file tf=null;

        try {
            while(rs.next()){
                tf=new T_file();
                tf.setFilename(rs.getString("filename"));
                tf.setFno(rs.getString("fno"));
                tf.setFileTyle(rs.getString("filetype"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }

        return tf;
    }
    /**
     * 根据文件fno来加载文件
     */
    public T_file LoadByNo(String fno){
        String SQL="select * from "+file_view+" where fno=?";
        ResultSet rs=JDBCHelper.query(SQL,Integer.parseInt(fno));
        T_file tf=null;

        try {
            while(rs.next()){
                tf=new T_file();
                tf.setFilename(rs.getString("filename"));
                tf.setFno(rs.getString("fno"));
                tf.setFileTyle(rs.getString("filetype"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }

        return tf;
    }

    @Override
    public boolean insertFile1(String submittedFileName, String fileType, String task_no, String sno) {
        String SQL="insert into "+file_table+"(filename,filetype,time,task_no,owe_perNo) values(?,?,?,?,?)";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currenttime=df.format(new Date());
        return JDBCHelper.execute(SQL,submittedFileName,fileType,currenttime,task_no,sno);

    }
    /**
     * 根据任务ID，学生号来更新文件
     */
    public boolean updateFile(String submittedFileName, String fileType, String task_no, String sno) {
        String SQL="update  "+file_table+" set filename?,filetype=?  where task_no=? and sno=?";

        return JDBCHelper.execute(SQL,submittedFileName,fileType,task_no,sno);

    }

    /**
     * 根据任务ID号加载文件列表
     */
    public List<T_file> loadByTask_no(String task_no){
        ArrayList<T_file> fileList=new ArrayList<>();
        String SQL="select * from "+file_view+" where  task_no = ? and owe_perNo not like ?";
        ResultSet rs=JDBCHelper.query(SQL,task_no,"1620%");
        try {
            while(rs.next()){
                T_file file=new T_file();
                file.setFno(rs.getString("fno"));
                file.setFileTyle(rs.getString("filetype"));
                file.setFilename(rs.getString("filename"));
                file.setOwe_perNo(rs.getString("owe_perNo"));
                file.setTask_no(rs.getString("task_no"));
                fileList.add(file);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fileList;
    }
    /**
     * 加载学生提交作业的附件
     */
    public List<T_file> loadStudentSubmitTaskFile(String sno,String task_no){
        String SQL="select * from "+file_view+" where task_no=? and owe_perNo=?";
        ResultSet rs=JDBCHelper.query(SQL,task_no,sno);
        List<T_file> fileList=new ArrayList<>();
        try {
            while(rs.next()){
                T_file file=new T_file();
                file.setFno(rs.getString("fno"));
                file.setFileTyle(rs.getString("filetype"));
                file.setFilename(rs.getString("filename"));
                file.setOwe_perNo(rs.getString("owe_perNo"));
                file.setTask_no(rs.getString("task_no"));
                fileList.add(file);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  fileList;
    }


    /**
     * 根据任务号和所属人号删除文件表中的文件
     * @param task_no
     * @param tno
     * @return
     */
    @Override
    public boolean deleteFileByTaskNoAndTno(String task_no, String tno) {
        String SQL = "delete from "+file_table+ " where task_no = ? and owe_perNo = ?";
        return JDBCHelper.execute(SQL,task_no,tno);
    }
}
