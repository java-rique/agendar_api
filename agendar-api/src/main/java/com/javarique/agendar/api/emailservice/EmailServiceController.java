package com.javarique.agendar.api.emailservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailServiceController {


    public EmailServiceController(EmailService emailService) {
        this.emailService = emailService;
    }

    private final EmailService emailService;

    @GetMapping("/email/teste")
    public String teste() {
        emailService.enviar(
                "vitoriabarbosa1702@gmail.com",
                "Primeiro email funcionando 🎉",
                "Fabio, seu sistema agora envia email como empresa 😎🔥"
        );

        return "Email enviado!";
    }

}
