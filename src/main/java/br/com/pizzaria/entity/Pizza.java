package br.com.pizzaria.entity;

import br.com.pizzaria.entity.enums.Ingrediente;
import br.com.pizzaria.entity.enums.Sabor;
import br.com.pizzaria.entity.enums.Tamanho;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
