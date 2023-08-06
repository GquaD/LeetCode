--https://leetcode.com/problems/nth-highest-salary/description/
--30-35min

--Runtime
--830 ms
--Beats
--47.78%
create function getNthHighestSalary(N int) RETURNS INT
BEGIN
    set N = N - 1;
  RETURN (
    select if(N < 0, null, (select distinct salary
      from employee
      order by salary desc
      limit N,1))
  );
END;