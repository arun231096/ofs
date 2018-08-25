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