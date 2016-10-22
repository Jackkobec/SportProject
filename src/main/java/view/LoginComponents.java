package view;


import controller.interfaces.UserController;
import controller.validation.Validator;
import model.app_db.UserDAO;
import model.exceptions.UserNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import static model.enums.JOptionsPaneEnums.ENUM_HELP;
import static model.enums.JOptionsPaneEnums.USER_NOT_FOUND;
import static model.enums.ValidationErrors.*;
import static view.ErrorValidationDialogs.errorValidationDialog;
import static view.JOptionPaneManager.showJOptionPane;


/**
 * LoginComponents
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */

public class LoginComponents extends JPanel
        implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";

    private JFrame controllingFrame; //needed for dialogs
    private JTextField loginField;
    private JPasswordField passwordField;

    private UserController userController;
    private UserDAO userDAO;
    private Validator validator;
    private JFrame globalParentFrame; //this is LoginForm all frame

    public LoginComponents(JFrame globalParentFrame, UserDAO userDAO, Validator validator, UserController userController) {
        this.userDAO = userDAO;
        this.validator = validator;
        this.userController = userController;
        this.globalParentFrame = globalParentFrame;
        //Use the default FlowLayout.
        //  controllingFrame = f;

//        loginField = new JTextField(10);
//
//
//        //Create everything.
//        passwordField = new JPasswordField(10);
//        passwordField.setActionCommand(OK);
//        passwordField.addActionListener(this);
//
//        JLabel login = new JLabel("Enter the Login: ");
//        login.setLabelFor(loginField);
//
//
//        JLabel label = new JLabel("Enter the password: ");
//        label.setLabelFor(passwordField);
        JComponent logPasPane = createFilds();
        JComponent buttonPane = createButtonPanel();
        ;
        //Lay out everything.
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));

//        textPane.add(login);
//        textPane.add(loginField);
//
//        textPane.add(label);
//        textPane.add(passwordField);

        // add(textPane);
        add(logPasPane);
        add(buttonPane);
        add(createregAndLoadPanel(globalParentFrame));

    }

    protected JComponent createFilds() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        p.setBackground(Color.orange);
        loginField = new JTextField(10);
        loginField.setActionCommand(OK);
        //всплывающая подсказка при фокусе
        loginField.setToolTipText("Enter your Login. Length: 3-15, Symbols: A-Z,a-z,0-9_");
        loginField.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
        });

        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.setToolTipText("Enter your Password. Length: 3-15, Symbols: A-Z,a-z,0-9_");
        passwordField.addActionListener(this);

        Font font = new Font("Tamoha", Font.BOLD, 16);
        JLabel loginLabel = new JLabel("Enter the Login: ");
        loginLabel.setFont(font);
        loginLabel.setLabelFor(loginField);


        JLabel pasLabel = new JLabel("Enter the password: ");
        pasLabel.setLabelFor(passwordField);
        pasLabel.setFont(font);
        p.add(loginLabel);
        p.add(loginField);

        p.add(pasLabel);
        p.add(passwordField);

        return p;
    }


    protected JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0, 1));

        JButton okButton = new JButton("OK");
        JButton helpButton = new JButton("Help");


        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);

        p.add(okButton);
        p.add(helpButton);

        return p;
    }

    protected JComponent createregAndLoadPanel(JFrame globalParentFrame) {
        JPanel regAndLoad = new JPanel(new GridLayout(0, 2));
        Font font = new Font("Tamoha", Font.BOLD, 16);

        JButton registerButton = new JButton("REGISTER");
        registerButton.setFont(font);
        registerButton.setForeground(Color.red);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new RegistrationForm(globalParentFrame, loginField.getText(), String.valueOf(passwordField.getPassword()), userDAO, validator, userController);
                try {
                    globalParentFrame.setVisible(false);
                    getParent().setVisible(false);
                    dispose();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton startFromFile = new JButton("START FROM PRIVATE FILE");
        startFromFile.setFont(font);
        startFromFile.setForeground(Color.green.darker());
        startFromFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
//                    int returnVal = new FileChooser().fc.showOpenDialog(new FileChooser());
//                    if (returnVal == JFileChooser.APPROVE_OPTION) {
//                        File file = new FileChooser().fc.getSelectedFile();
//                        new MainFrameTraining();
                    FileChooser fileChooser = new FileChooser();
                    int returnVal = fileChooser.fc.showDialog(null, "START FROM PRIVATE FILE");
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.fc.getSelectedFile();
                        new MainFrameTraining();

                        globalParentFrame.setVisible(false);
                        getParent().setVisible(false);
                        dispose();
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        regAndLoad.add(registerButton);
        regAndLoad.add(startFromFile);

        return regAndLoad;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        //String password = passwordField.getPassword().toString();
        String password = passwordField.getText(); //String.valueOf(passwordField);
        String login = loginField.getText();
        if (OK.equals(cmd)) {
            //Process the password.
//            if (loginField.getText().isEmpty() && password.isEmpty()) {
//                errorValidationDialog(LOGIN_AND_PASSWORD_IS_EMPTY);
//            } else if (validator.loginValidator(login) && validator.passwordValidator(password)) {
//                //todo User entering
//
//                    //userController.findUser(login, password);
//                    //userController.findUser(login, password);
//
//                JOptionPane.showMessageDialog(controllingFrame,
//                        "All is good.");
//
//            } else if (!validator.loginValidator(login)) {
//                errorValidationDialog(LOGIN_ERROR);
//            } else if (!validator.passwordValidator(password)) {
//                errorValidationDialog(PASSWORD_ERROR);
//            }
            if (loginField.getText().isEmpty() && password.isEmpty()) {
                errorValidationDialog(LOGIN_AND_PASSWORD_IS_EMPTY);
            } else if (!validator.loginValidator(login)) {
                errorValidationDialog(LOGIN_ERROR);
            } else if (!validator.passwordValidator(password)) {
                errorValidationDialog(PASSWORD_ERROR);
            } else if (validator.loginValidator(login) && validator.passwordValidator(password)) {
                //todo User entering
                try {
                    userController.findUser(login, password);
                    //globalParentFrame.setVisible(false);
                    globalParentFrame.dispose();
                    new TrainingSelectFrame(userController.findUser(login, password), userDAO, validator, userController);

                } catch (UserNotFoundException e1) {
                    showJOptionPane(USER_NOT_FOUND);
                }


                //launchBrowser(txtBrowserURILabel.getText());
//                JOptionPane.showMessageDialog(controllingFrame,
//                        "All is good.");

            }

        }
//repushing comment
        passwordField.selectAll();
        resetFocus();
        if (HELP.equals(cmd)) { //The user has asked for help.
            showJOptionPane(ENUM_HELP);
        }
    }


    /**
     * Checks the passed-in array against the correct password.
     * After this method returns, you should invoke eraseArray
     * on the passed-in array.
     */


    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = {'b', 'u', 'g', 'a', 'b', 'o', 'o'};

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            //compare 2 arrays: char[] correctPassword and input data
            isCorrect = Arrays.equals(input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword, '0');

        return isCorrect;
    }

    //Must be called from the event dispatch thread.
    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
   /* private static void createAndShowGUI() {


        //Create and set up the window.
        JFrame frame = new JFrame("LoginComponents");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        final LoginComponents newContentPane = new LoginComponents(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Make sure the focus goes to the right component
        //whenever the frame is initially given the focus.
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }*/
}
