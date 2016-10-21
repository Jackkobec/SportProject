import controller.internetActions.emailActions.EmailLetterTemplate;
import controller.internetActions.emailActions.SMTPemailSender;

import java.net.MalformedURLException;

/**
 * QuikTests
 */
public class QuikTests {


    public static void main(String[] args) throws MalformedURLException {
//        File[] froots = File.listRoots();
//        for (int i = 0; i <froots.length ; i++) {
//            System.out.println(froots[i].getPath());
//        }

//        Desktop desktop;
//        if (Desktop.isDesktopSupported()) {
//            desktop = Desktop.getDesktop();
//            if (desktop.isSupported(Desktop.Action.BROWSE)) {
//                // launch browser
//                URI uri;
//                try {
//                    uri = new URI("https://" + "github.com/Jackkobec");
//                    desktop.browse(uri);
//                }
//                catch (IOException ioe) {
//                    ioe.printStackTrace();
//                }
//                catch (URISyntaxException use) {
//                    use.printStackTrace();
//                }
//            }
//        }
        // runbr();

        SMTPemailSender smtp = new SMTPemailSender("my.email.sender.java@gmail.com", "emailsender");
        System.out.println((smtp.sentMessage(new EmailLetterTemplate("forlabs@mail.ru", "Тема", "Тело письма", "Сигнатура письма"))) ? "Письмо успешно отправлено" :
                "Ошибка отпраки");
    }
}
