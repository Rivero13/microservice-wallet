package com.bootcamp.ms.microservicewallet;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class CardDebitConfig {

    @Value("${endpoint.cardDebit}")
    private String url;

}
