# Write your MySQL query statement below
#solution for https://leetcode.com/problems/recyclable-and-low-fat-products/
select p.product_id
from products p
where p.low_fats = 'Y'
  and p.recyclable = 'Y'