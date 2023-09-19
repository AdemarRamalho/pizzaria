package br.com.pizzaria.dto;

import br.com.pizzaria.entity.Pedido;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
    public class FuncionarioDTO {
        private String nome;
        private String cargo;

        @OneToMany(mappedBy = "funcionario")
        private List<PedidoDTO> pedidosDTO = new ArrayList<>();
    }
