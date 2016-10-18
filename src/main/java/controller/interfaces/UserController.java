package controller.interfaces;

import model.roles.User;

/**
 *
 */
public interface UserController {
    User createUserCont(User user);

    User updateUserCont(User newUser);

    String getUsersFromDB();
}