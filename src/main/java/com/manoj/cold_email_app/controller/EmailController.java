package com.manoj.cold_email_app.controller;

import com.manoj.cold_email_app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/send")
    public String send(
            @RequestParam String email,
            @RequestParam String subject,
            @RequestParam String template) {

        emailService.sendMail(
                email,
                subject,
                template);

        return "index";
    }
}