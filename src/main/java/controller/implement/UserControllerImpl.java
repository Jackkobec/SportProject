package controller.implement;

import controller.interfaces.UserControler;
import model.app_db.UserDAO;
import model.roles.User;

/**
 * UserControllerImpl
 */
public class UserControllerImpl implements UserControler {
    private UserDAO userDAO;

    public UserControllerImpl(UserDAO usedrDAO) {
        this.userDAO = usedrDAO;
    }

    @Override
    public User createUserCont(User user) {
        return userDAO.createUser(user);
    }
}
