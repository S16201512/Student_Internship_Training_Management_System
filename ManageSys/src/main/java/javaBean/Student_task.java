package javaBean;

import java.util.List;

public class Student_task extends Task {
    private String studentNo="";
    private String studentName="";
    private String submit_time="";
    private List<T_file> submit_file;
    private String answer="";
    private String cno="";
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<T_file> getSubmit_file() {
        return submit_file;
    }

    public void setSubmit_file(List<T_file> submit_file) {
        this.submit_file = submit_file;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(String submit_time) {
        this.submit_time = submit_time;
    }
}
