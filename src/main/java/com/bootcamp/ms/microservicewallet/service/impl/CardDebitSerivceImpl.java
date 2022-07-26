package com.bootcamp.ms.microservicewallet.service.impl;

import com.bootcamp.ms.commons.entity.CardDebit;
import com.bootcamp.ms.microservicewallet.CardDebitConfig;
import com.bootcamp.ms.microservicewallet.service.CardDebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class CardDebitSerivceImpl implements CardDebitService {

    @Autowired
    private WebClient.Builder client;

    @Autowired
    private CardDebitConfig cardDebitConfig;

    @Override
    public Mono<CardDebit> findById(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return client.baseUrl(cardDebitConfig.getUrl())
                .build()
                .get()
                .uri("/findBy/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CardDebit.class);
    }

    @Override
    public Mono<CardDebit> save(CardDebit cardDebit) {
        return client.baseUrl(cardDebitConfig.getUrl())
                .build()
                .post()
                .uri("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(cardDebit)
                .retrieve()
                .bodyToMono(CardDebit.class);
    }
}
