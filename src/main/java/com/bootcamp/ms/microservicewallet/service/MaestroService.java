package com.bootcamp.ms.microservicewallet.service;

import com.bootcamp.ms.microservicewallet.domain.Maestro;
import com.bootcamp.ms.microservicewallet.repository.MaestroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaestroService {

    final Logger logger = LoggerFactory.getLogger(MaestroService.class);

    @Autowired
    private MaestroRepository userRepository;

    @Cacheable(value = "userCache")
    public Maestro getUserForId(Integer id) {
        logger.info("Getting user with ID {}.", id);
        return userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public Maestro getUserId(Integer id) {
        Optional<Maestro> optional = userRepository.findById(id);
        return optional.get();
    }

}
