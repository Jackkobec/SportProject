package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controller.validation.LoginFormValidation.emailValidator;
import static controller.validation.LoginFormValidation.loginValidator;
import static controller.validation.LoginFormValidation.passwordValidator;

/**
 * RegistrationForm
 */
public class RegistrationForm extends JFrame implements ActionListener {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int sizeWidth = 380;
    public static int sizeHeight = 480;
    public int locationX = (screenSize.width - sizeWidth) / 2;
    public int locationY = (screenSize.height - sizeHeight) / 2;

    private static String CONFIRM = "confirm";
    private static String BACK = "back";
    private JFrame controllingFrame; //needed for dialogs

    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField fioFild;
    private JTextField email;


    public RegistrationForm(JFrame f, String loginFromMain, String passFromMain) throws HeadlessException {
        setLayout(new BorderLayout());
        setTitle("Registration");

        setBounds(locationX, locationY, sizeWidth, sizeHeight);
        setMinimumSize(new Dimension(380, 480));


        addComponents(f, getContentPane(), loginFromMain, passFromMain);
        getRootPane().setBackground(Color.orange);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    private void addComponents(final JFrame f, Container contentPane, String loginFromMain, String passFromMain) {
        contentPane.setLayout(new BorderLayout());

        JPanel p = new JPanel(new GridLayout(6, 2));
        p.setBackground(Color.orange);

        loginField = new JTextField(10);
        loginField.setActionCommand(CONFIRM);
        loginField.setText(loginFromMain);
        loginField.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
            }
        });

        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(CONFIRM);
//        if (passwordField.getPassword().toString() =="") {
//            passwordField.setText("");
//        } else {

        //set empty text on the password field
        passwordField.setText("");


        passwordField.addActionListener(this);

        fioFild = new JTextField(20);
        fioFild.setActionCommand(CONFIRM);


        email = new JTextField(16);
        email.setActionCommand(CONFIRM);


        Font font = new Font("Tamoha", Font.BOLD, 16);
        JLabel loginLabel = new JLabel("Enter new Login*: ");
        loginLabel.setFont(font);
        loginLabel.setForeground(Color.red);
        loginLabel.setLabelFor(loginField);


        JLabel pasLabel = new JLabel("Enter new password*: ");
        pasLabel.setLabelFor(passwordField);
        pasLabel.setFont(font);
        pasLabel.setForeground(Color.red);


        final JLabel fioLabel = new JLabel("Enter your name: ");
        fioLabel.setFont(font);
        fioLabel.setLabelFor(fioFild);

        JLabel emailLabel = new JLabel("Enter your email: ");
        emailLabel.setFont(font);
        emailLabel.setLabelFor(email);

        JButton confirmButton = new JButton("CONFIRM");
        JButton backButton = new JButton("BACK");

        //set command CONFIRM to this button
        confirmButton.setActionCommand(CONFIRM);
        //set action listener (this) means @Override actionPerformed
        confirmButton.addActionListener(this);

        //set command BACK to this button
        backButton.setActionCommand(BACK);
        //set action listener (this) means @Override actionPerformed
        backButton.addActionListener(this);

        p.add(loginLabel);
        p.add(loginField);

        p.add(pasLabel);
        p.add(passwordField);

        p.add(emailLabel);
        p.add(email);

        p.add(fioLabel);
        p.add(fioFild);

        p.add(backButton);
        p.add(confirmButton);

        //Font fontForRegisterHelp = new Font("Tamoha", Font.BOLD, 14);
        JLabel registerHelp = new JLabel("<html><font size=\"5\" color=\"red\" face=\"Arial\">Поля Login и password обязательны* к заполнению.</font>" +
                "<font size=\"4\">Так же Вы можете указать свой email " +
                "для использования функции отправки приватного файла и восстановления аккаунта.</font></html>");

        JPanel regCenterPanelForHelpInfo = new JPanel(new BorderLayout());
        regCenterPanelForHelpInfo.add(registerHelp);
        regCenterPanelForHelpInfo.setBackground(Color.ORANGE);

        contentPane.setBackground(Color.ORANGE);
        contentPane.add(p, BorderLayout.NORTH);
        contentPane.add(regCenterPanelForHelpInfo, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String password = passwordField.getText();
        if (BACK.equals(cmd)) {
            dispose();
            new LoginForm();
        }
        if (CONFIRM.equals(cmd)) {
            if (loginField.getText().isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Please enter login and password",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            } else if (loginValidator(loginField.getText()) && passwordValidator(password) &&
                    (email.getText().isEmpty() || emailValidator(email.getText()))) {
                //todo User creation
                JOptionPane.showMessageDialog(controllingFrame,
                        "All is good.");
            } else if (!loginValidator(loginField.getText())) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid login. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                //send request for compare 2 arrays
            } else if (!passwordValidator(password)) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid password. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!emailValidator(email.getText())) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid email. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
