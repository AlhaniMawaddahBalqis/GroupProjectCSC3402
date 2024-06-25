-- Insert data into PHARMACIST table
INSERT INTO PHARMACIST (pharmacist_id, name, contact_no, email, password)
VALUES
    ('PMC0001', 'Hazani Suhairy', '0145322456', 'hazani@gmail.com', '$2a$10$aT6Rtz30GTg29C2/O7Ov.eEiuYzpO/SUm1Fb/46Yl153kgvXaHvPm'),
    ('PMC0002', 'Alhani Mawaddah', '0145322456', 'alhani@gmail.com', '$2a$10$aT6Rtz30GTg29C2/O7Ov.eEiuYzpO/SUm1Fb/46Yl153kgvXaHvPm'),
    ('PMC0003', 'Intan Farzanah', '0145322456', 'intan@gmail.com', '$2a$10$aT6Rtz30GTg29C2/O7Ov.eEiuYzpO/SUm1Fb/46Yl153kgvXaHvPm');

-- Insert data into PATIENT table
INSERT INTO PATIENT (patient_id, name, ic, dob, contact_no, gender)
VALUES
    ('PT0001', 'Syafiq Kyle', '960627333819', '1996-06-27', '0182506301', 'M'),
    ('PT0002', 'Kim Seungmin', '020610379773', '2002-06-10', '0160399672', 'M'),
    ('PT0003', 'Adele Adkins', '770421119164', '1977-04-21', '0121762160', 'F');

-- Insert data into PHYSICIAN table
INSERT INTO PHYSICIAN (physician_id, physician_name, contact_no, email, presc_date)
VALUES
    ('PHY0001', 'Dr. Siti Nurhaliza', '0192234456', 'tokti@gmail.com', '2024-01-30'),
    ('PHY0002', 'Dr. Lilly Suriani', '0123897643', 'lilly@gmail.com', '2024-05-25'),
    ('PHY0003', 'Dr. Xu Minghao', '0180358491', 'minghao@gmail.com', '2024-09-03');

-- Insert data into MEDICATION table
INSERT INTO MEDICATION (med_id, name, brand, exp_date, quantity)
VALUES
    ('M0001', 'Diphenhydramine', 'Benadryl', '2026-12-31', 100),
    ('M0102', 'Aspirin', 'Bayer', '2025-09-30', 75),
    ('M0034', 'Lisinopril', 'Zestril', '2024-10-31', 40),
    ('M0021', 'Cetrizine', 'Zyrtec', '2025-02-28', 250);

-- Insert data into PRESCRIPTION table
INSERT INTO PRESCRIPTION (presc_id, patient_id, med_id, dosage, physician_id, pharmacist_id, presc_date, status)
VALUES
    ('RX0001', 'PT0001', 'M0021', '5 to 10 mg dose once a day', 'PHY0001', 'PMC0001', '2024-01-30', 'Complete'),
    ('RX0002', 'PT0002', 'M0001', '50 mg dose 3 or 4 times daily', 'PHY0002', 'PMC0002', '2024-05-25','Complete'),
    ('RX0003', 'PT0003', 'M0102', '1 or 2 tablets every 4 to 6 hours', 'PHY0003', 'PMC0003', '2024-09-03', 'Incomplete'),
    ('RX0004', 'PT0003', 'M0021', '5 to 10 mg dose once a day', 'PHY0001', 'PMC0003', '2024-09-03', 'Incomplete');