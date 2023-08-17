package br.com.pizzaria.service;

import br.com.pizzaria.dto.FuncionarioDTO;
import br.com.pizzaria.entity.Funcionario;
import br.com.pizzaria.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository, ModelMapper modelMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.modelMapper = modelMapper;
    }

    public Funcionario criarFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = modelMapper.map(funcionarioDTO, Funcionario.class);
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
    }

    public Funcionario atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        modelMapper.map(funcionarioDTO, funcionario);

        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        funcionarioRepository.delete(funcionario);
    }
}
