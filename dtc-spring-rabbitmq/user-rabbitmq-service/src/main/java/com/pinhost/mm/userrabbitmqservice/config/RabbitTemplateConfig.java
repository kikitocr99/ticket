package com.pinhost.mm.userrabbitmqservice.config;

import com.pinhost.mm.userrabbitmqservice.component.Receiver;
import com.pinhost.mm.userrabbitmqservice.jsonconfig.UserModel;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTemplateConfig {

    static final String topicExchangeName = "spring-boot-exchange";

    static final String queueName = "spring-boot";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    /*@Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory
                                              ) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        //container.setMessageListener(listenerAdapter);
        return container;
    }*/

    /*@Bean
    MessageListenerAdapter listenerAdapter() {
        MessageListenerAdapter messageListenerAdapter = new  MessageListenerAdapter(new Object() {

            @SuppressWarnings("unused")
            public void handleMessage(UserModel object) {
                System.out.println("Got a " + object);
            }

        });
        messageListenerAdapter.setMessageConverter(jMessageConverter());
        return messageListenerAdapter;
    }*/

    /*@Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }*/

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter jMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
