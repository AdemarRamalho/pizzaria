package br.com.pizzaria.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargo;

    @OneToMany(mappedBy = "funcionario")
    private List<Pedido> pedidos = new ArrayList<>();

}
