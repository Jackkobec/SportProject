package model.roles;

import java.util.List;

/**
 * User class
 */
public class User {

    private String login;
    private String password;
    private Contacts contacts;
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

    public User(String login, String password, Contacts contacts, List<Training> userTrainings) {
        this.login = login;
        this.password = password;
        this.contacts = contacts;
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

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
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
                ", contacts=" + contacts +
                ", userTrainings=" + userTrainings +
                '}';
    }
}
