package br.com.pizzaria.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_endereco",schema = "public")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeRua;
    private int numeroCasa;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
