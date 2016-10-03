package controller.validation;

import java.util.regex.Pattern;

/**
 * LoginFormValidation
 */
public class LoginFormValidation {

    public static boolean loginValidator(String login) {
        if (login.isEmpty() || login.equals(null)) {
            return false;
        }
        //chars A-Za-z0-9_  length 3-15 spaces denied
        Pattern rule = Pattern.compile("^[A-Za-z0-9_]{3,15}$");
        return rule.matcher(login).matches();
    }

    public static boolean passwordValidator(String password) {
        if (password.isEmpty() || password.equals(null)) {
            return false;
        }
        //chars A-Za-z0-9_  length 3-15 spaces denied
        Pattern rule = Pattern.compile("^[A-Za-z0-9_]{3,15}$");
        return rule.matcher(password).matches();
    }

    public static boolean emailValidator(String email) {
        if (email.isEmpty() || email.equals(null)) {
            return false;
        }
        Pattern rule = Pattern.compile("[a-zA-Z\\d@_\\-\\.]+?@([a-zA-Z]+\\.){1,2}[a-zA-Z]{2,3}");
        return rule.matcher(email).matches();
    }

}
