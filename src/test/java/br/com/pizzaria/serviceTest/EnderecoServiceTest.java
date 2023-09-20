package br.com.pizzaria.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.pizzaria.dto.EnderecoDTO;
import br.com.pizzaria.entity.Endereco;
import br.com.pizzaria.repository.EnderecoRepository;
import br.com.pizzaria.service.EnderecoService;
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

public class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private EnderecoService enderecoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarEndereco() {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        Endereco endereco = new Endereco();

        when(modelMapper.map(enderecoDTO, Endereco.class)).thenReturn(endereco);
        when(enderecoRepository.save(endereco)).thenReturn(endereco);

        Endereco resultado = enderecoService.criarEndereco(enderecoDTO);

        assertNotNull(resultado);
        assertEquals(endereco, resultado);

        verify(modelMapper, times(1)).map(enderecoDTO, Endereco.class);
        verify(enderecoRepository, times(1)).save(endereco);
    }

    @Test
    public void testListarEnderecos() {
        List<Endereco> listaEnderecos = new ArrayList<>();
        when(enderecoRepository.findAll()).thenReturn(listaEnderecos);

        List<Endereco> resultado = enderecoService.listarEnderecos();

        assertNotNull(resultado);
        assertEquals(listaEnderecos, resultado);

        verify(enderecoRepository, times(1)).findAll();
    }

    @Test
    public void testBuscarEnderecoPorId() {
        Long id = 1L;
        Endereco endereco = new Endereco();
        when(enderecoRepository.findById(id)).thenReturn(Optional.of(endereco));

        Endereco resultado = enderecoService.buscarEnderecoPorId(id);

        assertNotNull(resultado);
        assertEquals(endereco, resultado);

        verify(enderecoRepository, times(1)).findById(id);
    }

    @Test
    public void testBuscarEnderecoPorIdNaoEncontrado() {
        Long id = 1L;
        when(enderecoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> enderecoService.buscarEnderecoPorId(id));

        verify(enderecoRepository, times(1)).findById(id);
    }
    @Test
    public void testAtualizarEndereco() {
        Long id = 1L;
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setNomeRua("Rua Teste");
        enderecoDTO.setNumeroCasa(255);


        Endereco enderecoExistente = new Endereco();
        enderecoExistente.setId(id);
        enderecoExistente.setNomeRua("Rua Antiga");
        enderecoExistente.setNumeroCasa(200);


        when(enderecoRepository.findById(id)).thenReturn(Optional.of(enderecoExistente));
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(enderecoExistente);
        when(modelMapper.map(enderecoDTO, Endereco.class)).thenReturn(enderecoExistente);

        Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, enderecoDTO);

        assertEquals("Rua Teste", enderecoAtualizado.getNomeRua());
        assertEquals(255, enderecoAtualizado.getNumeroCasa());


        verify(enderecoRepository, times(1)).save(enderecoExistente);
    }
}

