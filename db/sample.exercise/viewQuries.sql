
/* Creating the view for important reconds handiling */

CREATE VIEW number_of_patient_visitedto_doctor AS
SELECT doctor_id, doctor_name 
  FROM tr_doctor_record
 WHERE doctor_id = (SELECT doctor_id 
                      FROM tr_patient_service 
                     WHERE appointment_id = 'ABC1234');

SELECT *FROM number_of_patient_visitedto_doctor;


/* creating the view  for Displaying the doctor details who have attend patient list*/

CREATE VIEW patient_and_doctor_details AS
SELECT s.appointment_id, p.patient_name, p.disease, d.doctor_id, d.doctor_name, d.specialist
  FROM ((tr_patient_service AS s
  LEFT JOIN tr_doctor_record AS d
    ON s.doctor_id = d.doctor_id)
  RIGHT JOIN tr_patient_record AS p 
	 ON s.appointment_id = p.appointment_id);

--SELECT *FROM patient_and_doctor_details;


/* creating the view for get the Max count 3 doctors visited how many patients*/

CREATE VIEW get_max3_patients_visited_by_doctor AS
SELECT s.doctor_id, d.doctor_name, COUNT(s.doctor_id) AS number_of_patients_attended
  FROM tr_patient_service AS s
  LEFT JOIN tr_doctor_record AS d ON s.doctor_id = d.doctor_id
 GROUP BY s.doctor_id
 ORDER BY COUNT(s.doctor_id) DESC
 LIMIT 3;

--SELECT *FROM get_max3_patients_visited_by_doctor;

