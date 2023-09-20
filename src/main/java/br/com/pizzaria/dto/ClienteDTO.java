package br.com.pizzaria.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
