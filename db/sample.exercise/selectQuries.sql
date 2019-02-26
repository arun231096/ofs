
/* tr_doctor_record && tr_patient_record tr_patient_service - Reference tables for quries*/


/*  Hospital servicing list based on Aliase concept */

SELECT p.patient_name, d.doctor_name, s.vist_time 
  FROM tr_patient_record As p, 
       tr_doctor_record AS d, 
       tr_patient_service AS s
 WHERE s.appointment_id = p.appointment_id AND s.doctor_id = d.doctor_id;

    
/*  Displaying the patient details and visiting time in service record using JOINS */

SELECT p.patient_name, p.disease, s.vist_time 
  FROM tr_patient_service AS s
  INNER JOIN tr_patient_record As p	
          ON s.appointment_id= p.appointment_id;


/* Filtering the doctor details based on patient appointment ID using sub query*/

SELECT doctor_id, doctor_name 
  FROM tr_doctor_record
 WHERE doctor_id = (SELECT doctor_id 
                      FROM tr_patient_service 
                     WHERE appointment_id = 'ABC1234');
    

/* Displaying the doctor details who have attend patient list using joins (SELECT * FROM tr_doctor_record SELECT *FROM tr_patient_service)*/

SELECT s.appointment_id, p.patient_name, p.disease, d.doctor_id, d.doctor_name, d.specialist
  FROM ((tr_patient_service AS s
         LEFT JOIN tr_doctor_record AS d
           ON s.doctor_id = d.doctor_id)
         RIGHT JOIN tr_patient_record AS p 
            ON s.appointment_id = p.appointment_id);


/* Getting count of patients who have got treatment suceessfully */

SELECT COUNT(appointment_id) 
  FROM tr_patient_service;


/* Getting total count of patient visits hospital */

SELECT COUNT(appointment_id) 
  FROM tr_patient_record;


/* geting count of patients who have not taken treatment from the doctor */

SELECT (
    (SELECT COUNT(appointment_id) 
       FROM tr_patient_record) -
    (SELECT COUNT(appointment_id) 
       FROM tr_patient_service));


/* Count of Doctors who have not attend the patients using and group by*/

SELECT (
    (SELECT COUNT(doctor_id)
       FROM tr_doctor_record) -
    (SELECT COUNT(*) AS doctor_count
       FROM (
       SELECT doctor_id FROM tr_patient_service
        GROUP BY doctor_id 
          HAVING COUNT(doctor_id) > 0
          ) AS t
    )
) AS doctor_not_service_to_patient;



/* Count of Doctors who have attend the patients Using count and Group by having*/

SELECT COUNT(*) AS doctor_count
  FROM (
    SELECT doctor_id FROM tr_patient_service
     GROUP BY doctor_id HAVING COUNT(doctor_id) > 0) AS t


/* get the Max count doctor visited patients, using Group by order by*/

SELECT s.doctor_id, d.doctor_name, COUNT(s.doctor_id) AS number_of_patients_attended
  FROM tr_patient_service AS s
  LEFT JOIN tr_doctor_record AS d ON s.doctor_id = d.doctor_id
 GROUP BY s.doctor_id
 ORDER BY COUNT(s.doctor_id) DESC
 LIMIT 1;
 
    
/* get the Max count 3 doctors visited how many patients, using Group by order by*/

SELECT s.doctor_id, d.doctor_name, COUNT(s.doctor_id) AS number_of_patients_attended
  FROM tr_patient_service AS s
  LEFT JOIN tr_doctor_record AS d ON s.doctor_id = d.doctor_id
 GROUP BY s.doctor_id
 ORDER BY COUNT(s.doctor_id) DESC
 LIMIT 3;

/* Displaying Doctors id using UNION concepts just for trying union concepts, it is not applicable for hospital management process */

SELECT doctor_id FROM tr_patient_service
 UNION ALL
SELECT doctor_id FROM tr_doctor_record;


SELECT doctor_id FROM tr_patient_service
 UNION DISTINCT
SELECT doctor_id FROM tr_doctor_record;

/* Average patients count in hospital SELECT *FROM tr_patient_record*/

SELECT AVG(id) 
  FROM tr_patient_record;


/* Displaying first 3 patients details order by alphabets */

SELECT appointment_id, patient_name 
  FROM tr_patient_record
 ORDER BY patient_name ASC 
 LIMIT 0,3;









