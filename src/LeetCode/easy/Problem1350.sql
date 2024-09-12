--https://leetcode.com/problems/students-with-invalid-departments/description/
--Runtime
--678
--ms
--Beats
--92.97%
select distinct s.id, s.name
from students s
where s.department_id not in (
    select d.id
    from departments d
)