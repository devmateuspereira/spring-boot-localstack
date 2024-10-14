package br.com.mateuspereirajorge.sqs.controller;

import br.com.mateuspereirajorge.sqs.service.SqsMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sqs")
public class SqsController {

    @Autowired
    private SqsMessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        messageService.sendMessage(message);
        return ResponseEntity.ok("Message sent to SQS successfully.");
    }

}