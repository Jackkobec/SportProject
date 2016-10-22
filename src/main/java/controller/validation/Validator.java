package controller.validation;

/**
 * Validator
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public interface Validator {

    public boolean loginValidator(String login);

    public  boolean passwordValidator(String password);

    public  boolean emailValidator(String email);

}
