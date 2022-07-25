package com.bootcamp.ms.microservicewallet.service.impl;

import com.bootcamp.ms.commons.entity.Wallet;
import com.bootcamp.ms.microservicewallet.producer.repository.WalletRepository;
import com.bootcamp.ms.microservicewallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Flux<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Mono<Wallet> findById(String id) {
        return walletRepository.findById(id);
    }

    @Override
    public Mono<Wallet> save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Mono<Void> delete(Wallet wallet) {
        return walletRepository.delete(wallet);
    }

}
