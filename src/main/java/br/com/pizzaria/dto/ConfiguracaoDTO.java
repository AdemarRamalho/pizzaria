package br.com.pizzaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

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






