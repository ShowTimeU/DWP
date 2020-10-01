package com.dontwaste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void sendMail(String mailTo, String subject, String htmlMessage){

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

        try {
            helper.setText(htmlMessage, true);/** Use this or message.setContent(htmlMessage, "text/html"); **/
            helper.setTo(mailTo);
            helper.setSubject(subject);
            helper.setFrom(username);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(message);
    }

}
