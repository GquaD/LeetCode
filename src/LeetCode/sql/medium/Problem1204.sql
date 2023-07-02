--https://leetcode.com/problems/last-person-to-fit-in-the-bus

--https://leetcode.com/problems/last-person-to-fit-in-the-bus/solutions/3709723/mysql-using-sum-over/
--15-20 min
--Runtime
--1680 ms
--Beats
--72.83%
select t.person_name
from (
	select q.person_name, sum(q.weight) over (order by q.turn) as cum_sum
	from queue q) t
where t.cum_sum <= 1000
order by t.cum_sum desc
limit 1

