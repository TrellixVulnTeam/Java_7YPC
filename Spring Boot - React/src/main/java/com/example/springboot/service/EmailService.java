package com.example.springboot.service;

public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);

    void sendMimeMessage(String to,
                           String subject,
                           String text);
}
