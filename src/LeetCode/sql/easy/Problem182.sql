--https://leetcode.com/problems/duplicate-emails
--3 min
--Runtime
--Details
--742ms
--Beats 79.65%of users with MySQL
--Memory
--Details
---mb
--Beats 100.00%of users with MySQL

select t.email
from (
  select p.email, count(p.email) as ecount
  from person p
  group by p.email ) t
where t.ecount > 1