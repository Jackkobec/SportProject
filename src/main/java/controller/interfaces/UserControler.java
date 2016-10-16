package controller.interfaces;

import model.roles.User;

/**
 *
 */
public interface UserControler {
    User createUserCont(User user);

    User updateUserCont(User newUser);
}
