package controller.internetActions.emailActions;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 * SMTPemailSender
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class SMTPemailSender {

    private Properties smtpProperties;
    private Session session;

    public SMTPemailSender() {
        smtpProperties = PropertiesContainerLoader.getProperties();

        session = Session.getInstance(smtpProperties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                smtpProperties.getProperty("sender.account.name"),
                                smtpProperties.getProperty("sender.account.pass"));
                    }
                });
    }

    public SMTPemailSender(String senderLogin, String senderPass) {

        smtpProperties = PropertiesContainerLoader.getProperties();
        smtpProperties.put("sender.account.name", senderLogin);
        smtpProperties.put("sender.account.pass", senderPass);

        session = Session.getInstance(smtpProperties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderLogin, senderPass);
                    }
                });
    }


    public boolean sentMessage(EmailLetterTemplate letter) {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(smtpProperties.getProperty("sender.account.name")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(letter.getEmailTo()));
            message.setSubject(letter.getSubject());
            message.setDescription(letter.getMessageBody());
            message.setText(letter.getSignature());

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
