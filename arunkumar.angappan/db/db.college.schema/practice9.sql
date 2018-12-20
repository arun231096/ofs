-- a) collected and uncollected semester fees amount per semester for each college under an university

SELECT clg.`name`, univ.university_name, sf.paid_status, SUM(sf.amount) AS Amount 
  FROM student AS stud, college AS clg, university AS univ , semester_fee AS sf
 WHERE sf.stud_id = stud.id
   AND sf.paid_status = 'Unpaid'
   AND sf.semester = 8
   AND stud.college_id = clg.id
   AND clg.univ_code = 'ANUV' 
   AND clg.`name` = 'ppg college'
 UNION ALL
SELECT clg.`name`, univ.university_name, sf.paid_status, SUM(sf.amount)  
  FROM student AS stud, college AS clg, university AS univ , semester_fee AS sf
 WHERE sf.stud_id = stud.id
  AND stud.college_id = clg.id
  AND sf.paid_year = 2018 
  AND sf.semester = 8
  AND clg.univ_code = 'ANUV' 
  AND clg.`name` = 'ppg college'
  
-- b) Collected semester fees amount for each university for the given year
  
SELECT SUM(amount) AS Collected_semester_fee, univ.university_name 
  FROM semester_fee   AS sf
  JOIN student AS stud 
    ON stud.id= sf.stud_id
  JOIN college AS clg 
    ON clg.id= stud.college_id
  JOIN university AS univ 
    ON univ.univ_code = clg.univ_code 
   AND univ.university_name = 'Anna University'
 WHERE paid_status= 'Paid'
   AND paid_year = 2018