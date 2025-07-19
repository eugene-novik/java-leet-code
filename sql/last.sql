EMPLOYEES
id  name	          department_id	hire_date	  salary
1	  Ivan Petrov	    1	            2018-05-10	70000
2	  Anna Ivanova	  2	            2019-09-20	80000
3	  Sergey Sidorov	1	            2017-03-15	90000
…	…	…	…	…

DEPARTMENTS
id	name
1	  IT
2	  HR
3	  Marketing

PROJECTS
id	name	        start_date	end_date
1	  Project Alpha	2023-01-01	2023-06-30
2	  Project Beta	2023-04-01	NULL

EMPLOYEE_PROJECTS
employee_id	project_id	role
1	          1	          Developer
2	          1	          Manager
3	          2	          Developer

TASK:
--1. List employee names and their department names for employees whose salary is greater than 75,000.
--2. Find the number of employees in each department.
--3. List projects that started in 2023 along with the number of employees working on each project.
4. For each employee, show their name, salary, and total number of projects they are involved in.
Sort the result by the number of projects in descending order.
--5. Find departments where the average employee salary is greater than 75,000.

--
select
  e.name, d.name as department_name
from EMPLOYEES e
inner join DEPARTMENTS d on e.department_id = d.id
where
e.salary > 75000;
--
SELECT
  d.name AS department_name, COUNT(e.id) AS number_of_employees
FROM departments d
LEFT JOIN employees e ON e.department_id = d.id
GROUP BY d.name;
--

select
  p.name as project_name, count(ep.employee_id) as number_of_employees
from projects p
left join  EMPLOYEE_PROJECTS ep on p.id = ep.project_id
where
p.start_date between '2023-01-01' and '2023-12-31'
group by p.name;
--

select e.name, e.salary, count(ep.project_id) as number_of_projects
from EMPLOYEES e
inner join EMPLOYEE_PROJECTS ep on e.id = ep.employee_id
group by e.name, e.salary
order by number_of_projects DESC;

--
select d.id as department_id, d.name as department_name
from DEPARTMENTS d
left join EMPLOYEES e on d.id = e.department_id
group by d.id, d.name
having AVG(e.salary) > 75000
