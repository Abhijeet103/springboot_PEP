package com.example.CRUD.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {

    JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;

    }

    // html mail

    public String sendMail(String to, String subject, String text) {
        MailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        mailSender.send((MimeMessage) mailMessage);

        return "sent email" ;

    }
}
