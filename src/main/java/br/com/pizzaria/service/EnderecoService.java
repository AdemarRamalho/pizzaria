package br.com.pizzaria.service;

import br.com.pizzaria.dto.EnderecoDTO;
import br.com.pizzaria.entity.Endereco;
import br.com.pizzaria.repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository, ModelMapper modelMapper) {
        this.enderecoRepository = enderecoRepository;
        this.modelMapper = modelMapper;
    }

    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));
    }
    public Endereco atualizarEndereco(Long id, EnderecoDTO enderecoDTO) {
        Endereco enderecoExistente = enderecoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));

        enderecoExistente.setNomeRua(enderecoDTO.getNomeRua());
        enderecoExistente.setNumeroCasa(enderecoDTO.getNumeroCasa());


        return enderecoRepository.save(enderecoExistente);
    }

}

