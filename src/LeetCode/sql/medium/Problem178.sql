--https://leetcode.com/problems/rank-scores/description/
--10 min using mysql workbench
--Runtime
--497 ms
--Beats
--87.57%
--https://leetcode.com/problems/rank-scores/solutions/3686863/mysql-double-nested-select-using-row-number-88-faster/

select ss.score, p.rank
from scores ss,
    (select t.score, row_number() over() as `rank`
    from
        (select distinct s.score
        from scores s
        order by s.score desc) t
    ) p
where ss.score = p.score
order by ss.score desc
