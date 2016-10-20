package view;

import model.enums.ValidationErrors;

import javax.swing.*;

/**
 * Created by Jack on 20.10.2016.
 */
public class ErrorValodationDialogs {
    private static JFrame controllingFrame; //needed for dialogs

    public static void errorValidationDialog(ValidationErrors validationError) {
        switch (validationError) {
            case LOGIN_ERROR:

                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid login. Try again.\nEnter your Login. Length: 3-15, Symbols: A-Z,a-z,0-9_",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                break;

            case PASSWORD_ERROR:
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid password. Try again.\nEnter your Password. Length: 3-15, Symbols: A-Z,a-z,0-9_",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                break;

            case EMAIL_ERROR:
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid email. Try again.\nEnter your Email. Example: sport@gmail.com",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                break;


            case LOGIN_AND_PASSWORD_IS_EMPTY:
                JOptionPane.showMessageDialog(controllingFrame,
                        "Enter Login and Password.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}