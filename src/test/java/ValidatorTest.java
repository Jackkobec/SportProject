import controller.validation.LoginFormValidation;
import controller.validation.Validator;
import org.junit.BeforeClass;
import org.junit.Test;

import static controller.validation.LoginFormValidation.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * ValidatorTest
 */
public class ValidatorTest {
    Validator validator = new LoginFormValidation();

    @Test
    public void testValidationLogin() {

        assertTrue(validator.loginValidator("Jack"));
        assertTrue(validator.loginValidator("jack777"));
        assertTrue(validator.loginValidator("777"));
        assertFalse(validator.loginValidator("_/]&"));
        assertFalse(validator.loginValidator("77777777777777777777"));
        assertFalse(validator.loginValidator("7"));
        assertFalse(validator.loginValidator(""));
    }

    @Test
    public void testValidationPassword() {

        assertTrue(validator.passwordValidator("Jack"));
        assertTrue(validator.passwordValidator("jack777"));
        assertTrue(validator.passwordValidator("777"));
        assertFalse(validator.passwordValidator("_/]&"));
        assertFalse(validator.passwordValidator("77777777777777777777"));
        assertFalse(validator.loginValidator("7"));
        assertFalse(validator.passwordValidator(""));
    }

    @Test
    public void testValidationEmail() {

        assertTrue(validator.emailValidator("Jack@mail.ru"));
        assertTrue(validator.emailValidator("jack@gmail.com"));
        assertTrue(validator.emailValidator("jk@i.ua"));
        assertFalse(validator.emailValidator("@mail.ru"));
        assertFalse(validator.emailValidator("VASA"));
        assertFalse(validator.emailValidator("@"));
        assertFalse(validator.emailValidator(""));
    }
}
