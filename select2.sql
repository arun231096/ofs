select s.rollnumber,s.name, s.gender,s.dob, s.phone,s.address, s.email, c.name, d.dept_name from student as s
join college As c On c.id=s.college_id  
join college_department as cd on cd.cdept_id=s.cdept_id
join department as d on d.dept_code=cd.udept_code
join university as u on u.univ_code=d.univ_code
where academic_year=2014 and c.city='Coimbatore' and u.university_name='Anna University'


