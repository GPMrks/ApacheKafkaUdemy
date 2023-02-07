package com.gpmrks.jsonconsumer.listener;

import com.gpmrks.jsonconsumer.model.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@Log4j2
public class JsonListener {

    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) throws InterruptedException {
        log.info("Payment received {}", payment.toString());
        sleep(2000);

        log.info("Checking for fraud ...");
        sleep(4000);

        log.info("Purchase approved ...");
        sleep(6000);
    }

    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) throws InterruptedException {
        sleep(8000);
        log.info("Generating PDF file of product ID {} ...", payment.getProductId());
    }

    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() throws InterruptedException {
        sleep(8000);
        log.info("Sending confirmation e-mail ...");
    }

}
