package edu.mwsu.springframework.bookshare.service;

import edu.mwsu.springframework.bookshare.domain.BookAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{

    @Qualifier("getJavaMailSender")
    @Autowired
    public JavaMailSender emailSender;

    public void sendHash(BookAd bookAd, String email){

        if (bookAd.getEmail().toLowerCase().equals(email.toLowerCase())) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Your Secure Hash Key");
            message.setText(bookAd.getHashKey());
            emailSender.send(message);
        }
    }
}
