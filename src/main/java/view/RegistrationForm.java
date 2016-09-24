package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField fioFild;
    private JTextField email;


    public RegistrationForm(JFrame f, String loginFromMain, String passFromMain) throws HeadlessException {
        setLayout(new BorderLayout());
        setTitle("Registration");

        setBounds(locationX, locationY, sizeWidth, sizeHeight);


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
        passwordField.setText(passFromMain);
        passwordField.addActionListener(this);

        fioFild = new JTextField(20);
        fioFild.setActionCommand(CONFIRM);
        fioFild.setText(loginFromMain);

        email = new JTextField(16);
        email.setActionCommand(CONFIRM);
        email.setText(loginFromMain);

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

        confirmButton.setActionCommand(CONFIRM);
        backButton.setActionCommand(BACK);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

dispose();
                    new LoginForm();

            }});



        p.add(loginLabel);
        p.add(loginField);

        p.add(pasLabel);
        p.add(passwordField);

        p.add(fioLabel);
        p.add(fioFild);

        p.add(emailLabel);
        p.add(email);

        p.add(backButton);
        p.add(confirmButton);


        contentPane.add(p, BorderLayout.PAGE_START);

    }

    public void actionPerformed(ActionEvent e) {

    }

}
