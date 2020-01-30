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
public class Course {
    
    private int ccode;
    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endIDate;

    public Course() {
    }

    public Course(int ccode, String title, String stream, String type, LocalDate startDate, LocalDate endIDate) {
        this.ccode = ccode;
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endIDate = endIDate;
    }

    public int getCcode() {
        return ccode;
    }

    public void setCcode(int ccode) {
        this.ccode = ccode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndIDate() {
        return endIDate;
    }

    public void setEndIDate(LocalDate endIDate) {
        this.endIDate = endIDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.ccode;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.stream);
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + Objects.hashCode(this.startDate);
        hash = 67 * hash + Objects.hashCode(this.endIDate);
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
        final Course other = (Course) obj;
        if (this.ccode != other.ccode) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.stream, other.stream)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endIDate, other.endIDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Course{" + "ccode=" + ccode + ", title=" + title + ", stream=" + stream + ", type=" + type + ", startDate=" + startDate + ", endIDate=" + endIDate + '}';
    }
    
    
    
    
}
