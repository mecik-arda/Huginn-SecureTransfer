package com.ardamecik.huginn.core.notification;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

public class EmailService {

    private final String username;
    private final String password;
    private final String DEVELOPER = "Arda Meçik";

    public EmailService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void sendTransferNotification(String to, String fileName, long size, String checksum) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("HUGINN SFT-Pro: Transfer Completed");

        String content = String.format("File: %s\nSize: %d bytes\nChecksum: %s\n\nSystem Engineered by %s", 
                                       fileName, size, checksum, DEVELOPER);
        message.setText(content);

        Transport.send(message);
    }
}
