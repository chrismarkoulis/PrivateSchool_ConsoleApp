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
public class StudentsPerCourse {
    
    private int spccode;
    private Student student;
    private Course course;

    public StudentsPerCourse() {
    }

    public StudentsPerCourse(int spccode, Student student, Course course) {
        this.spccode = spccode;
        this.student = student;
        this.course = course;
    }

    public StudentsPerCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public int getSpccode() {
        return spccode;
    }

    public void setSpccode(int spccode) {
        this.spccode = spccode;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.spccode;
        hash = 29 * hash + Objects.hashCode(this.student);
        hash = 29 * hash + Objects.hashCode(this.course);
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
        final StudentsPerCourse other = (StudentsPerCourse) obj;
        if (this.spccode != other.spccode) {
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
        return "Enrollment:" + "\n\tspccode=" + spccode + "| student=" + student.getFirstName()+" "+student.getLastName() + "| course=" + course.getStream()+"| "+course.getType() + '|';
    }

    
}
