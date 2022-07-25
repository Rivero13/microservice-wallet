package com.bootcamp.ms.microservicewallet.service.impl;

import com.bootcamp.ms.commons.entity.Client;
import com.bootcamp.ms.microservicewallet.ClientConfig;
import com.bootcamp.ms.microservicewallet.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private WebClient.Builder client;

    @Autowired
    private ClientConfig clientConfig;

    @Override
    public Flux<Client> getAll() {
        return client.baseUrl(clientConfig.getUrl())
                .build()
                .get()
                .uri("/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Client.class);
    }

    @Override
    public Mono<Client> find(String id) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return client.baseUrl(clientConfig.getUrl())
                .build()
                .get()
                .uri("/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Client.class);
    }
}
