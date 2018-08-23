SELECT d.dept_name, d.univ_code, u.university_name, c.name, c.id , e.name, ed.name from department as d 
JOIN college_department As cd ON d.dept_code=cd.udept_code
JOIN college As c ON c.id=cd.college_id 
JOIN employee as e ON e.college_id = c.id
JOIN designation as ed ON ed.id=e.desg_id
JOIN university As u ON u.univ_code = c.univ_code
WHERE d.dept_name = 'Computer Science'  AND e.college_id = c.id
group by e.college_id

 select e.id,e.desg_id,e.name, d.name from employee AS e 
 join designation as d on d.id=e.desg_id
 where e.college_id = 223
 

select d.dept_code,d.dept_name, c.id, u.university_name,e.name,e.id,ed.name, e.desg_id from department As d
join college_department as cd on cd.udept_code=d.dept_code
join college as c on c.id=cd.college_id
join university as u on u.univ_code=c.univ_code
join employee as e on e.cdept_id=cd.cdept_id
join designation as ed on ed.id=e.desg_id
where dept_name = 'Computer Science' OR dept_name = 'Information Technology' having ed.name='HOD'
 
 
 select *from designation