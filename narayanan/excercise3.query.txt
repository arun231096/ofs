Excercise 3 

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