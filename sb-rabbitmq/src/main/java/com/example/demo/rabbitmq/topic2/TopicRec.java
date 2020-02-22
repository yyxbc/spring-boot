package com.example.demo.rabbitmq.topic2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.messages")
public class TopicRec {
    @RabbitHandler
    public void process(String messages) throws IOException {
        System.out.println("Receiver1:" + messages);
    }
}
