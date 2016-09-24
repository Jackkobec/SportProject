package model.roles;

import sun.util.calendar.LocalGregorianCalendar;

import java.util.HashSet;

/**
 * Training
 */
public class Training {
    private HashSet<Gymnastic> gymnastics;
    private LocalGregorianCalendar.Date traininDate;

    public Training() {
    }

    public Training(HashSet<Gymnastic> gymnastics) {
        this.gymnastics = gymnastics;
    }

    public Training(HashSet<Gymnastic> gymnastics, LocalGregorianCalendar.Date traininDate) {
        this.gymnastics = gymnastics;
        this.traininDate = traininDate;
    }

    public HashSet<Gymnastic> getGymnastics() {
        return gymnastics;
    }

    public void setGymnastics(HashSet<Gymnastic> gymnastics) {
        this.gymnastics = gymnastics;
    }

    public LocalGregorianCalendar.Date getTraininDate() {
        return traininDate;
    }

    public void setTraininDate(LocalGregorianCalendar.Date traininDate) {
        this.traininDate = traininDate;
    }
}
