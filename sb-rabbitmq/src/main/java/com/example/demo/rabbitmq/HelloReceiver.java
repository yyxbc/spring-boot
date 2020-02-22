package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "q_hello")
public class HelloReceiver {
    @RabbitHandler
    public void process(String hello){
        System.out.println("Recevier :"+hello);
    }

}
