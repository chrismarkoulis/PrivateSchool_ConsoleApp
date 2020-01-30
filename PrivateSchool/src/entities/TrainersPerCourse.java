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
public class TrainersPerCourse {
    
    private int tpccode;
    private Trainer trainer;
    private Course course;

    public TrainersPerCourse() {
    }

    public TrainersPerCourse(int tpccode, Trainer trainer, Course course) {
        this.tpccode = tpccode;
        this.trainer = trainer;
        this.course = course;
    }

    public TrainersPerCourse(Trainer trainer, Course course) {
        this.trainer = trainer;
        this.course = course;
    }

    public int getTpccode() {
        return tpccode;
    }

    public void setTpccode(int tpccode) {
        this.tpccode = tpccode;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
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
        hash = 83 * hash + this.tpccode;
        hash = 83 * hash + Objects.hashCode(this.trainer);
        hash = 83 * hash + Objects.hashCode(this.course);
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
        final TrainersPerCourse other = (TrainersPerCourse) obj;
        if (this.tpccode != other.tpccode) {
            return false;
        }
        if (!Objects.equals(this.trainer, other.trainer)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrainersPerCourse{" + "tpccode=" + tpccode + ", trainer=" + 
                trainer.getFirstName()+" "+trainer.getLastName() + ", course=" + course.getStream()+", "+
                course.getType()+ '}';
    }
    
    
}
