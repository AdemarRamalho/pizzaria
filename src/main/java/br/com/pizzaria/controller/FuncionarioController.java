package br.com.pizzaria.controller;

import br.com.pizzaria.dto.FuncionarioDTO;
import br.com.pizzaria.entity.Funcionario;
import br.com.pizzaria.service.FuncionarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;
    private final ModelMapper modelMapper;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService, ModelMapper modelMapper) {
        this.funcionarioService = funcionarioService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioService.criarFuncionario(funcionarioDTO);
        FuncionarioDTO responseDTO = modelMapper.map(funcionario, FuncionarioDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        List<FuncionarioDTO> responseDTOs = funcionarios.stream()
                .map(funcionario -> modelMapper.map(funcionario, FuncionarioDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionarioPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        FuncionarioDTO responseDTO = modelMapper.map(funcionario, FuncionarioDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(
            @PathVariable Long id,
            @RequestBody FuncionarioDTO funcionarioDTO
    ) {
        Funcionario funcionario = funcionarioService.atualizarFuncionario(id, funcionarioDTO);
        FuncionarioDTO responseDTO = modelMapper.map(funcionario, FuncionarioDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }

}
