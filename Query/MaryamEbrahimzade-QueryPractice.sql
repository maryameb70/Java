/*دانشجوهایی که تمام درس ها را پاس کرده اند*/
select * from student as s where NOT EXISTS
    (select c.id from course as c where c.id
    NOT IN
    (select sc.course_id from student_course as sc where sc.student_id=s.id));
/*درسهایی که توسط تمام دانشجویان پاس شده است*/
select * from course as c where NOT EXISTS
    (select s.id from student as s where s.id
    NOT IN
    (select sc.student_id from student_course as sc where sc.course_id=c.id));