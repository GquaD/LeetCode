--https://leetcode.com/problems/employee-bonus

--2 min
--Runtime
--Details
--2541ms
--Beats 15.08%of users with MySQL
--Memory
--Details
---mb
--Beats 100.00%of users with MySQL

select e.name, b.bonus
from employee e
left join bonus b on
e.empId = b.empId
where b.bonus < 1000
or b.bonus is null