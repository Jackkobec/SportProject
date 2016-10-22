package view;

import controller.interfaces.UserController;
import controller.validation.Validator;
import model.app_db.UserDAO;
import model.roles.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static model.enums.JOptionsPaneEnums.ENUM_LOGOUT;
import static view.JOptionPaneManager.showJOptionPane;

/**
 * TrainingSelectFrame
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class TrainingSelectFrame extends MainFrame implements ActionListener {
    private User loginedCurrentUser;
    private UserController userController;
    private UserDAO userDAO;
    private Validator validator;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int sizeWidth = 800;
    private static int sizeHeight = 600;
    private int locationX = (screenSize.width - sizeWidth) / 2;
    private int locationY = (screenSize.height - sizeHeight) / 2;

    private static String LOGOUT = "Logout";
    private static String EDIT = "Edit";

    public TrainingSelectFrame(User loginedCurrentUser, UserDAO userDAO, Validator validator, UserController userController) throws HeadlessException {
        this.loginedCurrentUser = loginedCurrentUser;
        this.userDAO = userDAO;
        this.validator = validator;
        this.userController = userController;//todo aaded controller

        setLayout(new BorderLayout());
        setTitle("Sport Application");

        setBounds(locationX, locationY, sizeWidth, sizeHeight);
        //set minimal size of window
        setMinimumSize(new Dimension(800, 600));

        addComponents(getContentPane());
        getRootPane().setBackground(Color.orange);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    //setter for change user
    public void setLoginedCurrentUser(User loginedCurrentUser) {
        this.loginedCurrentUser = loginedCurrentUser;
    }

    private void addComponents(Container contentPane) {
        contentPane.setLayout(new BorderLayout());

        MainFrameMenu mfm = new MainFrameMenu();
        JMenuBar menuBar = mfm.createMenuBar();
        menuBar.setBackground(Color.ORANGE.brighter());

        JPanel innerTrainingPanelForCenter = new JPanel(new BorderLayout());
        //вернхние кнопки логаунт и тд тут же будет инфа про профиль юзера
        JPanel innerTrainingPanelNorthPanel = new JPanel(new BorderLayout());

        JButton logoutButton = new JButton("LogOut");
        logoutButton.setActionCommand(LOGOUT);
        logoutButton.addActionListener(this);

        //панель и отображением логина юзера
        JPanel userProfilePanel = new JPanel(new BorderLayout());
        //панель для отображения логина юзера и кнопки Edit
        JPanel userProfileInnerPanelForButtonsEdit = new JPanel(new GridLayout());

        JLabel userLabel = new JLabel("User: " + loginedCurrentUser.getLogin() + "  ");
        JButton userEditButton = new JButton("Edit");
        userEditButton.setActionCommand(EDIT);
        userEditButton.addActionListener(this);

        userProfileInnerPanelForButtonsEdit.add(userLabel);
        userProfileInnerPanelForButtonsEdit.add(userEditButton);
        //current date on the format: 18 октября 2016
        JLabel dateLabel = new JLabel("   " + LocalDate.now().format(DateTimeFormatter.ofPattern("d MMMM uuuu")));

        userProfilePanel.add(userProfileInnerPanelForButtonsEdit, BorderLayout.EAST);

        innerTrainingPanelNorthPanel.add(dateLabel, BorderLayout.WEST);
        innerTrainingPanelNorthPanel.add(userProfilePanel, BorderLayout.CENTER);
        innerTrainingPanelNorthPanel.add(logoutButton, BorderLayout.EAST);


        innerTrainingPanelForCenter.add(innerTrainingPanelNorthPanel, BorderLayout.NORTH);

        contentPane.add(menuBar, BorderLayout.NORTH);
        contentPane.add(innerTrainingPanelForCenter, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (EDIT.equals(cmd)) {
            new UserUpdateForm(this, loginedCurrentUser, userDAO, validator, userController);
            dispose();
        }
        if (LOGOUT.equals(cmd)) {
            int n = showJOptionPane(ENUM_LOGOUT);
            //проверяем если нисего не было выбрано и был нажат крестик - то просто закрываем диалог и возвращаемся в программу
            if (n == 1 || n == -1) {
                return;
            } else {
                dispose();
                new LoginForm(userDAO, validator, userController);
            }
        }
    }
}
