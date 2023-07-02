--https://leetcode.com/problems/tree-node

--https://leetcode.com/problems/tree-node/solutions/3709534/mysql-2-unions-7-selects/
--25 min
--Runtime
--1253 ms
--Beats
--15.89%

select t.id, 'Root' as type
from tree t
where t.p_id is null
union
select t1.id, 'Leaf' as type
from tree t1
where t1.id not in (
	select t2.p_id
    from tree t2
    where t1.id = t2.p_id)
and t1.id <> (select t5.id from tree t5 where t5.p_id is null)
union
select t3.id, 'Inner' as type
from tree t3
where t3.id in (
	select t4.p_id
    from tree t4
    where t3.id = t4.p_id)
and t3.id <> (select t6.id from tree t6 where t6.p_id is null)