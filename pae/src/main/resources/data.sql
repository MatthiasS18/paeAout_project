insert into Course(id, title, credits) values('dev', 'developpment', 3);
insert into Course(id, title, credits) values('sc', 'science', 2);
insert into Course(id, title, credits) values('math', 'mathematique', 5);


insert into Student(id, name, gender, section) values (1, 'jean', 'MALE', 'DEVELOPPEMENT');
insert into Student(id, name, gender, section) values (2, 'jack', 'MALE', 'INDUSTRIELLE');
insert into Student(id, name, gender, section) values (3, 'marc', 'MALE', 'RESEAU');

-- Table de jointure Many-to-Many
-- ⚠️ Vérifiez dans H2 que la table générée s'appelle bien student_courses
insert into student_courses(students_id, courses_id) values (1, 'dev'); -- jean -> web
insert into student_courses(students_id, courses_id) values (1, 'sc'); -- jean -> dev2
insert into student_courses(students_id, courses_id) values (2, 'sc'); -- jack -> dev2
insert into student_courses(students_id, courses_id) values (3, 'math'); -- marc -> erpg
insert into student_courses(students_id, courses_id) values (3, 'math'); -- marc -> web

-- Séquence auto-incrémentation
alter sequence STUDENT_seq restart with 4;


-- student_courses (students_id integer not null, courses_id varchar(255) not null)