package model.app_db;

import model.exceptions.IncorrectUserException;
import model.roles.Training;
import model.roles.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
       // User res = null;
        Set<User> useSet  = appDB.getUserAccounts().keySet();
        for (User us : useSet) {
//            if (us.getId() == newUser.getId()) {
//
//                us = newUser;
//                res = us;
//                return res;
//            }
            if (us.getId() == newUser.getId()) {
                useSet.remove(us);
                appDB.getUserAccounts().put(newUser, new ArrayList<>());
               return newUser;
            }
        }
        try {
            throw new IncorrectUserException("Данные изменяемого юзера некорректны");
        } catch (IncorrectUserException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Training> getTrainingsOfUser(User user) {
        return null;
    }

    @Override
    public String getUsersFromDB() {
        return appDB.getUserAccounts().toString();
    }
}
