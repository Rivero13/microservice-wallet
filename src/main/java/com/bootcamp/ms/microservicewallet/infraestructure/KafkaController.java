package com.bootcamp.ms.microservicewallet.infraestructure;

import com.bootcamp.ms.commons.entity.Wallet;
import com.bootcamp.ms.microservicewallet.producer.KafkaStringProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaStringProducer kafkaStringProducer;

    @Autowired
    KafkaController(KafkaStringProducer kafkaStringProducer) {
        this.kafkaStringProducer = kafkaStringProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody Wallet message) {
        this.kafkaStringProducer.sendMessage(message);
    }
}
