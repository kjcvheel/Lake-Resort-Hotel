package com.capgemini.molvenoresort.services;

import com.capgemini.molvenoresort.models.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(Guest guest) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("kevinvanheel94@hotmail.com");
        mail.setFrom("kevinmolveno@gmail.com");
        mail.setSubject("Booking confirmation Molveno");
        mail.setText("This is a test email");
        System.out.println("The email address of the booker is " + guest.getEmail());
        javaMailSender.send(mail);
    }
}
