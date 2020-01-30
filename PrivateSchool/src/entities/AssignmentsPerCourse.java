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
public class AssignmentsPerCourse {
    
    private int apccode;
    private Assignment assignment;
    private Course course;

    public AssignmentsPerCourse() {
    }

    public AssignmentsPerCourse(int apccode, Assignment assignment, Course course) {
        this.apccode = apccode;
        this.assignment = assignment;
        this.course = course;
    }

    public AssignmentsPerCourse(Assignment assignment, Course course) {
        this.assignment = assignment;
        this.course = course;
    }

    public int getApccode() {
        return apccode;
    }

    public void setApccode(int apccode) {
        this.apccode = apccode;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.apccode;
        hash = 37 * hash + Objects.hashCode(this.assignment);
        hash = 37 * hash + Objects.hashCode(this.course);
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
        final AssignmentsPerCourse other = (AssignmentsPerCourse) obj;
        if (this.apccode != other.apccode) {
            return false;
        }
        if (!Objects.equals(this.assignment, other.assignment)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AssignmentsPerCourse{" + "apccode=" + apccode + ", assignment=" + 
                assignment.getTitle()+", "+""+ ", course= " + course.getStream()+", " + course.getType() + '}';
    }
    
    
    
}


