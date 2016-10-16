package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jack on 16.10.2016.
 */
public class IOActionsImplement implements IOActions {

    /**
     * Write info to the file
     */
    @Override
    public void writeInto(String path, String content) throws IOException {

        File file = new File(path);
        //check file present, create new if not
        if (!file.exists()) {
            file.createNewFile();
        }
        //create output stream
        try (BufferedWriter out = new BufferedWriter(new PrintWriter(file.getAbsoluteFile()))) {

            out.write(content);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
