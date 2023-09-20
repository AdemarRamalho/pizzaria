package br.com.pizzaria.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.pizzaria.dto.FuncionarioDTO;
import br.com.pizzaria.entity.Funcionario;
import br.com.pizzaria.repository.FuncionarioRepository;
import br.com.pizzaria.service.FuncionarioService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class FuncionariosServiceTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private FuncionarioService funcionarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarFuncionario() {

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        Funcionario funcionario = new Funcionario();

        when(modelMapper.map(funcionarioDTO, Funcionario.class)).thenReturn(funcionario);
        when(funcionarioRepository.save(funcionario)).thenReturn(funcionario);


        Funcionario resultado = funcionarioService.criarFuncionario(funcionarioDTO);


        assertNotNull(resultado);
        assertEquals(funcionario, resultado);

        verify(modelMapper, times(1)).map(funcionarioDTO, Funcionario.class);
        verify(funcionarioRepository, times(1)).save(funcionario);
    }

    @Test
    public void testListarFuncionarios() {

        List<Funcionario> listaFuncionarios = new ArrayList<>();
        when(funcionarioRepository.findAll()).thenReturn(listaFuncionarios);


        List<Funcionario> resultado = funcionarioService.listarFuncionarios();


        assertNotNull(resultado);
        assertEquals(listaFuncionarios, resultado);

        verify(funcionarioRepository, times(1)).findAll();
    }

    @Test
    public void testBuscarFuncionarioPorId() {

        Long id = 1L;
        Funcionario funcionario = new Funcionario();
        when(funcionarioRepository.findById(id)).thenReturn(Optional.of(funcionario));

        Funcionario resultado = funcionarioService.buscarFuncionarioPorId(id);


        assertNotNull(resultado);
        assertEquals(funcionario, resultado);

        verify(funcionarioRepository, times(1)).findById(id);
    }

    @Test
    public void testBuscarFuncionarioPorIdNaoEncontrado() {

        Long id = 1L;
        when(funcionarioRepository.findById(id)).thenReturn(Optional.empty());


        assertThrows(EntityNotFoundException.class, () -> funcionarioService.buscarFuncionarioPorId(id));

        verify(funcionarioRepository, times(1)).findById(id);
    }


    @Test
    public void testAtualizarFuncionarioNaoEncontrado() {

        Long id = 1L;
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

        when(funcionarioRepository.findById(id)).thenReturn(Optional.empty());


        assertThrows(EntityNotFoundException.class, () -> funcionarioService.atualizarFuncionario(id, funcionarioDTO));

        verify(funcionarioRepository, times(1)).findById(id);
    }

    @Test
    public void testDeletarFuncionario() {

        Long id = 1L;
        Funcionario funcionario = new Funcionario();

        when(funcionarioRepository.findById(id)).thenReturn(Optional.of(funcionario));

        funcionarioService.deletarFuncionario(id);

        verify(funcionarioRepository, times(1)).findById(id);
        verify(funcionarioRepository, times(1)).delete(funcionario);
    }

    @Test
    public void testDeletarFuncionarioNaoEncontrado() {

        Long id = 1L;

        when(funcionarioRepository.findById(id)).thenReturn(Optional.empty());


        assertThrows(EntityNotFoundException.class, () -> funcionarioService.deletarFuncionario(id));

        verify(funcionarioRepository, times(1)).findById(id);
    }

    @Test
    public void testConstrutorFuncionarioService() {
        assertNotNull(funcionarioService);
        assertNotNull(funcionarioRepository);

        when(funcionarioRepository.findAll()).thenReturn(new ArrayList<>());

        assertNotNull(funcionarioService.getModelMapper());
    }
}


