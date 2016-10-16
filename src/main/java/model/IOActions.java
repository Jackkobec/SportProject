package model;

import java.io.IOException;

/**
 * Created by Jack on 16.10.2016.
 */
public interface IOActions {
    public void writeInto(String path, String content) throws IOException;
}
