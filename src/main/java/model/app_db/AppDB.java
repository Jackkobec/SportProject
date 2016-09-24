package model.app_db;

import model.roles.Gymnastic;
import model.roles.Training;
import model.roles.User;

import java.util.*;

/**
 * AppDB
 */
public class AppDB {
//    private static int userIdCounter = 1;
//    private static int gymnasticIdCounter = 1;
//    private static int trainingIdCounter = 1;


    private List<Gymnastic> allGymnastics;

    private Map<User, List<Training>> userAccounts;
    private List<Training> trainingsOfDefaultTrainings;

    public AppDB() {
    }

    public AppDB(Map<User, List<Training>> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public AppDB(List<Gymnastic> allGymnastics, Map<User, List<Training>> userAccounts, List<Training> trainingsOfDefaultTrainings) {
        this.allGymnastics = allGymnastics;
        this.userAccounts = userAccounts;
        this.trainingsOfDefaultTrainings = trainingsOfDefaultTrainings;
    }

    public User addUser(User user) {
        //user.setId(userIdCounter++);
        userAccounts.put(user, new ArrayList<>());
        return user;
    }

    public Gymnastic addGymnastic(Gymnastic gymnastic) {
        allGymnastics.add(gymnastic);
        return gymnastic;
    }


    public List<Gymnastic> getAllGymnastics() {
        return allGymnastics;
    }

    public void setAllGymnastics(List<Gymnastic> allGymnastics) {
        this.allGymnastics = allGymnastics;
    }

    public Map<User, List<Training>> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(Map<User, List<Training>> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public List<Training> getTrainingsOfDefaultTrainings() {
        return trainingsOfDefaultTrainings;
    }

    public void setTrainingsOfDefaultTrainings(List<Training> trainingsOfDefaultTrainings) {
        this.trainingsOfDefaultTrainings = trainingsOfDefaultTrainings;
    }

    @Override
    public String toString() {
        return "AppDB{" +
                "allGymnastics=" + allGymnastics +
                ", userAccounts=" + userAccounts +
                ", trainingsOfDefaultTrainings=" + trainingsOfDefaultTrainings +
                '}';
    }
}

