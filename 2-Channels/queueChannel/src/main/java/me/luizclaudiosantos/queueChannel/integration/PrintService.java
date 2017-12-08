package me.luizclaudiosantos.queueChannel.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {

    public Message<?> print(Message<String> message) {

        System.out.println(message.getPayload());

        int messageNumber = (int) message.getHeaders().get("messageNumber");

        return MessageBuilder.withPayload("Sending message with the number " + messageNumber).build();
    }



}
