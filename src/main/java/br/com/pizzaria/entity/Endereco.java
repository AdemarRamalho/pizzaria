package br.com.pizzaria.entity;

import jakarta.persistence.OneToOne;

public class Endereco {
    private Long id;
    private String rua;
    private int numero;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}
