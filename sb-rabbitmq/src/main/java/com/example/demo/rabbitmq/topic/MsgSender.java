package com.example.demo.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsgSender {
    @Autowired
    private AmqpTemplate rabbitTemlate;
    public void send1(){

        String context ="hi,i am message 1";
        System.out.println("Sender :" +context);
        this.rabbitTemlate.convertAndSend("mybootexchange","topic.message",context);
    }
    public void send2(){
        String context ="hi,i am messages 2";
        System.out.println("Sender :" +context);
        this.rabbitTemlate.convertAndSend("mybootexchange","topic.messages",context);
    }
}
