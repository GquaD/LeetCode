--https://leetcode.com/problems/game-play-analysis-i/description/
--2min
--Runtime
--Details
--765ms
--Beats 98.88%of users with MySQL
--Memory
--Details
---mb
--Beats 100.00%of users with MySQL


select player_id, min(event_date) as first_login
from activity
group by player_id