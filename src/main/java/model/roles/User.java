package model.roles;

import model.enums.PrivateFileStatus;

import java.util.List;

/**
 * User class
 */
public class User {

    private String login;
    private String password;
    private Contacts contacts;
    private List<Training> userTrainings;
    private int id;
    private PrivateFileStatus privateFileStatus;
    private String privateFilePath;

    //test constructor


    public User(String login, String password, Contacts contacts, List<Training> userTrainings, PrivateFileStatus privateFileStatus, String privateFilePath) {
        this.login = login;
        this.password = password;
        this.contacts = contacts;
        this.userTrainings = userTrainings;
        this.privateFileStatus = privateFileStatus;
        this.privateFilePath = privateFilePath;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, Contacts contacts) {
        this.login = login;
        this.password = password;
        this.contacts = contacts;
    }

    public User(String login, String password, Contacts contacts, int id) {
        this.login = login;
        this.password = password;
        this.contacts = contacts;
        this.id = id;
    }

    public User(String login, String password, Contacts contacts, List<Training> userTrainings, int id) {
        this.login = login;
        this.password = password;
        this.contacts = contacts;
        this.userTrainings = userTrainings;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PrivateFileStatus getPrivateFileStatus() {
        return privateFileStatus;
    }

    public String getPrivateFilePath() {
        return privateFilePath;
    }

    public void setPrivateFilePath(String privateFilePath) {
        this.privateFilePath = privateFilePath;
    }

    public void setPrivateFileStatus(PrivateFileStatus privateFileStatus) {
        this.privateFileStatus = privateFileStatus;


    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", contacts=" + contacts +
                ", userTrainings=" + userTrainings +
                ", id=" + id +
                ", privateFileStatus=" + privateFileStatus +
                ", privateFilePath='" + privateFilePath + '\'' +
                '}';
    }
}

