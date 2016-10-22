package model.roles;

import model.enums.PrivateFileStatus;

import java.util.List;

/**
 * User
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
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

    public User(String login, String password, Contacts contacts, List<Training> userTrainings, int id, PrivateFileStatus privateFileStatus, String privateFilePath) {
        this.login = login;
        this.password = password;
        this.contacts = contacts;
        this.userTrainings = userTrainings;
        this.id = id;
        this.privateFileStatus = privateFileStatus;
        this.privateFilePath = privateFilePath;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (contacts != null ? !contacts.equals(user.contacts) : user.contacts != null) return false;
        if (userTrainings != null ? !userTrainings.equals(user.userTrainings) : user.userTrainings != null)
            return false;
        if (privateFileStatus != user.privateFileStatus) return false;
        return privateFilePath != null ? privateFilePath.equals(user.privateFilePath) : user.privateFilePath == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (userTrainings != null ? userTrainings.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (privateFileStatus != null ? privateFileStatus.hashCode() : 0);
        result = 31 * result + (privateFilePath != null ? privateFilePath.hashCode() : 0);
        return result;
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

