--https://leetcode.com/problems/find-total-time-spent-by-each-employee/submissions/

--Runtime: 551 ms, faster than 61.13% of MySQL online submissions for Find Total Time Spent by Each Employee.
--Memory Usage: 0B, less than 100.00% of MySQL online submissions for Find Total Time Spent by Each Employee.
Select e.event_day as day, e.emp_id, sum(e.out_time - e.in_time) as total_time
from employees e
GROUP BY e.event_day, e.emp_id