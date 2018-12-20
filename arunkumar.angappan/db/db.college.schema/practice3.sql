 -- Select students details who are studying under a particular university and selected cities alone
 
SELECT stud.rollnumber, stud.`name`, stud.gender, stud.dob, stud.email, stud.phone, stud.address, detail.clg_name AS `college`, detail.udept AS `department`, detail.d_head AS HOD  
  FROM student AS stud,(SELECT cd.cdept_id AS dept, ud.dept_name AS udept, e.`name` AS d_head ,uc.c_name AS clg_name, uc.c_id AS cid  
                          FROM employee AS e, (SELECT c.`name` AS c_name, c.id AS c_id, c.city AS c_city, c.univ_code AS c_c, u.university_name AS un 
                                                 FROM college AS c
                                                 JOIN university AS u 
                                                   ON u.univ_code=c.univ_code
                                                WHERE c.city= 'Coimbatore' AND u.university_name= 'Anna University') AS uc
                          JOIN designation AS d
                          JOIN college_department AS cd
                          JOIN department AS ud
                         WHERE e.college_id = uc.c_id 
                           AND d.id=e.desig_id 
                           AND d.`name`='HOD' 
                           AND cd.cdept_id=e.cdept_id 
                           AND ud.dept_code=cd.udept_code) AS detail
 WHERE detail.cid = stud.college_id AND detail.dept=stud.cdept_id
 LIMIT 0,20