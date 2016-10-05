package controller.validation;

/**
 * Validator interface
 */
public interface Validator {

    public boolean loginValidator(String login);

    public  boolean passwordValidator(String password);

    public  boolean emailValidator(String email);

}
