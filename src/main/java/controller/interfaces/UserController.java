package controller.interfaces;

import model.exceptions.UserNotFoundException;
import model.roles.User;

/**
 * UserController
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public interface UserController {
    User createUserCont(User user);

    User updateUserCont(User newUser);

    String getUsersFromDB();

    User getUserFrom();

    User findUser(String login, String pass) throws UserNotFoundException;
}