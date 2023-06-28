
--https://leetcode.com/problems/the-latest-login-in-2020
--5-10min
--Runtime
--2287 ms
--Beats
--5.2%

select user_id, max(time_stamp) as last_stamp
from logins
where time_stamp >= '2020-01-01' and time_stamp < '2021-01-01'
group by user_id