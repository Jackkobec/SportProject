import org.junit.Test;

import static controller.validation.LoginFormValidation.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * ValidatorTest
 */
public class ValidatorTest {


    @Test
    public void testValidationLogin() {

        assertTrue(loginValidator("Jack"));
        assertTrue(loginValidator("jack777"));
        assertTrue(loginValidator("777"));
        assertFalse(loginValidator("_/]&"));
        assertFalse(loginValidator("77777777777777777777"));
        assertFalse(loginValidator("7"));
        assertFalse(loginValidator(""));
    }

    @Test
    public void testValidationPassword() {

        assertTrue(passwordValidator("Jack"));
        assertTrue(passwordValidator("jack777"));
        assertTrue(passwordValidator("777"));
        assertFalse(passwordValidator("_/]&"));
        assertFalse(passwordValidator("77777777777777777777"));
        assertFalse(loginValidator("7"));
        assertFalse(passwordValidator(""));
    }

    @Test
    public void testValidationEmail() {

        assertTrue(emailValidator("Jack@mail.ru"));
        assertTrue(emailValidator("jack@gmail.com"));
        assertTrue(emailValidator("jk@i.ua"));
        assertFalse(emailValidator("@mail.ru"));
        assertFalse(emailValidator("VASA"));
        assertFalse(emailValidator("@"));
        assertFalse(emailValidator(""));
    }
}
