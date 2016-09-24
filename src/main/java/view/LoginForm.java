package view;

import javax.swing.*;
import java.awt.*;

/**
 * LoginForm
 */
public class LoginForm extends JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int sizeWidth = 640;
    public static int sizeHeight = 480;
    public int locationX = (screenSize.width - sizeWidth) / 2;
    public int locationY = (screenSize.height - sizeHeight) / 2;


    public LoginForm() throws HeadlessException {


        setLayout(new BorderLayout());
        setTitle("LoginForm");

//        setLocationRelativeTo(dialog);
//        setPreferredSize(new Dimension(640, 480));
//
//        pack();
        setBounds(locationX, locationY, sizeWidth, sizeHeight);


        addComponents(getContentPane());
        getRootPane().setBackground(Color.orange);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    private void addComponents(Container contentPane) {

        contentPane.setLayout(new BorderLayout());
        JComponent logpas = new LoginComponents(this);
        logpas.getAncestorListeners();
       /* float[] hsb = Color.RGBtoHSB(255, 99, 00, null);
        logpas.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));*/

        Font font = new Font("Tamoha", Font.BOLD, 28);

        JLabel welcomeLabel = new JLabel("<html><br>WELCOME TO THE SPORT APPLICATION<br><br><br><br></html>");
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setBackground(Color.orange);
        welcomeLabel.setOpaque(true);
        // welcomeLabel.setForeground(Color.green.darker());
        welcomeLabel.setFont(font);
        contentPane.add(welcomeLabel, BorderLayout.PAGE_START);

        JPanel registrationOrLoadFromFile = new JPanel(new FlowLayout(FlowLayout.LEFT));
        registrationOrLoadFromFile.setBackground(Color.orange);
        JButton okButton = new JButton("UPDATE FROM SERVER");

        registrationOrLoadFromFile.add(okButton);

        contentPane.add(registrationOrLoadFromFile, BorderLayout.SOUTH);


        JComponent logpas2 = new LoginComponents(this);
        logpas.setBackground(Color.orange);
        contentPane.add(logpas, BorderLayout.CENTER);
    }


    private void init() {

    }


}
