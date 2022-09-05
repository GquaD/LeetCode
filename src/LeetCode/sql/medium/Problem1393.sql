--https://leetcode.com/problems/capital-gainloss/
-- 10 mins
--Runtime: 681 ms, faster than 40.48% of MySQL online submissions for Capital Gain/Loss.
--Memory Usage: 0B, less than 100.00% of MySQL online submissions for Capital Gain/Loss.

select buy.stock_name, (sell.sell_sum - buy.buy_sum) as capital_gain_loss
from
(select stock_name, sum(price) as buy_sum
    from stocks
    where operation = 'Buy'
    group by stock_name) as buy,
(select stock_name, sum(price) as sell_sum
    from stocks
    where operation = 'Sell'
    group by stock_name) as sell
where buy.stock_name = sell.stock_name
