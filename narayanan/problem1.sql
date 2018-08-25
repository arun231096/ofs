-- Problem 1 
SELECT d.dept_code,d.univ_code, cd.college_id, c.name, e.name AS employee_name, ed.name As designation,u.university_name  
  FROM department AS d
		 JOIN college_department AS cd 
		   ON cd.udept_code = d.dept_code
		 JOIN college AS c 
		   ON c.id = cd.college_id
		 JOIN university AS u 
		   ON u.univ_code = c.univ_code
		 JOIN employee AS e 
		   ON e.dept_id = cd.cdept_id
		 JOIN designation AS ed 
		   ON ed.id = e.desg_id
		      WHERE dept_name = 'Computer Science' 
				    OR dept_name = 'Information Technology' HAVING (ed.name)='HOD'