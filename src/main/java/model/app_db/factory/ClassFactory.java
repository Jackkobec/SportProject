package model.app_db.factory;

import model.IOActions;
import model.IOActionsImplement;

/**
 * Created by Jack on 16.10.2016.
 */
public class ClassFactory {
    private IOActions ioActions = new IOActionsImplement();

    public IOActions getIoActions() {
        return ioActions;
    }
}
