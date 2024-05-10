package com.example.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Description This class provides an email service for the application.
 * It uses the JavaMailSender within the SpringBoot framework to send emails.
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@Service
public class EmailService {

    // The JavaMailSender instance used to send emails
    @Autowired
    private JavaMailSender mailSender;

    /**
     * Send an email with the given recipient, subject, and body.
     * @param to The recipient of the email
     * @param subject The subject of the email
     * @param body The body of the email
     */
    public void sendEmail(String to, String subject, String body) {
        //use JavaMailSender within SpringBoot framework to send an email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        // use my email account for testing
        message.setFrom("dinghangz2023@163.com");
        mailSender.send(message);
    }
}
