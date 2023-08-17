package br.com.pizzaria.entity;

import br.com.pizzaria.entity.enums.Ingrediente;
import br.com.pizzaria.entity.enums.Sabor;
import br.com.pizzaria.entity.enums.Tamanho;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_pizza",schema = "public")
public class Pizza {
    @Id
    private Long id;
    private Tamanho tamanho;

    @ManyToMany
    @JoinTable(
            name = "pizza_sabores",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "sabor_id")
    )
    private List<Sabor> sabores = new ArrayList<>();
}
