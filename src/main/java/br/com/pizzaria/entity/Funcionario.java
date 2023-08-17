package br.com.pizzaria.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_funcionario",schema = "public")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargo;

    @OneToMany(mappedBy = "funcionario")
    private List<Pedido> pedidos = new ArrayList<>();

}
