package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Arrays;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/* LoginComponents.java requires no other files. */

public class LoginComponents extends JPanel
        implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";

    private JFrame controllingFrame; //needed for dialogs
    private JTextField loginField;
    private JPasswordField passwordField;

    public LoginComponents(JFrame f) {
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
        add(createregAndLoadPanel(f));

    }

    protected JComponent createFilds() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        p.setBackground(Color.orange);
        loginField = new JTextField(10);
        loginField.setActionCommand(OK);
        loginField.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
        });

        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
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

    protected JComponent createregAndLoadPanel(final JFrame f) {
        JPanel regAndLoad = new JPanel(new GridLayout(0, 2));
        Font font = new Font("Tamoha", Font.BOLD, 16);

        JButton registerButton = new JButton("REGISTER");
        registerButton.setFont(font);
        registerButton.setForeground(Color.red);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new RegistrationForm(f, loginField.getText(), passwordField.getPassword().toString());
                try {
                    f.setVisible(false);
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
                int returnVal = new FileChooser().fc.showOpenDialog(new FileChooser());
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = new FileChooser().fc.getSelectedFile();
                    new MainFrameTraining();

                    f.setVisible(false);
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

        if (OK.equals(cmd)) { //Process the password.
            char[] input = passwordField.getPassword();
            if (isPasswordCorrect(input)) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Success! You typed the right password.");
            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid password. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }

            //Zero out the possible password, for security.
            Arrays.fill(input, '0');

            passwordField.selectAll();
            resetFocus();
        } else { //The user has asked for help.
            JOptionPane.showMessageDialog(controllingFrame,
                    "You can get the password by searching this example's\n"
                            + "source code for the string \"correctPassword\".\n"
                            + "Or look at the section How to Use Password Fields in\n"
                            + "the components section of The Java Tutorial.");
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
    private static void createAndShowGUI() {


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
    }
}
