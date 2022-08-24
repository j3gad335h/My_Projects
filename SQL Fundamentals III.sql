Select * from Q1 order by userid,created_date;

--Make new column for Created date
Alter table q1
add column created_date varchar(10);
update q1
set created_date=left(created,8);
--Convert string to Date
update q1
set created_date=to_date(created_date,'DD-MM-YY'); --to_date convert sting to date format but has string data type
--This is neccesary to use order by correctly
--Convert Varchar to date
alter table q1
alter column created_date type Date
using to_date(created_date,'YYYY_MM-DD');

create temporary table w0 as
select userid,min(DATE_PART('week',created_date)) as firstweek from q1
group by userid

Select * from w0
order by userid;

create temporary table all_weeks as
select userid,  DATE_PART('week',created_date) as login_week from q1
group by userid, login_week

select * from all_weeks order by userid

create temporary table week_diff as
select a.userid, a.login_week,b.firstweek,a.login_week - b.firstweek as week_number
from all_weeks a
inner join w0 b
on a.userid = b.userid

select * from week_diff

select firstweek,
       SUM(CASE WHEN week_number = 0 THEN 1 ELSE 0 END) AS week_0,
       SUM(CASE WHEN week_number = 1 THEN 1 ELSE 0 END) AS week_1,
       SUM(CASE WHEN week_number = 2 THEN 1 ELSE 0 END) AS week_2,
       SUM(CASE WHEN week_number = 3 THEN 1 ELSE 0 END) AS week_3,
       SUM(CASE WHEN week_number = 4 THEN 1 ELSE 0 END) AS week_4,
       SUM(CASE WHEN week_number = 5 THEN 1 ELSE 0 END) AS week_5,
       SUM(CASE WHEN week_number = 6 THEN 1 ELSE 0 END) AS week_6,
       SUM(CASE WHEN week_number = 7 THEN 1 ELSE 0 END) AS week_7,
       SUM(CASE WHEN week_number = 8 THEN 1 ELSE 0 END) AS week_8,
       SUM(CASE WHEN week_number = 9 THEN 1 ELSE 0 END) AS week_9,
	   SUM(CASE WHEN week_number = 10 THEN 1 ELSE 0 END) AS week_10
        
from week_diff
group by firstweek
order by firstweek
