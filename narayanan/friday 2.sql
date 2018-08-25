--Acquiring the records based on the given result set filtered with IT/CSE departments 
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
				    
--Displaying result set of students studying in particular college and selected city 				    
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
				  
				  
--PERFECT 				
SELECT de.rank,e.name ,c.name
  FROM designatiON AS de
		 JOIN employee AS e 
		   ON e.desg_id=de.id
		 JOIN college AS c 
		   ON c.id=e.college_id
		 JOIN university AS u 
		   ON u.univ_code = c.univ_code
				WHERE `university_name` = 'Anna University' 
						 ORDER BY c.name ASC, de.rank ASC
-- PERFECT 
		s.name,s.rollnumber,s.dob,s.gender,s.email,s.phone,s.address,c.name,d.dept_name, cd.cdept_id 		
				  
SELECT * FROM college_department

de.name,e.name,

(SELECT s.rollnumber, s.name, s.dob, s.gender, s.email, s.phone, s.address, c.name, d.dept_name
  FROM student AS s 
 	    JOIN college_department AS cd 
  	      ON cd.cdept_id = s.cdept_id
  		 JOIN department AS d 
         ON d.dept_code = cd.udept_code
  		 JOIN college AS c 
   	   ON c.id = s.college_id
  		 JOIN university AS u 
  		   ON u.univ_code = c.univ_code 
 			   WHERE   u.univ_code = 'ANUV'
  				  AND	 `city`='Coimbatore'	) 

SELECT s.name,s.rollnumber,s.dob,s.gender,s.email,s.phone,s.address,c.name,d.dept_name,de.name,e.name, cd.cdept_id FROM student as s 
JOIN college as c on c.id = s.college_id
JOIN university as u on u.univ_code = c.univ_code
JOIN department as d on d.univ_code= u.univ_code
JOIN college_department as cd on cd.udept_code = d.dept_code
JOIN employee as e on e.dept_id = cd.cdept_id
JOIN designation as de on de.id = e.desg_id AND de.name='HOD'
WHERE `university_name` = 'Anna University' AND `city`='Coimbatore'
LIMIT 0,20



SELECT u.university_name, c.name, c.city, de.name, e.name
 FROM university AS u
 		JOIN college AS c 
 	     ON c.univ_code = u.univ_code
 		JOIN department AS d 
 		  ON d.univ_code = u.univ_code
   	JOIN college_department AS cd 
  		  ON cd.cdept_id = d.dept_code
	   JOIN employee AS e.dept_id 
 		  ON cd.cdept_id
	   JOIN designation AS de 
     	  ON de.id = e.desg_id
  			  WHERE `university_name` = 'Anna University' 
			    AND `city`='Coimbatore'
			    
			    SELECT * FROM employee
			    
			    
SELECT s.rollnumber, s.name AS student_name, s.dob, s.gender, s.email, s.phone, s.address, c.name AS college_name, c.city
  FROM student AS s  	    
  		 JOIN college AS c 
   	   ON c.id = s.college_id
  		 JOIN university AS u 
  		   ON u.univ_code = c.univ_code 
  		   JOIN department AS d 
         ON  d.univ_code = u.univ_code
         JOIN college_department AS cd 
  	      ON cd.cdept_id = d.dept_code
  	      JOIN employee AS e ON e.dept_id = cd.cdept_id
  		 JOIN designation as de ON de.id = e.desg_id
 			   WHERE   u.univ_code = 'ANUV'	
  		 		  AND	 `city`='Coimbatore'	
			   	
			   	
			   	JOIN college_department AS cd 
  	      ON cd.cdept_id = s.cdept_id
  		 JOIN department AS d 
         ON d.dept_code = cd.udept_code