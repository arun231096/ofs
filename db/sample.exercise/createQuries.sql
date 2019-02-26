CREATE TABLE tr_patient_record (
    PRIMARY KEY (id),
    UNIQUE KEY (appointment_id),
    id              INT         AUTO_INCREMENT,
    appointment_id  VARCHAR(20) NOT NULL,
    patient_name    VARCHAR(60) NOT NULL,
    disease         VARCHAR(40) NOT NULL
);

DESC tr_patient_record;


CREATE TABLE tr_doctor_record (
    PRIMARY KEY (doctor_id),
    doctor_id       INT         AUTO_INCREMENT,
    doctor_name     VARCHAR(40) NOT NULL,
    specialist      VARCHAR(40) NOT NULL,
    room_number     INT         NOT NULL
);

ALTER TABLE tr_doctor_record AUTO_INCREMENT = 1001;

DESC tr_doctor_record;


CREATE TABLE tr_patient_service (
    PRIMARY KEY (service_id),
    service_id      INT         AUTO_INCREMENT,
    appointment_id  VARCHAR(20) NOT NULL,
    doctor_id       INT         NOT NULL,
    vist_time       VARCHAR(20) NOT NULL,
                    FOREIGN KEY (appointment_id)
                    REFERENCES tr_patient_record(appointment_id),
                    FOREIGN KEY (doctor_id)
                    REFERENCES tr_doctor_record(doctor_id)
);

ALTER TABLE tr_patient_service 
  ADD CONSTRAINT fk_appointment
      FOREIGN KEY(appointment_id)
      REFERENCES tr_patient_record(appointment_id);
    
ALTER TABLE tr_patient_service 
  ADD CONSTRAINT fk_doctor_id
      FOREIGN KEY(doctor_id)
      REFERENCES tr_doctor_record(doctor_id);


DESC tr_patient_service;

