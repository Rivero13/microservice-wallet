package com.bootcamp.ms.microservicewallet.infraestructure;

import com.bootcamp.ms.commons.entity.Wallet;
import com.bootcamp.ms.microservicewallet.consumer.KafkaStringConsumer;
import com.bootcamp.ms.microservicewallet.producer.KafkaStringProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaStringProducer kafkaStringProducer;

    @Autowired
    KafkaController(KafkaStringProducer kafkaStringProducer) {
        this.kafkaStringProducer = kafkaStringProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody Wallet message) {
        this.kafkaStringProducer.sendMessage(message);
    }

    @PutMapping("/publish2")
    public void sendMessageToKafkaTopic2(@RequestBody Wallet wallet){
        logger.info("publish2");
        logger.info(wallet.getNumberPhone());
        this.kafkaStringProducer.sendMessageUpdateAmount(wallet);
    }

    @PutMapping("/publish3")
    public void sendMessageToKafkaTopic3(@RequestBody Wallet wallet){
        logger.info("publish3");
        logger.info(wallet.getIdCardDebit());
        this.kafkaStringProducer.sendMessageAssociateWithCardDebit(wallet);
    }
}
