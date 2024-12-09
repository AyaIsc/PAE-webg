-- Insérer les cours
INSERT INTO cours (code, intitule, credits) VALUES ('INT1', 'Introduction à la programmation', '10');
INSERT INTO cours (code, intitule, credits) VALUES ('ALG3', 'Algorithmique', '6');
INSERT INTO cours (code, intitule, credits) VALUES ('ALG1', 'Introduction à lalgorithmique', '10');
INSERT INTO cours (code, intitule, credits) VALUES ('DEV2', 'developemment 2', '6');
INSERT INTO cours (code, intitule, credits) VALUES ('SYS3', 'Systeme 3', '10');


-- Insérer les étudiants
INSERT INTO student (matricule, nom, genre, section) VALUES (9777, 'Alice', 'F', 'dev');
INSERT INTO student (matricule, nom, genre, section) VALUES (7856, 'Bob', 'M', 'indus');
INSERT INTO student (matricule, nom, genre, section) VALUES (0001, 'Roberto', 'M', 'indus');

-- Insérer les relations étudiant-cours
INSERT INTO student_cours (student_id, cours_id) VALUES (9777, 'INT1'); -- Alice suit INT1
INSERT INTO student_cours (student_id, cours_id) VALUES (7856, 'ALG3'); -- Alice suit ALG3

INSERT INTO student_cours (student_id, cours_id) VALUES (0001, 'ALG1'); 
INSERT INTO student_cours (student_id, cours_id) VALUES (0001, 'DEV2'); 
INSERT INTO student_cours (student_id, cours_id) VALUES (0001, 'SYS3'); 

-- Insérer les utilisateurs dans la table Account
INSERT INTO Account (username, password, enabled) VALUES
('student', '{noop}student', true),
('prof', '{noop}prof', true),
('secretariat','{noop}secretariat', true),
('0001', '{noop}roberto', true),
('9777', '{noop}alice', true);

-- Insérer les rôles dans la table Authority
INSERT INTO Authority (id, username, authority) VALUES
(1, 'student', 'STUDENT'),
(2, 'prof', 'PROFESSOR'),
(3,'secretariat','SECRETARIAT'),
(4,'0001','STUDENT'),
(5,'9777','STUDENT');
