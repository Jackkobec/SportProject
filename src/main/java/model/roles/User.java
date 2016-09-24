package model.roles;

import java.util.List;

/**
 * User class
 */
public class User {

    private String login;
    private String password;
    private List<Training> userTrainings;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, List<Training> userTrainings) {
        this.login = login;
        this.password = password;
        this.userTrainings = userTrainings;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Training> getUserTrainings() {
        return userTrainings;
    }

    public void setUserTrainings(List<Training> userTrainings) {
        this.userTrainings = userTrainings;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userTrainings=" + userTrainings +
                '}';
    }
}
