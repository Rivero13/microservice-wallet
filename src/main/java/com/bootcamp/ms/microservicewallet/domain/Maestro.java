package com.bootcamp.ms.microservicewallet.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
public class Maestro implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Integer id;
    private String maestro;
    private String descripcion;

    public Maestro() {
    }

    public Maestro(String maestro, String descripcion) {
        this.maestro = maestro;
        this.descripcion = descripcion;
    }



}
