--1-Highest math score student
Select s.firstname,s.lastname,s.math_score from dbo.tbl_students s where math_score=(SELECT max(math_score) as 'Highest math score'
FROM  dbo.tbl_students)
----
--2-Select students with average :( math+ chemistry)/2
select s.firstname+' '+s.lastname as 'fullname',(s.math_score+s.chemistry_score)/2 as 'average'
from dbo.tbl_students s
group by s.firstname,s.lastname
--3-Select grades by average math number
select s.grade,AVG(s.math_score) as 'math_average'
from dbo.tbl_students s
group by s.grade
--4-select students from grade a where math_grade is bigger than 15,ascending.
select * 
from dbo.tbl_students s
where s.grade='A' and s.math_score>15
ORDER BY s.math_score DESC
--5-number of students in grade A.
select COUNT(s.grade) as 'number of students in grade A' 
from dbo.tbl_students s
where s.grade='A'
--6.find students which their first name contains “ali” .
select *
from dbo.tbl_students s
where s.firstname like '%ali%'
-------------------------------------
--Q1.query to fetch the EmpFname from the EmployeeInfo table in upper case and use the ALIAS 
select Upper(empI.EmpFname) as 'EmpName'
from dbo.EmployeeInfo empI
--Q2.query to fetch the number of employees working in the department ‘HR’.
select count(*) as 'number of employees working in the department ‘HR’'
from dbo.EmployeeInfo empI
where empI.Department='HR'
--Q3.query to get the current date.
SELECT CAST( GETDATE() AS Date) 
select Date(now())
--Q4.query to retrieve the first four characters of  EmpLname from the EmployeeInfo table
select SUBSTRING(empI.EmpLname,1,4) as 'first four characters of EmpLname'
from dbo.EmployeeInfo empI
--Q5.query to fetch only the place name(string before brackets) from the Address column of EmployeeInfo table.
SELECT SUBSTRING(Address, 0, CHARINDEX('(',Address)) FROM EmployeeInfo;
--Q6.query to create a new table which consists of data and structure copied from the other table.
SELECT *
INTO dbo.copyEmployeeInfo
FROM dbo.EmployeeInfo
--Q7.query to find all the employees whose salary is between 50000 to 100000.
select empI.EmpID,empI.EmpFname ,empI.EmpLname,empP.Salary
FROM dbo.EmployeeInfo empI INNER JOIN
dbo.EmployeePosition empP ON empI.EmpID=empP.EmpID
where empp.Salary>50000 and empP.Salary<100000
--Q8.query to find the names of employees that begin with ‘S’
select empI.EmpFname from dbo.EmployeeInfo empI
where empI.EmpFname like 'S%'
--Q9.query to fetch top N records.
select Top 1 *
from dbo.EmployeePosition empP
order by empP.Salary desc
--
select * from dbo.EmployeePosition limit 1
-----------------------
--Q10.query to retrieve the EmpFname and EmpLname in a single column as “FullName”. The first 
select empI.EmpFname +' '+empI.EmpLname as 'FullName'
from dbo.EmployeeInfo empI
--Q11.query find number of employees whose DOB is between 02/05/1970 to 31/12/1975 and 
select COUNT(*) as 'number of employees'
from dbo.EmployeeInfo empI
where empI.DOB>='1976-05-02' and empI.DOB<='1975-12-31'
--Q12.query to fetch all the records from the EmployeeInfo table ordered by EmpLname in descending order and Department in the ascending order.
SELECT * FROM dbo.EmployeeInfo ORDER BY EmpFname desc, Department asc
--Q13.query to fetch details of employees whose EmpLname ends with an alphabet ‘A’ and contains five alphabets.
SELECT * FROM dbo.EmployeeInfo WHERE EmpLname LIKE '____a'
select * from employ_info ei left join employe_Position ep
on ei.id=ep.id
where ei.empLname like '%a'
--Q14.query to fetch details of all employees excluding the employees with first names, “Sanjay” 
SELECT * FROM dbo.EmployeeInfo WHERE EmpFname='Sanjay'
--Q15.query to fetch details of employees with the address as “DELHI(DEL)”.
SELECT * FROM dbo.EmployeeInfo WHERE Address='DELHI(DEL)'
