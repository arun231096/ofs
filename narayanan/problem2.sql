-- Problem 2 
SELECT s.rollnumber, s.name AS student_name, s.dob, s.gender, s.email, s.phone, s.address, c.name AS college_name, d.dept_name, c.city
  FROM student AS s 
 	    JOIN college_department AS cd 
  	      ON cd.cdept_id = s.cdept_id
  		 JOIN department AS d 
         ON d.dept_code = cd.udept_code
  		 JOIN college AS c 
   	   ON c.id = s.college_id
  		 JOIN university AS u 
  		   ON u.univ_code = c.univ_code 
 			   WHERE  s.academic_year = '2014' 
  		 		  AND	 `city`='Coimbatore'	
			   	  AND u.univ_code = 'ANUV'	