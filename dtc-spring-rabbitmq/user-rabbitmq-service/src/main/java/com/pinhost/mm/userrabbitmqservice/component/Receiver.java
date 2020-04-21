package com.pinhost.mm.userrabbitmqservice.component;

import com.pinhost.mm.userrabbitmqservice.jsonconfig.UserModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(queues = "spring-boot")
    public void receiveMessage(UserModel message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
