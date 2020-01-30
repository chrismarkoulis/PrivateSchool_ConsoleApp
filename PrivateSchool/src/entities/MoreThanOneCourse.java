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
public class MoreThanOneCourse {
    
    private String firstName;
    private String lastName;
    private int StudentId;
    private int numberOfCourses;

    
    
    public MoreThanOneCourse() {
    }
    
    public MoreThanOneCourse(String firstName, String lastName, int StudentId, int numberOfCourses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.StudentId = StudentId;
        this.numberOfCourses = numberOfCourses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + this.StudentId;
        hash = 97 * hash + this.numberOfCourses;
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
        final MoreThanOneCourse other = (MoreThanOneCourse) obj;
        if (this.StudentId != other.StudentId) {
            return false;
        }
        if (this.numberOfCourses != other.numberOfCourses) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MoreThanOneCourse{" + "firstName=" + firstName + ", lastName=" + lastName + ", StudentId=" + StudentId + ", numberOfCourses=" + numberOfCourses + '}';
    }

    
    
    
    
}
