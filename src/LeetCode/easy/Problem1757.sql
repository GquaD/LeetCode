--https://leetcode.com/problems/recyclable-and-low-fat-products

--1min
--Runtime
--796
--ms
--Beats
--75.38%
--Write your MySQL query statement below
select product_id
from products
where low_fats = 'Y'
and recyclable = 'Y'