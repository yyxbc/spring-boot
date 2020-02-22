package com.example.demo.rabbitmq.topic2;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }
    /**
     * 声明一个Topic类型的交换机
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("myexchange");
    }

    /**
     * 绑定Q到交换机,并且指定routingKey
     * @param queueMessages
     * @param exchange
     * @return
     */

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
