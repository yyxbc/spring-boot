package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

//@Component
//@RabbitListener(queues = "q_hello")
public class HelloReceiver2 {
    @RabbitHandler
    public void process(String hello){
        System.out.println("Recevier2 :"+hello);
    }

}
