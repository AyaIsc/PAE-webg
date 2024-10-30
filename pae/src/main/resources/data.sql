INSERT INTO cours (id, code, intitule, credits) VALUES ('1', 'INT1', 'Introduction à la programmation','10');
INSERT INTO cours (id, code, intitule, credits) VALUES ('2','ALG3', 'Algorithmique','6');

ALTER SEQUENCE student_seq RESTART WITH 3;


-- Insert students
INSERT INTO student (id, matricule, nom) VALUES (1, 'S001', 'Alice');
INSERT INTO student (id, matricule, nom) VALUES (2, 'S002', 'Bob');

-- Insert student-course relations
INSERT INTO student_cours (student_id, cours_id) VALUES (1, '1'); -- Alice takes INT1
INSERT INTO student_cours (student_id, cours_id) VALUES (1, '2'); -- Alice takes ALG3
INSERT INTO student_cours (student_id, cours_id) VALUES (2, '1'); -- Bob takes INT1

