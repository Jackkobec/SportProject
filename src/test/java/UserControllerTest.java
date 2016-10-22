import controller.implement.UserControllerImpl;
import controller.interfaces.UserController;
import controller.internetActions.emailActions.EmailLetterTemplate;
import controller.internetActions.emailActions.SMTPemailSender;
import model.app_db.AppDB;
import model.app_db.UserDAO;
import model.app_db.UserDAOimplement;
import model.exceptions.IncorrectUserException;
import model.exceptions.UserNotFoundException;
import model.roles.Contacts;
import model.roles.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * UserControllerTest
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class UserControllerTest {

    private AppDB appDB;
    private UserDAO userDAO;
    private UserController userController;
    private User testUser;
    private User testUser2;
    private User testUser3;

    @Before
    public void InitData() {
        appDB = new AppDB();
        userDAO = new UserDAOimplement(appDB);
        userController = new UserControllerImpl(userDAO);
        testUser = new User("Vasa", "7777777", new Contacts("vasa@mail.ru", "Vasa"));
        testUser2 = new User("Peta", "8888888", new Contacts("peta@mail.ru", "Peta"));
        testUser3 = new User("Vasa", "7", new Contacts("vasa@mail.ru", "Vasa"));
        testUser2.setId(testUser.getId());
        //testUser3.setId(77);
        userController.createUserCont(testUser);
        userController.createUserCont(testUser2);


    }

    @Test
    public void testUserCreate() {

        assertEquals("Vasa", userController.createUserCont(testUser).getLogin());
        assertEquals("7777777", userController.createUserCont(testUser).getPassword());
        assertEquals("vasa@mail.ru", userController.createUserCont(testUser).getContacts().getEmail());
        assertEquals("Vasa", userController.createUserCont(testUser).getContacts().getName());
    }

    @Test
    public void testUpdateUserPositive() {

        assertEquals("Peta", userController.updateUserCont(testUser2).getLogin());
        assertEquals("8888888", userController.updateUserCont(testUser2).getPassword());
        assertEquals("peta@mail.ru", userController.updateUserCont(testUser2).getContacts().getEmail());
    }

    @Test
    public void testFindUserPositive() throws UserNotFoundException {

        userController.findUser(testUser2.getLogin(), testUser2.getPassword());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void testFindUserNegative() throws UserNotFoundException {

        expectedException.expect(UserNotFoundException.class);
        expectedException.expectMessage("User Not Found!");

        userController.findUser(testUser3.getLogin(), testUser3.getPassword());
    }
}

