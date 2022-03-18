package com.example.ResQmeAdmin.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String email, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("resqmeservices@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
    }


}
