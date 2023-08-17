package br.com.pizzaria.dto;

import br.com.pizzaria.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Service
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

