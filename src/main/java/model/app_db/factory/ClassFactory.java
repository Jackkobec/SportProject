package model.app_db.factory;

import model.IOActions;
import model.IOActionsImplement;

/**
 * ClassFactory
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class ClassFactory {
    private IOActions ioActions = new IOActionsImplement();

    public IOActions getIoActions() {
        return ioActions;
    }
}
