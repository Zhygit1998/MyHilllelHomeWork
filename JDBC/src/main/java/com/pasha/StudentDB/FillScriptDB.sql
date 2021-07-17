# STRUCTURE OF THE CATHEDRA

INSERT INTO `Cathedra` (`idCathedra`, `cathedraName`, `CathedraFullName`)
VALUES ('1', 'FEI', 'Mizuk');
INSERT INTO `Cathedra` (`idCathedra`, `cathedraName`, `CathedraFullName`)
VALUES ('2', 'tehnology', 'Bukatova');
INSERT INTO `Cathedra` (`idCathedra`, `cathedraName`, `CathedraFullName`)
VALUES ('3', 'pedagogy', 'Ivanova');
INSERT INTO `Cathedra` (`idCathedra`, `cathedraName`, `CathedraFullName`)
VALUES ('4', 'inyaz', 'tkachenko');

# STRUCTURE OF THE TEACHER

INSERT INTO `Teachers` (`idTeacher`, `fullName`, `id_Cathedra`)
VALUES ('1', 'Kichuk', '1');
INSERT INTO `Teachers` (`idTeacher`, `fullName`, `id_Cathedra`)
VALUES ('2', 'Torhyc', '2');
INSERT INTO `Teachers` (`idTeacher`, `fullName`, `id_Cathedra`)
VALUES ('3', 'Fedorova', '3');
INSERT INTO `Teachers` (`idTeacher`, `fullName`, `id_Cathedra`)
VALUES ('4', 'Ivanov', '4');

# STRUCTURE OF THE LESSONS

INSERT INTO `Lessons` (`idLesson`, `lessonName`, `id_Teacher`, `semester`, `year`)
VALUES ('1', 'mechanika', '1', 23, 2005);
INSERT INTO `Lessons` (`idLesson`, `lessonName`, `id_Teacher`, `semester`, `year`)
VALUES ('2', 'nuclearPhysics', '2', 12, 1996);
INSERT INTO `Lessons` (`idLesson`, `lessonName`, `id_Teacher`, `semester`, `year`)
VALUES ('3', 'IKT', '3', 13, 2001);
INSERT INTO `Lessons` (`idLesson`, `lessonName`, `id_Teacher`, `semester`, `year`)
VALUES ('4', 'MNI', '4', 41, 2005);

# STRUCTURE OF THE GROUPNAME

INSERT INTO `GroupName` (`idGroup`, `groupName`)
VALUES ('1', 'abd');
INSERT INTO `GroupName` (`idGroup`, `groupName`)
VALUES ('2', 'fnaf');
INSERT INTO `GroupName` (`idGroup`, `groupName`)
VALUES ('3', 'merega');
INSERT INTO `GroupName` (`idGroup`, `groupName`)
VALUES ('4', 'santim');

# STRUCTURE OF THE STUDENTS

INSERT INTO `Students` (`idStudent`, `FullName`, `id_group`, `yearOfAdmission`)
VALUES ('1', 'Kiril', '1', 2018);
INSERT INTO `Students` (`idStudent`, `FullName`, `id_group`, `yearOfAdmission`)
VALUES ('2', 'Kiril', '2', 2017);
INSERT INTO `Students` (`idStudent`, `FullName`, `id_group`, `yearOfAdmission`)
VALUES ('3', 'Kiril', '3', 2016);
INSERT INTO `Students` (`idStudent`, `FullName`, `id_group`, `yearOfAdmission`)
VALUES ('4', 'Kiril', '4', 2068);

# STRUCTURE OF THE MARKS

INSERT INTO `Marks` (`idMarks`, `id_Lesson`, `id_Student`, `marks`)
VALUES ('1', '1', '1', 'A');
INSERT INTO `Marks` (`idMarks`, `id_Lesson`, `id_Student`, `marks`)
VALUES ('2', '2', '2', 'C');
INSERT INTO `Marks` (`idMarks`, `id_Lesson`, `id_Student`, `marks`)
VALUES ('3', '3', '3', 'B');
INSERT INTO `Marks` (`idMarks`, `id_Lesson`, `id_Student`, `marks`)
VALUES ('4', '4', '4', 'E');
