package model.app_db;

import model.roles.Training;
import model.roles.User;

import java.util.List;

/**
 * UserDAO
 */
public interface UserDAO extends AppDBInterface {

    public User createUser(User user);

    public User updateUser(User user);

    List<Training> getTrainingsOfUser(User user);



}
