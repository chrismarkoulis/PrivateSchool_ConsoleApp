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
public class Trainer {
    
    private int tcode;
    private String firstName;
    private String lastName;
    private String subject;

    public Trainer() {
    }

    public Trainer(int tcode, String firstName, String lastName, String subject) {
        this.tcode = tcode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public int getTcode() {
        return tcode;
    }

    public void setTcode(int tcode) {
        this.tcode = tcode;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.tcode;
        hash = 47 * hash + Objects.hashCode(this.firstName);
        hash = 47 * hash + Objects.hashCode(this.lastName);
        hash = 47 * hash + Objects.hashCode(this.subject);
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
        final Trainer other = (Trainer) obj;
        if (this.tcode != other.tcode) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trainer{" + "tcode=" + tcode + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject + '}';
    }
    
    
    
}
