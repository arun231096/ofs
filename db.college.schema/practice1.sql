
-- Select College details which are having IT / CSC departments across all the universities.

SELECT c.`code`, c.`name`,u.university_name, c.city, c.state, c.year_opened, d.dept_name, e.`name`  
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
  ON ed.id = e.desig_id AND ed.`name`='HOD'
 WHERE dept_name = 'Computer Science' 
	OR dept_name = 'Information Technology' 