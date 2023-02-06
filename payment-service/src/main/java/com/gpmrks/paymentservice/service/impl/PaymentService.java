package com.gpmrks.paymentservice.service.impl;

import com.gpmrks.paymentservice.model.Payment;
import com.gpmrks.paymentservice.service.IPaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Log4j2
public class PaymentService implements IPaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Autowired
    public PaymentService(KafkaTemplate<String, Serializable> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendPayment(Payment payment) throws InterruptedException {
        log.info("Payment received {}", payment);
        Thread.sleep(1000);

        log.info("Sending payment ...");
        kafkaTemplate.send("payment-topic", payment);
    }
}