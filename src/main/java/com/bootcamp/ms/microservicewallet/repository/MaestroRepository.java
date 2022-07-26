package com.bootcamp.ms.microservicewallet.repository;

import com.bootcamp.ms.microservicewallet.domain.Maestro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaestroRepository extends CrudRepository<Maestro, Integer> {
}
