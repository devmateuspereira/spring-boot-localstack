package br.com.mateuspereirajorge.sns.service;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SnsNotificationService {

    @Value("arn:aws:sns:us-east-1:000000000000:snsHelloWorld")
    private String notificationName;

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    @Autowired
    public SnsNotificationService(AmazonSNS amazonSns) {
        amazonSns = AmazonSNSClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "us-east-1"))
                .build();
        this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
    }

    public void sendNotification(String subject, Object message, Map<String, Object> headers) {
        this.notificationMessagingTemplate.convertAndSend(notificationName, message, headers);
    }

}