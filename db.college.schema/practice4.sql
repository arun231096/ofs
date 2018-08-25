-- List Employees details from a particular university
 
 SELECT detail.un AS University, detail.cname AS `College Name`, detail.udn AS Department, emp.`name` AS `Faculty Name`, desig.`name` AS `Designation`, desig.rank AS `Rank` FROM employee AS emp, designation AS desig
  JOIN (SELECT univ.univ_code AS uc, univ.university_name AS un, ud.dept_name AS udn, clg.id AS cid ,cd.cdept_id AS cdid,clg.`name` AS cname FROM college AS clg, (SELECT univ_code, university_name FROM university
                                WHERE university_name = 'ANNA UNIVERSITY' ) AS univ
                                 JOIN department AS ud
                                 JOIN college_department AS cd
 WHERE clg.univ_code = univ.univ_code AND ud.univ_code=univ.univ_code AND cd.college_id=clg.id AND cd.udept_code = ud.dept_code) AS detail
 WHERE emp.college_id = detail.cid AND emp.cdept_id=detail.cdid AND emp.desig_id=desig.id
ORDER BY detail.cname ASC,desig.rank ASC
