package com.example.demo.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

//@Component
//@RabbitListener(queues = "q_topic_messages")
public class Receiver2 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2:" + hello);
    }
}
