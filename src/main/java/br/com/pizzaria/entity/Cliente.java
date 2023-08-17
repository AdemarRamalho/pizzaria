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
@Table(name = "tb_cliente",schema = "public")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private List<Endereco> endereco = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();
}
