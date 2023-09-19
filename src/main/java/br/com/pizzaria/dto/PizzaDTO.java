package br.com.pizzaria.dto;

import br.com.pizzaria.entity.enums.Ingrediente;
import br.com.pizzaria.entity.enums.Tamanho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PizzaDTO {
    private String tamanho;
    private List<Long> saborIds;
}
