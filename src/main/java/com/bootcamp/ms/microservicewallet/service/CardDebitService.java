package com.bootcamp.ms.microservicewallet.service;

import com.bootcamp.ms.commons.entity.CardDebit;
import reactor.core.publisher.Mono;

public interface CardDebitService {

    Mono<CardDebit> findById(String id);
    Mono<CardDebit> save(CardDebit cardDebit);
}
