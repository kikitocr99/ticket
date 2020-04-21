package com.pinhost.mm.userkafkaservice.consumer;

import com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class DiscountTicketConsumer {

    private static final Log LOG = LogFactory.getLog(DiscountTicketConsumer.class);

    private static final CountDownLatch latch =  new CountDownLatch(1);

    public static CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "mm.ticket", groupId = "mm", containerFactory = "customerKafkaListenerFactory")
    public void ticketConsumer(ConsumerRecord<String, DiscountTicketCondition> consumerRecord){
        LOG.info("discount Ticket : " + consumerRecord.value());

        latch.countDown();
    }
}
