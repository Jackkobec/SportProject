package view;

import controller.interfaces.UserControler;
import controller.validation.Validator;
import model.app_db.AppDB;
import model.app_db.UserDAO;
import model.app_db.factory.ClassFactory;
import model.enums.PrivateFileStatus;
import model.roles.Contacts;
import model.roles.User;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import static javax.swing.JFileChooser.DIRECTORIES_ONLY;
import static model.app_db.constants.Constants.PATH_FOR_SAVE_PRIVATE_FILE;
import static model.app_db.constants.Constants.PATH_FOR_SAVE_USER_REG_DATA;
import static model.enums.PrivateFileStatus.UNSELECTED;

/**
 * Created by Jack on 16.10.2016.
 */
public class UserUpdateForm extends JFrame implements ActionListener {

    private UserControler userController;
    private UserDAO userDAO;
    private Validator validator;
    private User currentUser;

    FileSystemModel fileSystemDataModel = new FileSystemModel();
    JTree tree = new JTree(fileSystemDataModel);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int sizeWidth = 388;
    public static int sizeHeight = 480;
    public int locationX = (screenSize.width - sizeWidth) / 2;
    public int locationY = (screenSize.height - sizeHeight) / 2;

    private static String CONFIRM = "confirm";
    private static String BACK = "back";
    private static String CHANGE_PATH = "change path";
    private JFrame controllingFrame; //needed for dialogs

    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField fioFild;
    private JTextField email;
    private JTextField phone;
    private JTextField address;

    public UserUpdateForm(JFrame f, User currentUser, UserDAO userDAO, Validator validator, UserControler userController) throws HeadlessException {
        this.userDAO = userDAO;
        this.validator = validator;
        this.userController = userController;//todo aaded controller
        this.currentUser = currentUser;
        setLayout(new BorderLayout());
        setTitle("Registration");

        setBounds(locationX, locationY, sizeWidth, sizeHeight);
        setMinimumSize(new Dimension(390, 480));


        addComponents(f, getContentPane());
        getRootPane().setBackground(Color.orange);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addComponents(final JFrame f, Container contentPane) {
        contentPane.setLayout(new BorderLayout());

        JPanel p = new JPanel(new GridLayout(7, 2));

        p.setBackground(Color.orange);

        loginField = new JTextField(10);
        loginField.setActionCommand(CONFIRM);

        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(CONFIRM);

        //set empty text on the password field
        passwordField.setText("");

        fioFild = new JTextField(20);
        fioFild.setActionCommand(CONFIRM);

        email = new JTextField(16);
        email.setActionCommand(CONFIRM);

        phone = new JTextField(16);
        phone.setActionCommand(CONFIRM);

        address = new JTextField(22);
        address.setActionCommand(CONFIRM);
        //auto-complete data
        if(null != currentUser){
            loginField.setText(currentUser.getLogin());
            passwordField.setText(currentUser.getPassword());
            fioFild.setText(currentUser.getContacts().getName());
            email.setText(currentUser.getContacts().getEmail());
            phone.setText(currentUser.getContacts().getPhone());
            address.setText(currentUser.getContacts().getAdress());
        }

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

        JLabel phoneLabel = new JLabel("Enter your phone: ");
        phoneLabel.setFont(font);
        phoneLabel.setLabelFor(phone);

        JLabel addressLabel = new JLabel("Enter your address: ");
        addressLabel.setFont(font);
        addressLabel.setLabelFor(address);

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

        p.add(phoneLabel);
        p.add(phone);

        p.add(addressLabel);
        p.add(address);

        p.add(backButton);
        p.add(confirmButton);

        JLabel registerHelp = new JLabel("<html><font size=\"5\" color=\"red\" face=\"Arial\">Поля Login и password обязательны* к заполнению.</font>" +
                "<font size=\"4\">Так же Вы можете указать свой email " +
                "для использования функции отправки приватного файла и восстановления аккаунта.</font></html>");

        JPanel regCenterPanelForHelpInfo = new JPanel(new BorderLayout());
        regCenterPanelForHelpInfo.add(registerHelp);
        regCenterPanelForHelpInfo.setBackground(Color.ORANGE);
/**
 * Panel with info about PrivateFile status and chose propose
 */
        JPanel fileSelectionSttusAndProposePanel = new JPanel(new BorderLayout());
        fileSelectionSttusAndProposePanel.setBorder(new CompoundBorder(new EmptyBorder(12, 12, 12, 12), new TitledBorder("Информация про приватный файл")));
        fileSelectionSttusAndProposePanel.setBackground(Color.ORANGE);
        String status = (currentUser.getPrivateFileStatus() == UNSELECTED ? "<font size=\"5\" color=\"red\">Место хранения приватного файла НЕ выбрано!</font>" :
                "<font size=\"5\">Место расположения Приватного Файла: " + "<font size=\"5\" color=\"red\">" + currentUser.getPrivateFilePath()) + "</font></font>";
        JLabel fileSelectionSttusInfo = new JLabel("<html>" + status + "</html>");

        JPanel changePathButtonPanel = new JPanel();
        //Panel for changePrivateFilePathButton
        JButton changePrivateFilePathButton = new JButton("Задать/Изменить место хранения Пиватного Файла");
        changePrivateFilePathButton.setActionCommand(CHANGE_PATH);
        changePrivateFilePathButton.addActionListener(this);
        changePathButtonPanel.add(changePrivateFilePathButton);
        changePathButtonPanel.setBackground(Color.ORANGE);

        fileSelectionSttusAndProposePanel.add(fileSelectionSttusInfo, BorderLayout.NORTH);
        fileSelectionSttusAndProposePanel.add(changePathButtonPanel, BorderLayout.SOUTH);
//selectorStatus end

        contentPane.setBackground(Color.ORANGE);
        contentPane.add(p, BorderLayout.NORTH);
        contentPane.add(fileSelectionSttusAndProposePanel, BorderLayout.CENTER);//
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
                //todo User update
                User updatedUser = new User(loginField.getText(), password, new Contacts(email.getText(), fioFild.getText()));
                updatedUser.setId(currentUser.getId());
                if (null == tree.getLastSelectedPathComponent()) {
                    updatedUser.setPrivateFileStatus(UNSELECTED);
                } else try {
                    new ClassFactory().getIoActions().writeInto(PATH_FOR_SAVE_PRIVATE_FILE, tree.getLastSelectedPathComponent().toString());
                    updatedUser.setPrivateFileStatus(PrivateFileStatus.SELECTED_AND_SAVED);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println("before update: " + currentUser);
                currentUser = userController.updateUserCont(updatedUser);
                System.out.println("after update: " + currentUser);
                System.out.println("getUsersFromDB: " + userController.getUsersFromDB());
                try {
                    new ClassFactory().getIoActions().writeInto(PATH_FOR_SAVE_USER_REG_DATA, updatedUser.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //выведление пути выделенной папки
                System.out.println(tree.getLastSelectedPathComponent());
                JOptionPane.showMessageDialog(controllingFrame,
                        "All is good.");
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
        if (CHANGE_PATH.equals(cmd)) {

            FileChooser fileChooser = new FileChooser();
            //disable the all extention selection
            fileChooser.fc.setAcceptAllFileFilterUsed(false);
            //filter for extention *.TRN
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TRN", "*.*");
            fileChooser.fc.setFileFilter(filter);
            //select DIRECTORIES_ONLY
            fileChooser.fc.setFileSelectionMode(DIRECTORIES_ONLY);

            int returnVal = fileChooser.fc.showDialog(null, "Select");
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.fc.getSelectedFile();
                currentUser.setPrivateFilePath(file.getAbsolutePath());
                System.out.println(file.getAbsolutePath());


            }

        }

    }
}
