package com.gymer.gymer_rest_api.logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MailLogger {

    private static final Properties properties = new Properties();
    private static final File file = new File("src/main/resources/application.properties");
    private static MailLogger instance = null;

    public static MailLogger getInstance() {
        if (instance == null) {
            instance = new MailLogger();
        }
        return instance;
    }

    public void sendEmail(String userEmail, String mailSubject, String mailBody) throws MessagingException, IOException {
        properties.load(new FileInputStream(file));

        String username = properties.getProperty("mail.username");
        String password = properties.getProperty("mail.password");

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(userEmail));
        message.setSubject(mailSubject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(mailBody, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }

}
