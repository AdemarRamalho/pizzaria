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
    private String rua;
    private int numero;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}
