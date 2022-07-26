package com.bootcamp.ms.microservicewallet.service.impl;

import com.bootcamp.ms.commons.entity.BankAccount;
import com.bootcamp.ms.microservicewallet.BankAccountConfig;
import com.bootcamp.ms.microservicewallet.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankAccountSerivceImpl implements BankAccountService {

    @Autowired
    private WebClient.Builder client;

    @Autowired
    private BankAccountConfig bankAccountConfig;

    @Override
    public Mono<BankAccount> findById(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return client.baseUrl(bankAccountConfig.getUrl())
                .build()
                .get()
                .uri("/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BankAccount.class);
    }

    @Override
    public Mono<BankAccount> save(BankAccount bankAccount) {
        return client.baseUrl(bankAccountConfig.getUrl())
                .build()
                .post()
                .uri("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(bankAccount)
                .retrieve()
                .bodyToMono(BankAccount.class);
    }

}
