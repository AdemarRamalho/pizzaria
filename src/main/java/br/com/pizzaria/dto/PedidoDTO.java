package br.com.pizzaria.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private String tamanho;
    private List<String> sabores;
    private boolean entregaNecessaria;
    private Long clienteId;
    private Long funcionarioId;
    private String status;
    private double valorTotal;
}

