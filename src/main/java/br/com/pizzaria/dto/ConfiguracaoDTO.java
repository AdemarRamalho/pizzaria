package br.com.pizzaria.dto;

import br.com.pizzaria.entity.Sabor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Tb_confg", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ConfiguracaoDTO {
    @Column(name = "Valor_Pizza")
    private BigDecimal ValorPizza;

    private List<Sabor> sabores = new ArrayList<>();



}






