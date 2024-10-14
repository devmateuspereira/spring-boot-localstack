package br.com.mateuspereirajorge.sqs.listener;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsMessageListener {

    @SqsListener("sqsHelloWorld")
    public void loadMessageFromSQS(String message) {
        System.out.println("Received message from SQS: " + message);
    }
}