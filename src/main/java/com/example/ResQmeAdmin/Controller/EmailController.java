package com.example.ResQmeAdmin.Controller;


import com.example.ResQmeAdmin.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/sendEmail")
    public void sendEmail(@RequestParam String email,
                          @RequestParam String subject,
                          @RequestParam String body){
        emailService.sendEmail(email,subject,body);
    }
}
