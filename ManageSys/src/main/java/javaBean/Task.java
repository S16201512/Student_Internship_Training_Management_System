package javaBean;

import java.util.List;

public class Task {
    private String Id="";
    private String taskName="";
    private String tno="";
    private List<T_file> task_file;
    private String task_content="";
    private String start_time="";
    private String end_time="";
    private String create_time="";
    private String task_staus="";
    private String submit="";//是否已发布
    private String grade="";
    private String isSubmit="";
    private String isScored="";

    public String getIsScored() {
        return isScored;
    }

    public void setIsScored(String isScored) {
        this.isScored = isScored;
    }

    public String getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public String getTask_staus() {
        return task_staus;
    }

    public void setTask_staus(String task_staus) {
        this.task_staus = task_staus;
    }

    public String getStart_time() {

        String  start_time1=start_time.substring(0,10);
        String start_time2=start_time.substring(11,19);


        this.start_time = start_time1+"T"+start_time2;
        this.start_time = start_time;
        return start_time;
    }

    public void setStart_time(String start_time) {

        this.start_time = start_time;
    }

    public String getEnd_time() {


            String  end_time1=end_time.substring(0,10);
            String end_time2=end_time.substring(11,19);


        this.end_time = end_time1+"T"+end_time2;

        return this.end_time;
    }

    public void setEnd_time(String end_time) {

        this.end_time = end_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public List<T_file> getTask_file() {
        return task_file;
    }

    public void setTask_file(List<T_file> task_file) {
        this.task_file = task_file;
    }

    public String getTask_content() {
        return task_content;
    }

    public void setTask_content(String task_content) {
        this.task_content = task_content;
    }
}
