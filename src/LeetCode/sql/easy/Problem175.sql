--https://leetcode.com/problems/combine-two-tables

--Runtime
--842 ms
--Beats
--69.22%
--5min

select p.firstName, p.lastName, a.city, a.state
from person p
left join address a on
  p.personId = a.personId