

-- Select College details which are having IT / CSC departments across all the universities.

SELECT d.dept_code,d.univ_code, cd.college_id, c.`name`, e.`name`, ed.`name`,u.university_name  
  FROM department AS d
		 JOIN college_department AS cd 
		   ON cd.udept_code = d.dept_code
		 JOIN college AS c 
		   ON c.id = cd.college_id
		 JOIN university AS u 
		   ON u.univ_code = c.univ_code
		 JOIN employee AS e 
		   ON e.cdept_id = cd.cdept_id
		 JOIN designation AS ed 
		   ON ed.id = e.desig_id
		      WHERE dept_name = 'Computer Science' 
				    OR dept_name = 'Information Technology' HAVING (ed.`name`)='HOD'
				    
-- Select final year students
		    
 SELECT s.name,s.rollnumber,s.gender,s.email,s.phone,s.address,c.name,d.dept_name,c.city,u.university_name
  FROM student AS s
		 JOIN college AS c 
		   ON c.id = s.college_id
		 JOIN college_department AS cd 
		   ON cd.cdept_id = s.cdept_id
		 JOIN department AS d 
		   ON d.dept_code = cd.udept_code
		 JOIN university AS u 
		   ON d.univ_code = u.univ_code
				WHERE `academic_year` = '2014' 
				  AND `university_name` = 'Anna university' 
				  AND c.city = 'Madurai'
              
 -- Select students details who are studying under a particular university and selected cities alone
 
SELECT stud.rollnumber, stud.`name`, stud.gender, stud.dob, stud.email, stud.phone, stud.address, detail.clg_name AS `college`, detail.udept AS `department`, detail.d_head AS HOD  
  FROM student AS stud,(SELECT cd.cdept_id AS dept, ud.dept_name AS udept, e.`name` AS d_head ,uc.c_name AS clg_name, uc.c_id AS cid  
                          FROM employee AS e, (SELECT c.`name` AS c_name, c.id AS c_id, c.city AS c_city, c.univ_code AS c_c, u.university_name AS un 
                                                 FROM college AS c
                                                 JOIN university AS u 
                                                   ON u.univ_code=c.univ_code
                                                WHERE c.city= 'Coimbatore') AS uc
                          JOIN designation AS d
                          JOIN college_department AS cd
                          JOIN department AS ud
                         WHERE e.college_id = uc.c_id AND d.id=e.desig_id AND d.`name`='HOD' AND cd.cdept_id=e.cdept_id AND ud.dept_code=cd.udept_code) AS detail
 WHERE detail.cid = stud.college_id AND detail.dept=stud.cdept_id
 LIMIT 0,20

 
 
 
 
 
 
 
 
 
 
 