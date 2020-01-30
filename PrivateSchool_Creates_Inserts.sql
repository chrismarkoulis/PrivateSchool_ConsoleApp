create database PrivateSchool;

use PrivateSchool;

CREATE TABLE Courses
(
  ccode       int auto_increment primary key ,
  ctitle      varchar(20) NOT NULL ,
  cstream     varchar(20) NOT NULL ,
  ctype       varchar(20) NOT NULL ,
  cstartDate  date NOT NULL ,
  cendDate    date NOT NULL 
);

CREATE TABLE Assignments
(
 acode         int auto_increment primary key,
 atitle        varchar(20) NOT NULL,
 adescription  varchar(20) NOT NULL,
 subDateTime   date NOT NULL,
 oralMark      int NOT NULL,
 totalMark     int NOT NULL
);


CREATE TABLE Trainers
(
 tcode         int auto_increment primary key,
 tfirstName    varchar(20) not null,
 tlastName     varchar(20) not null,
 trsubject     varchar(20) not null
 );


CREATE TABLE Students
(
 scode         int auto_increment primary key ,
 sfirstName    varchar(20) not null,
 slastName     varchar(20) not null,
 sdateOfBirth  date,
 tuitionFees   int
);

CREATE TABLE StudentsPerCourse
(  spccode   int auto_increment primary key,
   ccode     int,
   scode     int,
CONSTRAINT fk_courses FOREIGN KEY (ccode) REFERENCES Courses (ccode),
CONSTRAINT fk_students FOREIGN KEY (scode) REFERENCES Students (scode)
);


CREATE TABLE TrainersPerCourse
(  tpccode   int auto_increment primary key,
   ccode     int,
   tcode     int,
CONSTRAINT fk1_courses FOREIGN KEY (ccode) REFERENCES Courses (ccode),
CONSTRAINT fk2_trainers FOREIGN KEY (tcode) REFERENCES Trainers (tcode)
);


create table AssignmentsPerCourse(
apccode int auto_increment primary key,
acode   int,
ccode   int,
constraint fk1_Assignments foreign key (acode) references Assignments (acode),
constraint fk2_Courses foreign key (ccode) references Courses (ccode)
);



CREATE TABLE AssignmentsPerStudentPerCourse
(
 appcode   int auto_increment primary key,
 ccode     int,
 acode     int,
 scode     int,
 stdOralMark  int unsigned,
 stdTotalMark int unsigned,
constraint fk1_Crs foreign key (ccode) references Courses (ccode),
constraint fk2_Assigns foreign key (acode) references Assignments (acode),
constraint fk3_Stds foreign key (scode) references Students (scode),
constraint check_oMark check(stdOralMark>=0 and stdOralMark<=40),
constraint check_tMark check(stdTotalMark>=0 and stdTotalMark<=100)
);


insert into students (scode,sfirstName,slastName,sdateOfBirth,tuitionFees) 
values (100101,'Mark','Johnson','1986/01/29',2500),
(100102,'Christie','Bell','1991-08-03',2500),
(100103,'Jim','Davis','1985-12-14',2500),
(100104,'Monica','Johnson','1993-07-10',2500),
(100105,'Jack','Jacobs','1987-05-22',2500),
(100106,'Michael','Bell','1990-03-30',2500),
(100107,'Alice','Davis','1989-05-02',2500),
(100108,'Jacob','Allen','1994-04-15',2500)
;

insert into courses (ccode,ctitle,cstream,ctype,cstartDate,cendDate) 
values (010,'CBJ','Java','Full-time','2019-10-14','2020-01-22'),
(020,'CBC','C','Full-time','2019-10-14','2020-01-22'),
(030,'CBP','Python','Part-time','2019-10-14','2020-04-22'),
(040,'CBR','Ruby','Part-time','2019-10-14','2020-04-22');

insert into trainers(tcode,tfirstName,tlastName,trsubject)
values(0101,'Jason','Gosling','Algorithms and Data Structures'),
(0102,'Arnold','Schwarz','Object-oriented Programming'),
(0103,'Thomas','Anders','Object-oriented Programming'),
(0104,'George','Newark','HTML/CSS'),
(0105,'Andy','Waters','Databases');

insert into assignments(acode,atitle,adescription,subDateTime,oralMark,totalMark)
values(11,'mySql Project','DATABASES','2019-11-04',30,100),
(12,'coding skills','OOP','2019-11-28',20,100),
(13,'Web Application','HTML/CSS','2020-01-20',40,100),
(14,'advanced coding skills','OOP','2019-12-15',20,100);

insert into TrainersPerCourse(tpccode,ccode,tcode)
values(01,010,0102),
(02,010,0105),
(03,020,0101),
(04,020,0103),
(05,030,0102),
(06,030,0104),
(07,040,0103);

insert into StudentsPerCourse(spccode,ccode,scode)
values(1011,010,100101),
(1012,010,100102),
(1013,010,100103),
(1014,020,100104),
(1015,030,100105),
(1016,030,100106),
(1017,030,100107),
(1018,030,100108),
(1019,040,100107),
(1020,040,100108);

insert into AssignmentsPerCourse(apccode,acode,ccode)
values(1,11,010),
(2,12,010),
(3,13,010),
(4,12,020),
(5,14,020),
(6,11,030),
(7,14,030),
(8,12,040);

insert into AssignmentsPerStudentPerCourse (appcode,ccode,acode,scode,stdOralMark,stdTotalMark)
values(001,010,11,100101,25,85),
(002,010,12,100101,17,76),
(003,010,13,100101,30,84),
(004,010,11,100102,30,90),
(005,010,12,100102,15,80),
(006,010,13,100102,32,77),
(007,010,11,100103,27,68),
(008,010,12,100103,18,62),
(009,010,13,100103,30,87),
(010,020,12,100104,14,85),
(011,020,14,100104,19,90),
(012,030,11,100105,25,85),
(013,030,14,100105,18,92),
(014,030,11,100106,22,77),
(015,030,14,100106,14,68),
(016,030,11,100107,30,79),
(017,030,14,100107,18,86),
(018,030,11,100108,26,90),
(019,030,14,100108,17,83),
(020,040,12,100107,18,90),
(021,040,12,100108,20,95);

