





SELECT s.rollnumber, s.`name`, shc.un, shc.c_city  FROM student AS s 
  JOIN(SELECT cd.udept_code AS c_dc,cd.cdept_id AS c_cd , c.id AS c_id, c.city AS c_city, c.univ_code AS c_c, u.university_name AS un FROM college AS c
         JOIN university AS u 
           ON u.univ_code=c.univ_code
         JOIN college_department AS cd
           ON cd.college_id = c.id
        WHERE c.city= 'Coimbatore') AS shc
    ON shc.c_id =s.college_id
  JOIN (SELECT e.`name` AS emp_name, e.college_id AS emp_cid , ed.`name` AS emp_desg FROM employee AS e
          JOIN designation AS ed ON ed.id = e.desig_id AND ed.`name`='HOD' ) AS she
            ON she.emp_cid=shc.c_id
  WHERE 
  
DESC employee

SELECT *FROM employee  AS e, designation AS d WHERE e.desig_id= d.id AND d.name= 'HOD'




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



SELECT * FROM college AS c
 WHERE c.univ_code= 'BHUV'
 
SELECT * FROM college AS clg, (SELECT univ_code, university_name FROM university
                                WHERE university_name = 'ANNA UNIVERSITY' ) AS univ
 WHERE clg.univ_code = univ.univ_code
 







