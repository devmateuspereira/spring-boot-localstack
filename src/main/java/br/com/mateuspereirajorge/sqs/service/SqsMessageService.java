package br.com.mateuspereirajorge.sqs.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageService {

    @Autowired
    private AmazonSQS sqs;

    @Value("${cloud.aws.sqs.queue.url}")
    private String sqsQueueUrl;

    public void sendMessage(String message) {
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(sqsQueueUrl)
                .withMessageBody(message)
                .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);
    }

}