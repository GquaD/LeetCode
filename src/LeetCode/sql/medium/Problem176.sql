--https://leetcode.com/problems/second-highest-salary

--30-40 mins
--Runtime
--861 ms
--Beats
--5.4%

select if(exists(select distinct e.salary as SecondHighestSalary
    from employee e
    order by e.salary desc
    Limit 1,1), (select distinct e.salary as SecondHighestSalary
    from employee e
    order by e.salary desc
    Limit 1,1), null) as SecondHighestSalary