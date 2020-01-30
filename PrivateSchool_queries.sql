
-- A list of all the students
select scode, sfirstName,slastName,sdateOfBirth,tuitionFees
from students;

-- A list of all the trainers
select tcode, tfirstName, tlastName, trsubject
from trainers;


-- A list of all the assignments
select acode, atitle, adescription, subDateTime, oralMark, totalMark
from assignments;


-- A list of all the courses
select ccode, ctitle, cstream, ctype, cstartDate, cendDate
from courses;


-- All the students per course
select spc.spccode, c.ccode, s.sfirstName,s.slastName,c.ctitle,c.ctype,c.cstream,c.cstartDate,c.cendDate
from studentspercourse spc, students s, courses c
where s.scode = spc.scode
and spc.ccode = c.ccode
order by c.ccode,c.cstream;


-- All the trainers per course
select tpccode, cs.ccode, t.tfirstName,t.tlastName,t.trsubject,cs.ctitle,cs.ctype,cs.cstream,cs.cstartDate,cs.cendDate
from trainerspercourse tpc, trainers t, courses cs
where tpc.tcode = t.tcode and cs.ccode = tpc.ccode
order by cs.ccode,cs.cstream;


-- All the assignments per course
select cs.ccode,atitle,a.adescription,a.subDateTime,a.oralMark,a.totalMark,
       cs.ctitle,cs.ctype,cs.cstream,cs.cstartDate,cs.cendDate
from assignments a, courses cs, assignmentspercourse apc
where a.acode = apc.acode 
and apc.ccode = cs.ccode
order by cs.ccode,cs.cstream;


-- All the assignments per course per student
select c.ccode,s.scode, s.sfirstName,s.slastName,app.stdOralMark,app.stdTotalMark,a.oralMark,
       a.totalMark,a.atitle,a.adescription,ctitle,c.cstream
from assignmentsperstudentpercourse app,students s,courses c, assignments a
where s.scode = app.scode
and app.ccode = c.ccode
and app.acode = a.acode
order by s.scode, c.ccode;



-- A list of students that belong to more than one courses

-- view created for java connectivity purpose
create view moreThanOneCourse as
(select s.sfirstName first_name, s.slastName last_name, spc.scode student_ID, count(*) number_of_courses
from studentspercourse spc, students s
where spc.scode = s.scode
group by spc.scode
having count(*)> 1);

-- execute this
select s.sfirstName first_name, s.slastName last_name, spc.scode student_ID, count(*) number_of_courses
from studentspercourse spc, students s
where spc.scode = s.scode
group by spc.scode
having count(*)> 1;



