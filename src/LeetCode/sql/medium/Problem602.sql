--https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends

--https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/solutions/3682479/mysql-2-selects-1-union/
--40 min union vs union all since union (takes only unique rows)
--Runtime
--690 ms
--Beats
--19.41%
select t.id, sum(t.num) as num
from
(select  r.accepter_id as id, count(r.accepter_id) as num
from requestaccepted r
group by id
union
select  rr.requester_id as id, count(rr.requester_id) as num
from requestaccepted rr
group by id) t
group by id
order by num desc
limit 1

--select a.id, a.num + b.num as num
--from
--(select  r.accepter_id as id, count(r.accepter_id) as num
--from requestaccepted r
--group by id
--order by num desc) a,
--(select  rr.requester_id as id, count(rr.requester_id) as num
--from requestaccepted rr
--group by id
--order by num desc) b
--where a.id = b.id


--select a.id, ifnull(a.num, 0) + ifnull(b.num, 0) as num
--from
--(select  r.accepter_id as id, count(r.accepter_id) as num
--from requestaccepted r
--group by id
--order by num desc) a,
--(select  rr.requester_id as id, count(rr.requester_id) as num
--from requestaccepted rr
--group by id
--order by num desc) b
--order by num desc
--limit 1

