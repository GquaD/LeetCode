--https://leetcode.com/problems/department-highest-salary/description/
--Runtime
--1620 ms
--Beats
--28.42%
--15 min


select d.name as Department, ee.name as Employee, t.salary as Salary
from employee ee, department d, (
  select max(e.salary) as salary, e.departmentId
  from employee e
  group by departmentId) t
where t.salary = ee.salary
and ee.departmentId = t.departmentId
and d.id = t.departmentId