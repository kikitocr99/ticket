package com.pinhost.mm.customerkafkaservice.listener;

import com.pinhost.mm.customerkafkaservice.service.CustomerService;
import com.pinhost.mm.dtcdatabase.model.Customer;
import com.pinhost.mm.dtcdatabase.model.UserModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class UserModelConsumer {
    private static final Log LOG = LogFactory.getLog(UserModelConsumer.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private KafkaTemplate<String, com.pinhost.mm.dtcdatabase.model.Customer> kafkaTemplate;

    private static final CountDownLatch latch =  new CountDownLatch(1);

    public static CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "mm.user", groupId = "mm_ent", containerFactory = "customerKafkaListenerFactory")
    public void userConsumer(ConsumerRecord<String, com.pinhost.mm.dtcdatabase.model.UserModel> userRecord){
        UserModel user = userRecord.value();
        LOG.info("User Model Ticket : " + user.toString());
        //UserModel user = consumerRecord.value();
        if (user != null){
            Customer c  = customerService.getCustomerByUserId(user.getId());

            kafkaTemplate.send("mm.customer", c.getId() + "created", c);
        }
        latch.countDown();
    }
}
