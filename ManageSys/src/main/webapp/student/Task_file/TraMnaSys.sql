USE tramnasys;

CREATE VIEW student_view AS SELECT * FROM t_student;

CREATE VIEW teacher_view AS SELECT * FROM t_teacher;

CREATE VIEW admin_view AS SELECT * FROM t_admin;

CREATE VIEW file_view AS SELECT * FROM t_file;


CREATE VIEW studentTask_view AS SELECT * FROM student_task;

CREATE VIEW task_view AS SELECT * FROM task;

CREATE VIEW class_view AS SELECT * FROM t_class;

CREATE VIEW registration_view AS SELECT * FROM t_registration;

CREATE VIEW tc_view AS SELECT * FROM t_tc;

CREATE VIEW allstudent_studyplace_view AS SELECT city,tno FROM t_student,t_tc,t_registration 
                WHERE t_student.cno=t_tc.cno  AND t_student.sno=t_registration.rno;
               
CREATE VIEW allstudent_alltask_view AS SELECT sno, task.task_no,task_name,tno,task_content,start_time,end_time,grade,task_staus 
                FROM task,student_task 
                WHERE task.task_no=student_task.task_no;
 
 //每个老师可以批改的任务链表               
CREATE VIEW eachteacher_maycorrect_view AS SELECT DISTINCT task.task_no,task_name,tno,task_content,start_time,create_time,end_time 
                FROM task,student_task 
                WHERE task.task_no=student_task.task_no 
                AND task.submit=1 AND task_staus='已过期'
                
 //每个老师可以批改的每个任务对应的学生答案链表                  
CREATE VIEW eachteacher_eachtask_maycorrect_view AS SELECT task.task_no,task_name,t_student.sno,NAME,submit_time,grade
		FROM task,student_task,t_student,t_tc
		WHERE task.task_no=student_task.task_no
                AND task_staus='已过期' AND t_tc.tno=task.tno
                AND t_student.cno=t_tc.cno AND isSubmit=1 AND student_task.sno=t_student.sno;
                
 //每个班每个任务应当提交的人数统计       
CREATE VIEW eachclass_eachtask_totalpeople_view AS SELECT tno,task.task_no FROM task,student_task
                        WHERE task.task_no=student_task.task_no 
                        AND task.submit=1 AND task_staus='已过期';
                        
//每个班每个任务已经提交的人数统计                       
CREATE VIEW eachclass_eachtask_submitednum_view AS SELECT tno,task.task_no FROM task,student_task
                        WHERE task.task_no=student_task.task_no AND
                        task.submit=1 AND task_staus='已过期' AND isSubmit=1;
                        
                
//所有学生已提交任务答案链表           
CREATE VIEW allstudent_submitedtasklist_view 
		AS SELECT NAME,task_name,t_student.sno,student_task.task_no,t_student.cno,submit_content,submit_time,task_content FROM task,
                student_task,t_student 
                WHERE student_task.sno=t_student.sno
                AND student_task.task_no=task.task_no AND issubmit = 1;
                
                