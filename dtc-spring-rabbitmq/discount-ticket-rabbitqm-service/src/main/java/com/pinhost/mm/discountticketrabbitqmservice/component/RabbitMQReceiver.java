package com.pinhost.mm.discountticketrabbitqmservice.component;

import com.pinhost.mm.dtcdatabase.model.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {
    private Log LOG = LogFactory.getLog(RabbitMQReceiver.class);

    @RabbitListener(queues = "spring-boot-customer")
    public void onMessage(@Payload Customer customer) {

        LOG.info("consumer message {}" + customer);
    }
}
