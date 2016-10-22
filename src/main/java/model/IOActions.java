package model;

import java.io.IOException;

/**
 * IOActions
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public interface IOActions {
    public void writeInto(String path, String content) throws IOException;
}
