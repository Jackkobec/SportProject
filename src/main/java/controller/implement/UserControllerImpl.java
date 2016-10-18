package controller.implement;

import controller.interfaces.UserController;
import model.app_db.UserDAO;
import model.roles.User;

/**
 * UserControllerImpl
 */
public class UserControllerImpl implements UserController {
    private UserDAO userDAO;

    public UserControllerImpl(UserDAO usedrDAO) {
        this.userDAO = usedrDAO;
    }

    @Override
    public User createUserCont(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public User updateUserCont(User newUser) {
        return userDAO.updateUser(newUser);
    }

    @Override
    public String getUsersFromDB() {
        return userDAO.getUsersFromDB();
    }
}
