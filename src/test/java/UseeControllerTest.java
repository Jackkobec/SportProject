import controller.implement.UserControllerImpl;
import controller.interfaces.UserController;
import model.app_db.AppDB;
import model.app_db.UserDAO;
import model.app_db.UserDAOimplement;
import model.roles.Contacts;
import model.roles.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jack on 15.10.2016.
 */
public class UseeControllerTest {
    AppDB appDB = new AppDB();
    UserDAO userDAO = new UserDAOimplement(appDB);
    UserController userController = new UserControllerImpl(userDAO);


    @Test
    public void testUserCreate() {
        User testUser = new User("Vasa", "7777777", new Contacts("vasa@mail.ru", "Vasa"));
        //assertSame(new User("Vasa", "7777777"), userController.createUserCont(testUser));
        assertEquals("Vasa", userController.createUserCont(testUser).getLogin());
        assertEquals("7777777", userController.createUserCont(testUser).getPassword());
        assertEquals("vasa@mail.ru", userController.createUserCont(testUser).getContacts().getEmail());
        assertEquals("Vasa", userController.createUserCont(testUser).getContacts().getName());
    }
}
