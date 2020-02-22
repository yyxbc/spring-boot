package com.example.demo.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

import java.io.IOException;

//@Component
//@RabbitListener(queues = "q_topic_message")
public class Receiver1 {
    @RabbitHandler
    public void process(String hello) throws IOException {
        System.out.println("Receiver1:" + hello);
    }
}
