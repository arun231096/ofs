DESC tr_doctor_record;

INSERT INTO tr_doctor_record (doctor_name,specialist,room_number)
 VALUES ('Arunkumar', 'MBBS', 201),
        ('Gunasekaran', 'Nutrition', 202),
        ('Sriram Narayanan', 'Physiotherapy', 203),
        ('Kaviraj', 'Dentist', 203);

INSERT INTO tr_doctor_record (doctor_name,specialist,room_number)
 VALUES ('AK', 'MBBS', 204);

SELECT doctor_id,specialist FROM tr_doctor_record;

INSERT INTO tr_patient_record (appointment_id,patient_name,disease)
 VALUES ('ABC1234','Karthik','fever'),
        ('ABC1235','Karthikeyan','dental problem'),
        ('ABC1236','Karuthiruman','nutrition concern'),
        ('ABC1237','Sowndhar','Dengu Fever');

INSERT INTO tr_patient_record (appointment_id,patient_name,disease)
 VALUES ('ABC1238','Karthik kumar','physio'),
        ('ABC1239','Karthikeyan Naveen','physio'),
        ('ABC1240','K karthik','nutrition concern'),
        ('ABC1241','Sowndharrajan','Dengu Fever');

/*SELECT * FROM tr_patient_record;*/

INSERT INTO tr_patient_service (appointment_id,doctor_id,vist_time)
 VALUES ('ABC1234',1001,'12PM'),
        ('ABC1235',1004,'12.05PM'),
        ('ABC1236',1002,'12.30PM'),
        ('ABC1237',1001,'1.05PM'),
        ('ABC1238',1003,'1.45PM'),
        ('ABC1239',1003,'1.50PM'),
        ('ABC1240',1002,'2PM'),
        ('ABC1241',1001,'2.50PM');
    
    
   
/*SELECT *FROM tr_patient_service;*/