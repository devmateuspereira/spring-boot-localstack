package br.com.mateuspereirajorge.sns.controller;

import br.com.mateuspereirajorge.sns.service.SnsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sns")
public class SnsController {

    @Autowired
    private SnsNotificationService notificationService;

    @PostMapping("/topicMessage")
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        notificationService.sendNotification("Subject: Hello", message, null);
        return ResponseEntity.ok("Message sent to SNS successfully.");
    }

}