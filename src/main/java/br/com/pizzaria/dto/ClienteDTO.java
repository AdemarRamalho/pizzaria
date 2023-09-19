package br.com.pizzaria.dto;

import br.com.pizzaria.entity.Endereco;
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
public class ClienteDTO {
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String telefone;
    @Getter
    @Setter
    private List <EnderecoDTO> enderecoDTO = new ArrayList<>();

    private List <PedidoDTO> pedidoDTO = new ArrayList<>();
}
