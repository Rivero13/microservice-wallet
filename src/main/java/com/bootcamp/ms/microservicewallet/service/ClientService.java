package com.bootcamp.ms.microservicewallet.service;

import com.bootcamp.ms.commons.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Flux<Client> getAll();

    Mono<Client> find(String id);
}
