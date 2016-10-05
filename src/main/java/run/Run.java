package run;

import controller.validation.LoginFormValidation;
import controller.validation.Validator;
import model.app_db.AppDB;
import model.app_db.UserDAO;
import model.app_db.UserDAOimplement;
import view.LoginForm;
import view.MainFrame;
import view.MainFrameTraining;
import view.NewTestFame;

/**
 * Run
 */
public class Run {
    public static void main(String[] args) {
        AppDB appDB = new AppDB();//todo factory better then this
        UserDAO userDAO = new UserDAOimplement(appDB);//todo factory better then this
        Validator validator = new LoginFormValidation();//todo factory better then this

         new LoginForm(userDAO, validator);
        // new MainFrameTraining();
        //new MainFrame();
        // new NewTestFame();
    }
}
