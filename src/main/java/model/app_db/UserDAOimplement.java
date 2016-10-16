package model.app_db;

import model.roles.Training;
import model.roles.User;

import java.util.List;

/**
 * UserDAOimplement
 */
public class UserDAOimplement implements UserDAO {

    public UserDAOimplement(AppDB appDB) {
        this.appDB = appDB;
    }

    private AppDB appDB;

    @Override
    public User createUser(User user) {
        return appDB.addUser(user);
    }

    @Override
    public User updateUser(User newUser) {
        User res = null;
        for (User us : appDB.getUserAccounts().keySet()) {
            if (us.getId() == newUser.getId()) {

                us = newUser;
                res = us;
            }
        }
        return res;
    }

    @Override
    public List<Training> getTrainingsOfUser(User user) {
        return null;
    }
}
