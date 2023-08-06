--https://leetcode.com/problems/find-customer-referee/

--3 min
--Runtime
--1168 ms
--Beats
--36.9%
select name
from customer
where referee_id is null
or referee_id <> 2