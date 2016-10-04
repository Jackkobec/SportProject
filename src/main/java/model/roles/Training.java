package model.roles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Training
 */
public class Training {


    private Map<String, List<Object>> gymnastics;
    private LocalDateTime trainingDateTime;

    public Training() {
    }

    public Training(Map<String, List<Object>> gymnastics, LocalDateTime trainingDateTime) {
        this.gymnastics = gymnastics;
        this.trainingDateTime = trainingDateTime;
    }

    public Map<String, List<Object>> getGymnastics() {
        return gymnastics;
    }

    public void setGymnastics(Map<String, List<Object>> gymnastics) {
        this.gymnastics = gymnastics;
    }

    public LocalDateTime getTrainingDateTime() {
        return trainingDateTime;
    }

    public void setTrainingDateTime(LocalDateTime trainingDateTime) {
        this.trainingDateTime = trainingDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Training training = (Training) o;

        if (gymnastics != null ? !gymnastics.equals(training.gymnastics) : training.gymnastics != null) return false;
        return trainingDateTime != null ? trainingDateTime.equals(training.trainingDateTime) : training.trainingDateTime == null;

    }

    @Override
    public int hashCode() {
        int result = gymnastics != null ? gymnastics.hashCode() : 0;
        result = 31 * result + (trainingDateTime != null ? trainingDateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Training{" +
                "gymnastics=" + gymnastics +
                ", trainingDateTime=" + trainingDateTime +
                '}';
    }
}
