package com.pinhost.mm.discountticketkafka.consumer;

import com.pinhost.mm.discountticketkafka.service.DiscountTicketService;
import com.pinhost.mm.dtcdatabase.model.Customer;
import com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public class CustomerConsumer {
    private static final Log LOG = LogFactory.getLog(CustomerConsumer.class);

    @Autowired
    private DiscountTicketService discountTicketService;

    @Autowired
    private KafkaTemplate<String, DiscountTicketCondition> template;

    private static final CountDownLatch latch =  new CountDownLatch(1);

    public static CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "mm.customer", groupId = "mm_luis", containerFactory = "customerKafkaListenerFactory")
    public void customerReceiver(ConsumerRecord<String, com.pinhost.mm.dtcdatabase.model.Customer> consumerRecord){
        LOG.info("reciivaaa: " + consumerRecord.value());
        Customer customer = consumerRecord.value();
        List<com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition> dtcList = discountTicketService.getDTCList(customer.getId());
        template.send("mm.ticket", dtcList.get(0));
        latch.countDown();
    }
}
