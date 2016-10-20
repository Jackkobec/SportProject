package model.app_db.factory;

import model.IOActions;
import model.IOActionsImplement;

/**
 * todo lazy singleton
 */
public class ClassFactory {
    private IOActions ioActions = new IOActionsImplement();

    public IOActions getIoActions() {
        return ioActions;
    }
}
