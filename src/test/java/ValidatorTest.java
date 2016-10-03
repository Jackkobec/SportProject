import controller.validation.LoginFormValidation;
import org.junit.Test;

import static controller.validation.LoginFormValidation.loginValidator;
import static controller.validation.LoginFormValidation.passwordValidator;
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
}
