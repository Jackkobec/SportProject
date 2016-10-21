package run;

import controller.implement.UserControllerImpl;
import controller.interfaces.UserController;
import controller.validation.LoginFormValidation;
import controller.validation.Validator;
import model.app_db.AppDB;
import model.app_db.UserDAO;
import model.app_db.UserDAOimplement;
import model.roles.Contacts;
import model.roles.User;
import view.TrainingSelectFrame;

/**
 * Run
 */
public class Run {
    public static void main(String[] args) {
        AppDB appDB = new AppDB();//todo factory better then this
        UserDAO userDAO = new UserDAOimplement(appDB);//todo factory better then this
        UserController userController = new UserControllerImpl(userDAO);
        Validator validator = new LoginFormValidation();//todo factory better then this
        //todo dont forget add initialisation of the controllers and other data
        User testUser = new User("Jack", "777", new Contacts("jack@gmail.com", "Jack"));
        appDB.addUser(testUser);//test User
        testUser.setId(77);

        //new LoginForm(userDAO, validator, userController);
        //new UserUpdateForm(null,userController.createUserCont(new User("Vasa", "777", null, null, SELECTED_AND_SAVED, "C:\\")) , userDAO, validator, userController);
        //new MainFrameTraining();
        //new MainFrame();
        // new NewTestFame();
        new TrainingSelectFrame(testUser, userDAO, validator, userController);

    }
}
