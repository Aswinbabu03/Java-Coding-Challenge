create database carrierhub;
use carrierhub;
-- drop database carrierhub;

create table companies
(companyid int primary key,
companyname varchar(30),
location varchar(30)
);

insert into companies values
(1001,'hexawre','coimbatore');

insert into companies values
(1002,'rently','chennai');

insert into companies values
(1003,'accenture','banglore');

insert into companies values
(1004,'tata','coimbatore');

insert into companies values
(1005,'avasoft','mumbai');


create table jobs
(jobid int primary key,
companyid int,
jobtitle varchar(30),
jobdesc text,
joblocation varchar(30),
salary decimal(10,2),
jobtype varchar(30),
posteddate datetime,
foreign key (companyid) references companies(companyid)
);

insert into jobs values
(101 ,1001, 'software developer','develop software applications','coimbatore',10000.00,'full-time','2020-01-05');

insert into jobs values
(102 ,1002, 'tester','develop software applications','chennai',8000.00,'full-time','2020-02-026');

insert into jobs values
(103 ,1003, 'software developer','develop software applications','chennai',9000.00,'full-time','2021-05-05');

insert into jobs values
(104 ,1003, 'finance analyst','analyse financial date','delhi',12000.00,'full-time','2021-07-15');

insert into jobs values
(105 ,1004, 'fullstack developer','develop fullstack applications','coimbatore',15000.00,'full-time','2020-11-12');

create table applicants
(applicantid int primary key,
firstname varchar(30),
lastname varchar(30),
email varchar(30),
phone varchar(30),
resume text,
hiredate datetime,
city varchar(20),
state varchar(30)
);

insert into applicants values
(1,'arun','s','arun123@gmail.com',9865881645,'/path/to/resume/arun_resume.pdf','2017-02-05','chennai','tamilnadu');

insert into applicants values
(2,'aswin','s','aswin123@gmail.com',9965881645,'/path/to/resume/aswin_resume.pdf','2015-07-23','coimbatore','tamilnadu');

insert into applicants values
(3,'aravindh','g','aravindh123@gmail.com',9365881645,'/path/to/resume/aravindh_resume.pdf','2014-07-15','mumbai','maharasthra');

insert into applicants values
(4,'sherin','v','sherin123@gmail.com',9864581645,'/path/to/resume/sherin_resume.docx','2018-08-12','coimbatore','tamilnadu');

insert into applicants values
(5,'shuba','a','shuba123@gmail.com',6465881645,'/path/to/resume/shuba_resume.pdf','2015-08-10','chennai','tamilnadu');

create table applications
(applicationid int primary key,
jobid int,
applicantid int,
applicationdate datetime,
coverletter text,
foreign key (jobid) references jobs(jobid),
foreign key(applicantid) references applicants(applicantid)
);

insert into applications values
(15,101,1,'2023-05-01','/path/to/coverletter/arun_coverletter.pdf');

insert into applications values
(16,102,2,'2023-04-03','/path/to/coverletter/aswin_coverletter.pdf');

insert into applications values
(17,103,3,'2023-06-20','/path/to/coverletter/aravindh_coverletter.docx');

insert into applications values
(18,104,4,'2023-01-01','/path/to/coverletter/sherin_coverletter.docx');

insert into applications values
(19,105,5,'2013-05-01','/path/to/coverletter/shuba_coverletter.pdf');

--------------
-- 5)Write an SQL query to count the number of applications received for each job listing in the
-- "Jobs" table. Display the job title and the corresponding application count. Ensure that it lists all
-- jobs, even if they have no applications.
select j.jobid,j.jobtitle,count(a.applicationid) as application_count
from jobs j
join applications a on j.jobid = a.jobid
group by
    j.jobid, j.jobtitle;
------------------------------------
-- 6)Develop an SQL query that retrieves job listings from the "Jobs" table within a specified salary
-- range. Allow parameters for the minimum and maximum salary values. Display the job title,
-- company name, location, and salary for each matching job.
select j.jobtitle,c.companyname,j.joblocation,j.salary
from jobs j
join companies c on j.companyid = c.companyid
where
    j.salary between 8000.00 and 13000.00;
-------------------------------------------
-- 7)Write an SQL query that retrieves the job application history for a specific applicant. Allow a
-- parameter for the ApplicantID, and return a result set with the job titles, company names, and
-- application dates for all the jobs the applicant has applied to.
select j.jobtitle,c.companyname,a.applicationdate
from applications a
join jobs j on a.jobid = j.jobid
join companies c on j.companyid = c.companyid
where a.applicantid = 2;

-- 8)Create an SQL query that calculates and displays the average salary offered by all companies for
-- job listings in the "Jobs" table. Ensure that the query filters out jobs with a salary of zero.
select avg(jobs.salary) as average_salary 
from jobs
where jobs.salary>0;
--------------------------------------
-- 9)Write an SQL query to identify the company that has posted the most job listings. Display the
-- company name along with the count of job listings they have posted. Handle ties if multiple
-- companies have the same maximum count.
select c.companyname,count(j.jobid) as job_count
from companies c
join jobs j on c.companyid = j.companyid
group by c.companyid, c.companyname
order by job_count desc
limit 1;
------------------------------------------
-- 10)Find the applicants who have applied for positions in companies located in 'CityX' and have at
-- least 3 years of experience.
select a.applicantid,a.firstname,a.lastname,a.email,a.phone,a.resume
from applicants a
join applications app on a.applicantid = app.applicantid
join jobs j on app.jobid = j.jobid
join companies c on j.companyid = c.companyid
where c.location = 'coimbatore' and timestampdiff(year, a.hiredate, curdate()) >= 3;
-----------------------------
-- 11)Retrieve a list of distinct job titles with salaries between $10000 and $20000.
select distinct jobtitle,salary
from jobs
where salary between 10000 and 20000;
-----------------------------------
-- 12)Find the jobs that have not received any applications.
select j.jobid,j.jobtitle,j.companyid,j.jobdesc,j.joblocation,j.salary,j.jobtype,j.posteddate
from jobs j
join applications a on j.jobid = a.jobid
where a.applicationid is null;
------------------------------------
-- 13)Retrieve a list of job applicants along with the companies they have applied to and the positions they have applied for.
select a.applicantid,a.firstname,a.lastname,c.companyname,j.jobtitle
from applicants a
join applications app on a.applicantid = app.applicantid
join jobs j on app.jobid = j.jobid
join companies c on j.companyid = c.companyid;
---------------------------------------------
-- 14)Retrieve a list of companies along with the count of jobs they have posted, even if they have not received any applications.
select c.companyid,c.companyname,count(j.jobid) as job_count
from companies c
join jobs j on c.companyid = j.companyid
join applications a on j.jobid = a.jobid
group by c.companyid, c.companyname;
----------------------------------------------
-- 15)List all applicants along with the companies and positions they have applied for, including those who have not applied.
select a.applicantid,a.firstname,a.lastname,c.companyname,j.jobtitle
from applicants a
join applications app on a.applicantid = app.applicantid
join jobs j on app.jobid = j.jobid
join companies c on j.companyid = c.companyid;
--------------------------------------
-- 16)Find companies that have posted jobs with a salary higher than the average salary of all jobs.
select distinct c.companyid,c.companyname
from companies c
join jobs j on c.companyid = j.companyid
where j.salary > (select avg(salary) from jobs);-- avg sal=10800
----------------------------------------
-- 17)Display a list of applicants with their names and a concatenated string of their city and state.
select
    applicantid,
    concat(firstname, ' ', lastname) as full_name,
    concat(city, ', ', state) as location
from
    applicants;
--------------------------------
-- 18)Retrieve a list of jobs with titles containing either 'soft ware developer' or 'tester'.
select jobid,jobtitle,companyid,jobdesc,joblocation,salary,jobtype,posteddate
from jobs
where
    (jobtitle ='software developer' or jobtitle='tester');
--------------------------------------- 
-- 19)Retrieve a list of applicants and the jobs they have applied for, 
-- including those who have not applied and jobs without applicants.
select a.applicantid,a.firstname,a.lastname,j.jobtitle
from applicants a
join jobs j
join applications app on a.applicantid = app.applicantid and j.jobid=app.jobid;
---------------------------------------------------
-- 20)List all combinations of applicants and companies where the company is in a specific city and the
-- applicant has more than 2 years of experience. For example: city=Chennai
select a.applicantid,a.firstname,a.lastname,c.companyid,c.companyname
from applicants a
join companies c
where
    c.location = 'Chennai'
    and timestampdiff(year, a.hiredate, curdate()) > 2;
------------------------------------------------------



