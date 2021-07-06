CREATE DATABASE if not exists Student;
USE Student;

CREATE TABLE GroupName
(
	idGroup    	BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    groupName 	VARCHAR(30)     NOT NULL
);

CREATE TABLE Students
(
    idStudent              BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FullName	     	   VARCHAR(255)    NOT NULL,
    id_group   	           BIGINT UNSIGNED NOT NULL,
    yearOfAdmission		   SMALLINT UNSIGNED NOT NULL
);
CREATE TABLE Marks
(
    idMarks  				BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_Lesson  				BIGINT UNSIGNED NOT NULL,
    id_Student 				BIGINT UNSIGNED NOT NULL,
    marks    				VARCHAR(1)    NOT NULL
);
CREATE TABLE Lessons
(
    idLesson       	BIGINT UNSIGNED   NOT NULL PRIMARY KEY AUTO_INCREMENT,
    lessonName 		VARCHAR(255)       NOT NULL,
    id_Teacher  	BIGINT UNSIGNED   NOT NULL,
    semester        TINYINT UNSIGNED  NOT NULL,
    year      		SMALLINT UNSIGNED NOT NULL
);

CREATE TABLE Teachers
(
    idTeacher        BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fullName 		 VARCHAR(255)    NOT NULL,
    id_Cathedra      BIGINT UNSIGNED NOT NULL
);

CREATE TABLE Cathedra
(
    idCathedra              BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cathedraName            TINYTEXT        NOT NULL,
    CathedraFullName		VARCHAR(255)    NOT NULL
);

ALTER TABLE Teachers
    ADD
        CONSTRAINT FK_Teachers_Cathedra
            FOREIGN KEY (id_Cathedra)
                REFERENCES Cathedra (idCathedra);

ALTER TABLE Lessons
    ADD
        CONSTRAINT FK_Lessons_Teachers
            FOREIGN KEY (id_Teacher)
                REFERENCES Teachers (idTeacher);


ALTER TABLE Marks
    ADD
        CONSTRAINT FK_Marks_Lessons
            FOREIGN KEY (id_Lesson)
                REFERENCES Lessons (idLesson);

ALTER TABLE Marks
    ADD
        CONSTRAINT FK_Marks_Students
            FOREIGN KEY (id_student)
                REFERENCES Students (idStudent);
                
ALTER TABLE Students
    ADD
        CONSTRAINT FK_Students_GroupNamePRIMARY
            FOREIGN KEY (id_group)
                REFERENCES GroupName (idGroup);
