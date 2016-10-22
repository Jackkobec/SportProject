package view;

import controller.interfaces.UserController;
import controller.validation.Validator;
import model.app_db.UserDAO;
import model.app_db.factory.ClassFactory;
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
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import static javax.swing.JFileChooser.DIRECTORIES_ONLY;
import static model.app_db.constants.MyConstants.BACK_ON_CLOSE;
import static model.app_db.constants.MyConstants.PATH_FOR_SAVE_USER_REG_DATA;
import static model.enums.PrivateFileStatus.SELECTED_AND_SAVED;
import static model.enums.PrivateFileStatus.UNSELECTED;
import static model.enums.ValidationErrors.*;
import static view.ErrorValidationDialogs.errorValidationDialog;

/**
 * UserUpdateForm
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class UserUpdateForm extends JFrame implements ActionListener {
    private int defaultCloseOperation = HIDE_ON_CLOSE;


    private JFrame parentFrame;
    private UserController userController;
    private UserDAO userDAO;
    private Validator validator;
    private User currentUser;

    private FileSystemModel fileSystemDataModel = new FileSystemModel();
    private JTree tree = new JTree(fileSystemDataModel);

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int sizeWidth = 388;
    private static int sizeHeight = 480;
    private int locationX = (screenSize.width - sizeWidth) / 2;
    private int locationY = (screenSize.height - sizeHeight) / 2;

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

    private String statusPtivateFile;

    public UserUpdateForm(JFrame f, User currentUser, UserDAO userDAO, Validator validator, UserController userController) throws HeadlessException {
        this.parentFrame = f;
        this.userDAO = userDAO;
        this.validator = validator;
        this.userController = userController;//todo added controller
        this.currentUser = currentUser;
        setLayout(new BorderLayout());
        setTitle("Update User Info");

        setBounds(locationX, locationY, sizeWidth, sizeHeight);
        setMinimumSize(new Dimension(390, 480));


        addComponents(f, getContentPane());
        getRootPane().setBackground(Color.orange);
        setVisible(true);
        setDefaultCloseOperation(BACK_ON_CLOSE);
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        if (operation != DO_NOTHING_ON_CLOSE &&
                operation != HIDE_ON_CLOSE &&
                operation != DISPOSE_ON_CLOSE &&
                operation != EXIT_ON_CLOSE &&
                operation != BACK_ON_CLOSE) {
            throw new IllegalArgumentException("defaultCloseOperation must be one of: DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE, or EXIT_ON_CLOSE");
        }

        if (operation == EXIT_ON_CLOSE) {
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkExit(0);
            }
        }
        if (this.defaultCloseOperation != operation) {
            int oldValue = this.defaultCloseOperation;
            this.defaultCloseOperation = operation;
            firePropertyChange("defaultCloseOperation", oldValue, operation);
        }
    }

    @Override
    protected void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            switch (defaultCloseOperation) {
                case HIDE_ON_CLOSE:
                    setVisible(false);
                    break;
                case DISPOSE_ON_CLOSE:
                    dispose();
                    break;
                case EXIT_ON_CLOSE:
                    // This needs to match the checkExit call in
                    // setDefaultCloseOperation
                    System.exit(0);
                    break;
                case DO_NOTHING_ON_CLOSE:
                    //My CloseOperation - to do back when close clicked
                case BACK_ON_CLOSE:
                    dispose();
                    new TrainingSelectFrame(currentUser, userDAO, validator, userController);
                    break;
                default:
            }
        }
    }

    public void addComponents(JFrame f, Container contentPane) {
        contentPane.setLayout(new BorderLayout());

        JPanel p = new JPanel(new GridLayout(7, 2));

        p.setBackground(Color.orange);

        loginField = new JTextField(10);
        loginField.setActionCommand(CONFIRM);
        loginField.setToolTipText("Enter your Login. Length: 3-15, Symbols: A-Z,a-z,0-9_");

        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(CONFIRM);
        passwordField.setToolTipText("Enter your Password. Length: 3-15, Symbols: A-Z,a-z,0-9_");
        //set empty text on the password field
        passwordField.setText("");

        fioFild = new JTextField(20);
        fioFild.setActionCommand(CONFIRM);
        fioFild.setToolTipText("Enter your Name. Example: Jack");

        email = new JTextField(16);
        email.setActionCommand(CONFIRM);
        email.setToolTipText("Enter your Email. Example: sport@gmail.com");

        phone = new JTextField(16);
        phone.setActionCommand(CONFIRM);
        phone.setToolTipText("Enter your Phone. Example: 077 777 77 77");

        address = new JTextField(22);
        address.setActionCommand(CONFIRM);
        address.setToolTipText("Enter your Address. Example: Shevchenko str. 7");

        //auto-complete data
        if (null != currentUser) {
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
        statusPtivateFile = (currentUser.getPrivateFileStatus() == UNSELECTED ? "<font size=\"5\" color=\"red\">Место хранения приватного файла НЕ выбрано!</font>" :
                "<font size=\"5\">Место расположения Приватного Файла: " + "<font size=\"5\" color=\"red\">" + currentUser.getPrivateFilePath()) + "</font></font>";
        JLabel fileSelectionStatusInfo = new JLabel("<html>" + statusPtivateFile + "</html>");

        JPanel changePathButtonPanel = new JPanel();
        //Panel for changePrivateFilePathButton
        JButton changePrivateFilePathButton = new JButton("Задать/Изменить место хранения Пиватного Файла");

        changePathButtonPanel.add(changePrivateFilePathButton);
        changePathButtonPanel.setBackground(Color.ORANGE);

        fileSelectionSttusAndProposePanel.add(fileSelectionStatusInfo, BorderLayout.NORTH);
        fileSelectionSttusAndProposePanel.add(changePathButtonPanel, BorderLayout.SOUTH);

        changePrivateFilePathButton.setActionCommand(CHANGE_PATH);
        //for dynamic fileSelectionStatusInfo changing
        int[] count = {1};
        JLabel[] tempLabel = new JLabel[1];

        changePrivateFilePathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count[0]++;
                System.out.println(count[0]);
                JLabel[] jl = new JLabel[count[0]];
                String cmd = e.getActionCommand();
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
                        currentUser.setPrivateFileStatus(SELECTED_AND_SAVED);
                        System.out.println(file.getAbsolutePath());
                        System.out.println(currentUser);
                        //dynamic fileSelectionStatusInfo changing
                        statusPtivateFile = (currentUser.getPrivateFileStatus() == UNSELECTED ? "<font size=\"5\" color=\"red\">Место хранения приватного файла НЕ выбрано!</font>" :
                                "<font size=\"5\">Место расположения Приватного Файла: " + "<font size=\"5\" color=\"red\">" + file.getAbsolutePath()) + "</font></font>";
                        fileSelectionStatusInfo.setVisible(false);
                        if (count[0] == 2) {
                            jl[count[0] - 1] = new JLabel("<html>" + statusPtivateFile + "</html>");
                            tempLabel[0] = jl[count[0] - 1];
                            fileSelectionSttusAndProposePanel.add(tempLabel[0], BorderLayout.NORTH);
                            fileSelectionSttusAndProposePanel.revalidate();
                        } else if (count[0] > 2)
                            tempLabel[0].setVisible(false);
                        jl[count[0] - 1] = new JLabel("<html>" + statusPtivateFile + "</html>");
                        tempLabel[0] = jl[count[0] - 1];
                        fileSelectionSttusAndProposePanel.add(tempLabel[0], BorderLayout.NORTH);

                        if (returnVal == JFileChooser.CANCEL_OPTION) {
                            return;
                        }

                    }

                }
            }
        });

//selectorStatus end

        contentPane.setBackground(Color.ORANGE);
        contentPane.add(p, BorderLayout.NORTH);
        contentPane.add(fileSelectionSttusAndProposePanel, BorderLayout.CENTER);//
        contentPane.add(regCenterPanelForHelpInfo, BorderLayout.SOUTH);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        User updatedUser = currentUser;
        String cmd = e.getActionCommand();
        String password = passwordField.getText();
        if (BACK.equals(cmd)) {
            dispose();
            new TrainingSelectFrame(currentUser, userDAO, validator, userController);
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
                updatedUser = new User(loginField.getText(), password, new Contacts(email.getText(), fioFild.getText()));
                try {
                    if (!currentUser.getPrivateFilePath().isEmpty()) {
                        updatedUser.setPrivateFilePath(currentUser.getPrivateFilePath());
                        updatedUser.setPrivateFileStatus(SELECTED_AND_SAVED);
                    } else updatedUser.setPrivateFileStatus(UNSELECTED);
                } catch (NullPointerException ignored) {

                }
                updatedUser.setId(currentUser.getId());
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
                errorValidationDialog(LOGIN_ERROR);

            } else if (!validator.passwordValidator(password)) {
                errorValidationDialog(PASSWORD_ERROR);

            } else if (!validator.emailValidator(email.getText())) {
                errorValidationDialog(EMAIL_ERROR);
            }
            dispose();
            new TrainingSelectFrame(currentUser, userDAO, validator, userController);
        }


    }
}
