package br.com.pizzaria.controller;

import br.com.pizzaria.dto.EnderecoDTO;
import br.com.pizzaria.entity.Endereco;
import br.com.pizzaria.service.EnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    private final EnderecoService enderecoService;
    private final ModelMapper modelMapper;

    @Autowired
    public EnderecoController(EnderecoService enderecoService, ModelMapper modelMapper) {
        this.enderecoService = enderecoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoService.criarEndereco(enderecoDTO);
        EnderecoDTO responseDTO = modelMapper.map(endereco, EnderecoDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarEnderecos() {
        List<Endereco> enderecos = enderecoService.listarEnderecos();
        List<EnderecoDTO> responseDTOs = enderecos.stream()
                .map(endereco -> modelMapper.map(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable Long id) {
        Endereco endereco = enderecoService.buscarEnderecoPorId(id);
        EnderecoDTO responseDTO = modelMapper.map(endereco, EnderecoDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> atualizarEndereco(
            @PathVariable Long id,
            @RequestBody EnderecoDTO enderecoDTO
    ) {
        Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, enderecoDTO);
        EnderecoDTO responseDTO = modelMapper.map(enderecoAtualizado, EnderecoDTO.class);
        return ResponseEntity.ok(responseDTO);
    }
}