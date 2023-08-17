package br.com.pizzaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Endereco {
    @Id
    private Long id;
    private String rua;
    private int numero;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}
