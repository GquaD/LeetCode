--https://leetcode.com/problems/product-sales-analysis-iii/description/

--https://leetcode.com/problems/product-sales-analysis-iii/solutions/3848357/mysql-return-all-sales-for-the-first-year-for-each-product/
--Runtime
--2385 ms
--Beats
--17.79%

select t.product_id, t.first_year, ss.quantity, ss.price
from sales ss, (select s.product_id, min(s.year) as first_year
from sales s
group by s.product_id) t
where ss.product_id = t.product_id
and ss.year = t.first_year