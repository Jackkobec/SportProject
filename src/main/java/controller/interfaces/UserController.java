package controller.interfaces;

import model.exceptions.UserNotFoundException;
import model.roles.User;

/**
 *
 */
public interface UserController {
    User createUserCont(User user);

    User updateUserCont(User newUser);

    String getUsersFromDB();

    User getUserFrom();

    User findUser(String login, String pass) throws UserNotFoundException;
}