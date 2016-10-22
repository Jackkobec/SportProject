import controller.internetActions.emailActions.EmailLetterTemplate;
import controller.internetActions.emailActions.SMTPemailSender;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * EmailSenderTest
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class EmailSenderTest {
    private SMTPemailSender smtp;
    private EmailLetterTemplate emailLetterTemplate;

    @Before
    public  void InitData() {
        smtp = new SMTPemailSender("my.email.sender.java@gmail.com", "emailsender");
        emailLetterTemplate = new EmailLetterTemplate("forlabs@mail.ru", "Тема", "Тело письма", "Содержание письма");
    }

    @Test
    public void testEmailSenderPositive(){
        assertTrue(smtp.sentMessage(emailLetterTemplate));
    }
    @Test
    public void testEmailSenderNegative(){
        smtp = new SMTPemailSender("failer", "emailsender");
        assertFalse(smtp.sentMessage(emailLetterTemplate));
    }
}
