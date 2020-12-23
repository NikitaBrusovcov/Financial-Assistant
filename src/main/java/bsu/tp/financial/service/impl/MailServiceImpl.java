package bsu.tp.financial.service.impl;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;
import bsu.tp.financial.exception.ServiceException;
import bsu.tp.financial.service.MailService;
import bsu.tp.financial.service.OperationService;
import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MailServiceImpl implements MailService {
    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String EMAIL_FROM = "tprogapr@gmail.com";
    private static final String USERNAME = EMAIL_FROM;
    private static final String PASSWORD = "Nikkrein1";
    private final Properties prop = System.getProperties();

    private String emailTo;
    private String emailSubject = "Bank account statement";


    private void setProperties() {
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587"); // default port 587 (25)

    }

    private Message createMessage(Session session, String text) throws MessagingException {

        Message msg = new MimeMessage(session);

        // from
        msg.setFrom(new InternetAddress(EMAIL_FROM));
        // to
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo, false));
        // cc
        msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(EMAIL_FROM, false));
        // subject
        msg.setSubject(emailSubject);
        // content
        msg.setContent(text, "text/html");
        msg.setSentDate(new Date());
        return msg;
    }

    private void sendMailWithSMTP(Session session, Message message) throws MessagingException {
        // Get SMTPTransport
        SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
        // connect
        t.connect(SMTP_SERVER, USERNAME, PASSWORD);

        // send
        t.sendMessage(message, message.getAllRecipients());

        t.close();
    }

    private String createStatement(BankAccount bankAccount) {
        List<Operation> operations = bankAccount.getOperations();
        StringBuilder statement = new StringBuilder();
        statement.append("Statement of ").append(bankAccount.getTitle()).append("<br><br>");
        for (Operation operation : operations) {
            statement.append(operation.toString()).append("<br>");
        }
        return statement.toString();
    }

    @Override
    public void sendMail(String email, BankAccount bankAccount) {
        emailTo = email;
        setProperties();
        try {
            Session session = Session.getInstance(prop, null);
            Message message = createMessage(session, createStatement(bankAccount));
            sendMailWithSMTP(session, message);
        } catch (MessagingException ex) {
            throw new ServiceException("MailService failed", ex);
        }
    }
}
