package com.bootcamp.ms.microservicewallet.service;

import com.bootcamp.ms.commons.entity.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletService {

    Flux<Wallet> findAll();
    Mono<Wallet> findById(String id);
    Mono<Wallet> save(Wallet wallet);
    Mono<Void> delete(Wallet wallet);
}
