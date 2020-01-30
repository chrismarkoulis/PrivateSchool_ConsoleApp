/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author chris
 */
public class Student {
    
    private int scode;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private int tuitionFees;

    public Student() {
    }

    public Student(int scode, String firstName, String lastName, LocalDate dob, int tuitionFees) {
        this.scode = scode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.tuitionFees = tuitionFees;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.scode;
        hash = 11 * hash + Objects.hashCode(this.firstName);
        hash = 11 * hash + Objects.hashCode(this.lastName);
        hash = 11 * hash + Objects.hashCode(this.dob);
        hash = 11 * hash + this.tuitionFees;
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
        final Student other = (Student) obj;
        if (this.scode != other.scode) {
            return false;
        }
        if (this.tuitionFees != other.tuitionFees) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "scode=" + scode + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", tuitionFees=" + tuitionFees + '}';
    }
    
    
    
}
