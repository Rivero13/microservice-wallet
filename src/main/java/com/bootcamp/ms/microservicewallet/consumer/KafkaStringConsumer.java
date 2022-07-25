package com.bootcamp.ms.microservicewallet.consumer;

import com.bootcamp.ms.commons.entity.Wallet;
import com.bootcamp.ms.microservicewallet.service.ClientService;
import com.bootcamp.ms.microservicewallet.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class KafkaStringConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);

    @Autowired
    private WalletService walletService;

    @Autowired
    private ClientService clientService;

    @KafkaListener(topics = "bootcamp-Topic" , groupId = "group_id")
    public void consume(Wallet message) {
        logger.info("Creando monedero...");
        clientService.find(message.getIdClient())
                .flatMap(c -> {
                    message.setClient(c);
                    message.setDate(new Date());
                    logger.info("Consuming Message {}", message);
                    return walletService.save(message);
                }).subscribe();
        logger.info("grabó monedero!");
    }

}