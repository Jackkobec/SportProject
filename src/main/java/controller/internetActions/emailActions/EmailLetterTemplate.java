package controller.internetActions.emailActions;
/**
 * EmailLetterTemplate
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class EmailLetterTemplate {
    private String emailTo;
    private String subject;
    private String messageBody;
    private String signature;

    public EmailLetterTemplate() {
    }

    public EmailLetterTemplate(String emailTo, String subject, String messageBody, String signature) {
        this.emailTo = emailTo;
        this.subject = subject;
        this.messageBody = messageBody;
        this.signature = signature;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
