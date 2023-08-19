package br.com.pizzaria.dto;

import br.com.pizzaria.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String nome;
    private String telefone;

    private EnderecoDTO.EnderecoDTO enderecoDTO;
}
