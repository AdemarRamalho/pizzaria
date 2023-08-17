package br.com.pizzaria.dto;

import br.com.pizzaria.entity.enums.Ingrediente;
import br.com.pizzaria.entity.enums.Tamanho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class PizzaDTO {
    private String tamanho;
    private List<Long> saborIds;
}
