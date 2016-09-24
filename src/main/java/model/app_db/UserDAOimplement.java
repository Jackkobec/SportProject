package model.app_db;

import model.roles.Training;
import model.roles.User;

import java.util.List;

/**
 * UserDAOimplement
 */
public class UserDAOimplement implements UserDAO{
    private AppDB appDB;

    @Override
    public User createUser(User user) {
        return appDB.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List<Training> getTrainingsOfUser(User user) {
        return null;
    }
}
