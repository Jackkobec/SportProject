package model.exceptions;

/**
 * Created by Jack on 20.10.2016.
 */
public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String s) {
        super(s);
    }
}
