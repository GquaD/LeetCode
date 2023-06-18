--https://leetcode.com/problems/customers-who-bought-all-products
--15-20 min
--Runtime
--1082 ms
--Beats
--52.30%

select pp.customer_id
from (select count(distinct(p.product_key)) as pcount
      from product p) cc,
      (select c.customer_id, count(distinct(c.product_key)) as product_count
      from customer c
      group by c.customer_id) pp
where pp.product_count = cc.pcount