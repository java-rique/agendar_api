package com.javarique.agendar.api.emailservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
    public class EmailService {
        @Autowired
        private JavaMailSender sender;

    public EmailService (JavaMailSender sender) {
        this.sender = sender;
    }

    public void enviar(String para, String assunto, String texto) {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(para);
            email.setSubject(assunto);
            email.setText(texto);
            email.setFrom("fh2133967@gmail.com");
            sender.send(email);
        }
    }



