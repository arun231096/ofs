--new entries in SEMESTER_FEE table for each student from all the colleges and across all the universities. 
ALTER TABLE semester_fee
  ALTER paid_status SET DEFAULT 'Unpaid'

INSERT INTO semester_fee (stud_id,cdept_id, semester,amount)
VALUES (101,121,8,40000),
       (102,121,8,40000),
       (103,122,8,40000),
       (104,121,8,40000),
       (105,122,8,40000),
       (106,122,8,40000),
       (107,121,8,40000),
       (108,121,8,40000),
       (109,122,8,40000),
       (143,123,8,40000),
       (144,123,8,40000),
       (145,124,8,40000),
       (146,124,8,40000),
       (147,123,8,40000),
       (148,124,8,40000),
       (149,123,8,40000),
       (150,123,8,40000),
       (151,124,8,40000),
       (152,124,8,40000),
       (153,123,8,40000),
       (154,124,8,40000),
       (190,221,8,40000),
       (191,222,8,40000),
       (192,222,8,40000),
       (193,221,8,40000),
       (194,221,8,40000),
       (195,222,8,40000),
       (196,221,8,40000),
       (197,222,8,40000),
       (198,222,8,40000),
       (199,221,8,40000),
       (200,221,8,40000),
       (201,222,8,40000),
       (235,223,8,40000),
       (236,223,8,40000),
       (237,223,8,40000),
       (238,224,8,40000),
       (239,224,8,40000),
       (240,223,8,40000),
       (241,224,8,40000),
       (242,224,8,40000),
       (243,224,8,40000),
       (244,223,8,40000),
       (245,223,8,40000),
       (246,223,8,40000);
