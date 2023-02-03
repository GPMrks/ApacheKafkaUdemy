package com.gpmrks.strproducer.service;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public StringProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {

        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("str-topic", message);

        log.info("Sent message {}", message);
//
//        future.thenApply(success -> {
//            RecordMetadata recordMetadata = null;
//            if (success != null) {
//                log.info("Message successfully sent! {}", message);
//                log.info("Partition: {}, Offset: {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
//                recordMetadata = success.getRecordMetadata();
//            }
//            return recordMetadata;
//        }).exceptionally(error -> {
//            log.info("Failed to send message!");
//            return null;
//        });
    }
}


