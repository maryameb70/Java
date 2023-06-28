CREATE DATABASE org;
SHOW DATABASES;
USE org;

-- create worker table
CREATE TABLE Worker
(
    WORKER_ID    INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME   CHAR(25),
    LAST_NAME    CHAR(25),
    SALARY       INT(15),
    JOINING_DATE DATETIME,
    DEPARTMENT   CHAR(25)
);

INSERT INTO Worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT)
VALUES (001, 'Monika', 'Arora', 100000, '14-02-20 09.00.00', 'HR'),
       (002, 'Niharika', 'Verma', 80000, '14-06-11 09.00.00', 'Admin'),
       (003, 'Vishal', 'Singhal', 300000, '14-02-20 09.00.00', 'HR'),
       (004, 'Amitabh', 'Singh', 500000, '14-02-20 09.00.00', 'Admin'),
       (005, 'Vivek', 'Bhati', 500000, '14-06-11 09.00.00', 'Admin'),
       (006, 'Vipul', 'Diwan', 200000, '14-06-11 09.00.00', 'Account'),
       (007, 'Satish', 'Kumar', 75000, '14-01-20 09.00.00', 'Account'),
       (008, 'Geetika', 'Chauhan', 90000, '14-04-11 09.00.00', 'Admin');


-- create bonus table
CREATE TABLE Bonus
(
    WORKER_REF_ID INT,
    BONUS_AMOUNT  INT(10),
    BONUS_DATE    DATETIME,
    FOREIGN KEY (WORKER_REF_ID)
        REFERENCES Worker (WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Bonus
(WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE)
VALUES (001, 5000, '16-02-20'),
       (002, 3000, '16-06-11'),
       (003, 4000, '16-02-20'),
       (001, 4500, '16-02-20'),
       (002, 3500, '16-06-11');

-- create title table
CREATE TABLE Title
(
    WORKER_REF_ID INT,
    WORKER_TITLE  CHAR(25),
    AFFECTED_FROM DATETIME,
    FOREIGN KEY (WORKER_REF_ID)
        REFERENCES Worker (WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Title
(WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM)
VALUES (001, 'Manager', '2016-02-20 00:00:00'),
       (002, 'Executive', '2016-06-11 00:00:00'),
       (008, 'Executive', '2016-06-11 00:00:00'),
       (005, 'Manager', '2016-06-11 00:00:00'),
       (004, 'Asst. Manager', '2016-06-11 00:00:00'),
       (007, 'Executive', '2016-06-11 00:00:00'),
       (006, 'Lead', '2016-06-11 00:00:00'),
       (003, 'Lead', '2016-06-11 00:00:00');

/*Q-1. Write an SQL query to print details of the Workers who have joined in Feb�2014.*/
select * from worker where JOINING_DATE LIKE '2014-02%';
Select * from Worker where year(JOINING_DATE) = 2014 and month(JOINING_DATE) = 2;

/*Q-2. Write an SQL query to report duplicated rows  including counter:*/
select t.WORKER_TITLE, t.AFFECTED_FROM, count(t.WORKER_REF_ID) as 'count' from title t
group by t.WORKER_TITLE, t.AFFECTED_FROM;

/*Q-3. Write an SQL query to clone a new table from worker table and call it update_worker. And add 5 new records to it. And remove first 3 rows.*/
CREATE TABLE new_worker
SELECT *
FROM worker;
/*update*/
update new_worker
set FIRST_NAME ='Asma',
    LAST_NAME='Amiri',
    SALARY='300000'
where WORKER_ID = 1;
/*add*/
insert into new_worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT)
values (9, 'Maryam', 'Ebrahimzade', 800000, '2014-02-20 09:00:00', 'HR'),
       (10, 'Arezo', 'Alipanah', 800000, '2014-06-11 09:00:00', 'HR'),
       (11, 'Zahra', 'Amini', 300000, '2014-04-11 09:00:00', 'HR'),
       (12, 'Ali', 'Alavi', 200000, '2014-01-20 09:00:00', 'Account'),
       (13, 'Reza', 'Omidi', 80000, '2014-02-20 09:00:00', 'Account');
/*delete*/
delete
from new_worker
where WORKER_ID IN (11, 12, 13);

/*Q-4. Write an SQL query to fetch common rows of new_worker table and worker table.*/
select * from worker inner join new_worker nw on worker.WORKER_ID = nw.WORKER_ID;

/*Q-5. Write an SQL query to show records from table new_worker that worker table does not have.*/
select * from new_worker nw
where NOT EXISTS(select * from worker w where w.WORKER_ID = nw.WORKER_ID);

/*Q-6. Write an SQL query to determine the nth (say n=5) highest salary from a table.*/
select * from worker w order by w.SALARY desc LIMIT 4,1;

/*Q-7.Write an SQL query to fetch the first 50% records from worker table.*/
SELECT * FROM WORKER WHERE WORKER_ID <= (SELECT count(WORKER_ID)/2 from Worker);
select ROW_NUMBER() over (order by  WORKER_ID desc) cd from worker;

select WORKER_ID, FIRST_NAME, LAST_NAME from (select *,count(*) over(partition by (select 1)) all_count
              , row_number() over(order by WORKER_ID)rn from worker)d
where rn <= all_count / 2;

/*Q-8.Write an SQL query to fetch the departments that have less than five people in it.*/
select DEPARTMENT from worker
group by DEPARTMENT
having count(DEPARTMENT) < 5;

/*Q-9.Write an SQL query to print the name of employees having the highest salary in each department.*/
select * from worker
where SALARY IN (
    SELECT Max(SALARY) from worker group by DEPARTMENT
)ORDER BY SALARY desc ;

