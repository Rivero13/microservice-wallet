package com.bootcamp.ms.microservicewallet.producer;

import com.bootcamp.ms.commons.entity.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducer.class);

    private final KafkaTemplate<String, Wallet> kafkaTemplate;

    public KafkaStringProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, Wallet> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Wallet message) {
        LOGGER.info("Producing message {}", message);
        this.kafkaTemplate.send("bootcamp-Topic", message);
    }

    public void sendMessageUpdateAmount(Wallet messaWallet){
        LOGGER.info("Producing message for update amount {}", messaWallet);
        LOGGER.info(messaWallet.getNumberPhone());
        this.kafkaTemplate.send("bootcamp-Topic2", messaWallet);
    }

    public void sendMessageAssociateWithCardDebit(Wallet messaWallet){
        LOGGER.info("Producing message for associate with card debit {}", messaWallet);
        this.kafkaTemplate.send("bootcamp-Topic3", messaWallet);
    }

}