package br.com.pizzaria.controllerTest;

import br.com.pizzaria.controller.EnderecoController;
import br.com.pizzaria.dto.EnderecoDTO;
import br.com.pizzaria.entity.Endereco;
import br.com.pizzaria.service.EnderecoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EnderecoControllerTest {

    @InjectMocks
    private EnderecoController enderecoController;

    @Mock
    private EnderecoService enderecoService;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarEndereco() {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        Endereco enderecoSimulado = new Endereco();
        when(enderecoService.criarEndereco(enderecoDTO)).thenReturn(enderecoSimulado);
        when(modelMapper.map(enderecoSimulado, EnderecoDTO.class)).thenReturn(enderecoDTO);

        ResponseEntity<EnderecoDTO> response = enderecoController.criarEndereco(enderecoDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(enderecoDTO, response.getBody());
    }

    @Test
    public void testListarEnderecos() {
        // Configurar o comportamento do enderecoService e modelMapper
        List<Endereco> enderecosSimulados = new ArrayList<>();
        enderecosSimulados.add(new Endereco());
        when(enderecoService.listarEnderecos()).thenReturn(enderecosSimulados);
        when(modelMapper.map(any(Endereco.class), eq(EnderecoDTO.class))).thenReturn(new EnderecoDTO());

        ResponseEntity<List<EnderecoDTO>> response = enderecoController.listarEnderecos();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(enderecosSimulados.size(), response.getBody().size());
    }

    @Test
    public void testBuscarEnderecoPorId() {
        Long id = 1L;
        Endereco enderecoSimulado = new Endereco();
        when(enderecoService.buscarEnderecoPorId(id)).thenReturn(enderecoSimulado);
        when(modelMapper.map(enderecoSimulado, EnderecoDTO.class)).thenReturn(new EnderecoDTO());

        ResponseEntity<EnderecoDTO> response = enderecoController.buscarEnderecoPorId(id);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
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


        when(enderecoService.atualizarEndereco(id, enderecoDTO)).thenReturn(enderecoExistente);
        when(modelMapper.map(enderecoExistente, EnderecoDTO.class)).thenReturn(enderecoDTO);

        ResponseEntity<EnderecoDTO> response = enderecoController.atualizarEndereco(id, enderecoDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(enderecoDTO, response.getBody());

        verify(enderecoService, times(1)).atualizarEndereco(id, enderecoDTO);
    }

}
