/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author chris
 */
public class AssignmentsPerStudentPerCourse {
    
    private int appcode;
    private Assignment assignment;
    private Student student;
    private Course course;
    private int stdOralMark;
    private int stdTotalMark;

    public AssignmentsPerStudentPerCourse() {
    }

    public AssignmentsPerStudentPerCourse(int appcode, Assignment assignment, Student student, Course course, int stdOralMark, int stdTotalMark) {
        this.appcode = appcode;
        this.assignment = assignment;
        this.student = student;
        this.course = course;
        this.stdOralMark = stdOralMark;
        this.stdTotalMark = stdTotalMark;
    }

    public AssignmentsPerStudentPerCourse(Assignment assignment, Student student, Course course, int stdOralMark, int stdTotalMark) {
        this.assignment = assignment;
        this.student = student;
        this.course = course;
        this.stdOralMark = stdOralMark;
        this.stdTotalMark = stdTotalMark;
    }

    public AssignmentsPerStudentPerCourse(int stdOralMark, int stdTotalMark) {
        this.stdOralMark = stdOralMark;
        this.stdTotalMark = stdTotalMark;
    }

    public int getAppcode() {
        return appcode;
    }

    public void setAppcode(int appcode) {
        this.appcode = appcode;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getStdOralMark() {
        return stdOralMark;
    }

    public void setStdOralMark(int stdOralMark) {
        this.stdOralMark = stdOralMark;
    }

    public int getStdTotalMark() {
        return stdTotalMark;
    }

    public void setStdTotalMark(int stdTotalMark) {
        this.stdTotalMark = stdTotalMark;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.appcode;
        hash = 13 * hash + Objects.hashCode(this.assignment);
        hash = 13 * hash + Objects.hashCode(this.student);
        hash = 13 * hash + Objects.hashCode(this.course);
        hash = 13 * hash + this.stdOralMark;
        hash = 13 * hash + this.stdTotalMark;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssignmentsPerStudentPerCourse other = (AssignmentsPerStudentPerCourse) obj;
        if (this.appcode != other.appcode) {
            return false;
        }
        if (this.stdOralMark != other.stdOralMark) {
            return false;
        }
        if (this.stdTotalMark != other.stdTotalMark) {
            return false;
        }
        if (!Objects.equals(this.assignment, other.assignment)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "INFO:\t\n"
                 + "appcode="+ appcode+"\n" + "assignment=" + assignment.getTitle() + ", "
                + "student=" + student.getFirstName()+" "+student.getLastName() + ", course=" + 
                course.getStream()+" "+course.getType()+"\nAssignment Marks -> "+"Oral Mark:"+
                assignment.getOralMark()+", "+"Total Mark: "+ assignment.getTotalMark()+"\nStudent Marks -> "+ "OralMark:" + stdOralMark + ", "
                + "TotalMark:" + stdTotalMark +"\n";
    }
    
    
}
