-- Update PAID_STATUS and PAID_YEAR in SEMESTER_FEE 

--a,c & d) Single Update - Update one student entry
UPDATE semester_fee
  SET paid_status = 'Paid',
      paid_year = 2018
 WHERE stud_id  =(SELECT id FROM student 
                   WHERE rollnumber = 'PPIT4001')
 
 
-- b,c & d) Bulk Update - Update multiple students entries
--- BETWEEN 104 AND 107 
 
 UPDATE semester_fee AS sf
  JOIN student AS stud ON sf.stud_id=stud.id AND stud.rollnumber BETWEEN 'PPIT4002' AND 'PPIT4005'
    SET paid_status = 'Paid',
        paid_year = 2018


 
 
