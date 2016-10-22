package model.app_db;

import model.exceptions.UserNotFoundException;
import model.roles.Training;
import model.roles.User;

import java.util.List;

/**
 * UserDAO
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public interface UserDAO extends AppDBInterface {

    User createUser(User user);

    User updateUser(User user);

    List<Training> getTrainingsOfUser(User user);

    String getUsersFromDB();

    User getUserFromDB(User user);

    User findUser(User user);

    User findUser(String login, String pass) throws UserNotFoundException;

}
