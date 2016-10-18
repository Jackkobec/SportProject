package view;

import controller.interfaces.UserController;
import controller.validation.Validator;
import model.app_db.UserDAO;
import model.app_db.factory.ClassFactory;
import model.enums.PrivateFileStatus;
import model.roles.Contacts;
import model.roles.User;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import static model.app_db.constants.Constants.PATH_FOR_SAVE_PRIVATE_FILE;
import static model.app_db.constants.Constants.PATH_FOR_SAVE_USER_REG_DATA;


/**
 * RegistrationForm
 */
public class RegistrationForm extends JFrame implements ActionListener {
    private UserController userController;
    private UserDAO userDAO;
    private Validator validator;


    FileSystemModel fileSystemDataModel = new FileSystemModel();
    JTree tree = new JTree(fileSystemDataModel);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int sizeWidth = 388;
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


    public RegistrationForm(JFrame f, String loginFromMain, String passFromMain, UserDAO userDAO, Validator validator, UserController userController) throws HeadlessException {
        this.userDAO = userDAO;
        this.validator = validator;
        this.userController = userController;//todo aaded controller

        setLayout(new BorderLayout());
        setTitle("Registration");

        setBounds(locationX, locationY, sizeWidth, sizeHeight);
        setMinimumSize(new Dimension(390, 480));


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

        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(CONFIRM);

        //set empty text on the password field
        passwordField.setText("");

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


        JLabel fioLabel = new JLabel("Enter your name: ");
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

        JLabel registerHelp = new JLabel("<html><font size=\"5\" color=\"red\" face=\"Arial\">Поля Login и password обязательны* к заполнению.</font>" +
                "<font size=\"4\">Так же Вы можете указать свой email " +
                "для использования функции отправки приватного файла и восстановления аккаунта.</font></html>");

        JPanel regCenterPanelForHelpInfo = new JPanel(new BorderLayout());
        regCenterPanelForHelpInfo.add(registerHelp);
        regCenterPanelForHelpInfo.setBackground(Color.ORANGE);
/**
 * test Tree File selector
 */
        JScrollPane scrollPaneForTreeFileSelector = new JScrollPane(tree);
        scrollPaneForTreeFileSelector.setSize(100, 50);
        scrollPaneForTreeFileSelector.setBorder(new CompoundBorder(new EmptyBorder(12, 12, 12, 12), new TitledBorder("Выберете место хранения приватного файла(выделете)")));
        scrollPaneForTreeFileSelector.setBackground(Color.ORANGE);
//selector end
        /**
         * test Tree File selector version 2
         */
        // JScrollPane scrollPaneForTreeFileSelector = new FileTree().init();

        /**
         *  selector end version 2
         */

        contentPane.setBackground(Color.ORANGE);
        contentPane.add(p, BorderLayout.NORTH);
        contentPane.add(scrollPaneForTreeFileSelector, BorderLayout.CENTER);//
        contentPane.add(regCenterPanelForHelpInfo, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String password = passwordField.getText();
        if (BACK.equals(cmd)) {
            dispose();
            new LoginForm(userDAO, validator, userController);
        }
        if (CONFIRM.equals(cmd)) {
            if (loginField.getText().isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Please enter login and password",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            } else if (validator.loginValidator(loginField.getText()) && validator.passwordValidator(password) &&
                    (email.getText().isEmpty() || validator.emailValidator(email.getText()))) {
                //todo User creation
                User registeredUser = new User(loginField.getText(), password, new Contacts(email.getText(), fioFild.getText()));
                // userDAO.createUser(registeredUser);//todo with controller
                if (null == tree.getLastSelectedPathComponent()) {
                    registeredUser.setPrivateFileStatus(PrivateFileStatus.UNSELECTED);
                } else try {
                    new ClassFactory().getIoActions().writeInto(PATH_FOR_SAVE_PRIVATE_FILE, tree.getLastSelectedPathComponent().toString());
                    registeredUser.setPrivateFilePath(tree.getLastSelectedPathComponent().toString());
                    registeredUser.setPrivateFileStatus(PrivateFileStatus.SELECTED_AND_SAVED);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                // userController.createUserCont(registeredUser);

                new TrainingSelectFrame(userController.createUserCont(registeredUser), userDAO, validator, userController);
                //System.out.println("regedUser" + regedUser);
                //new TrainingSelectFrame(regedUser, userDAO, validator, userController);
                System.out.println("getUsersFromDB: " + userController.getUsersFromDB());
                try {
                    new ClassFactory().getIoActions().writeInto(PATH_FOR_SAVE_USER_REG_DATA, registeredUser.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println("registeredUser: " + registeredUser);
                //выведление пути выделенной папки
                System.out.println(tree.getLastSelectedPathComponent());
                JOptionPane.showMessageDialog(controllingFrame,
                        "All is good.");
                dispose();
            } else if (!validator.loginValidator(loginField.getText())) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid login. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!validator.passwordValidator(password)) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid password. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!validator.emailValidator(email.getText())) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid email. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
