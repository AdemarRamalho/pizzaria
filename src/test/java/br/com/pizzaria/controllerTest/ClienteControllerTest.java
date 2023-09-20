package br.com.pizzaria.controllerTest;

import br.com.pizzaria.controller.ClienteController;
import br.com.pizzaria.dto.ClienteDTO;
import br.com.pizzaria.entity.Cliente;
import br.com.pizzaria.service.ClienteService;
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

public class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteService;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarCliente() {
        ClienteDTO clienteDTO = new ClienteDTO();
        Cliente clienteSimulado = new Cliente();
        when(clienteService.criarCliente(clienteDTO)).thenReturn(clienteSimulado);
        when(modelMapper.map(clienteSimulado, ClienteDTO.class)).thenReturn(clienteDTO);

        ResponseEntity<ClienteDTO> response = clienteController.criarCliente(clienteDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteDTO, response.getBody());
    }

    @Test
    public void testListarClientes() {
        List<Cliente> clientesSimulados = new ArrayList<>();
        clientesSimulados.add(new Cliente());
        when(clienteService.listarClientes()).thenReturn(clientesSimulados);
        when(modelMapper.map(any(Cliente.class), eq(ClienteDTO.class))).thenReturn(new ClienteDTO());

        ResponseEntity<List<ClienteDTO>> response = clienteController.listarClientes();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clientesSimulados.size(), response.getBody().size());
    }

    @Test
    public void testBuscarClientePorId() {
        Long id = 1L;
        Cliente clienteSimulado = new Cliente();
        when(clienteService.buscarClientePorId(id)).thenReturn(clienteSimulado);
        when(modelMapper.map(clienteSimulado, ClienteDTO.class)).thenReturn(new ClienteDTO());

        ResponseEntity<ClienteDTO> response = clienteController.buscarClientePorId(id);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testAtualizarCliente() {
        Long id = 1L;
        ClienteDTO clienteDTO = new ClienteDTO();
        Cliente clienteSimulado = new Cliente();
        when(clienteService.atualizarCliente(id, clienteDTO)).thenReturn(clienteSimulado);
        when(modelMapper.map(clienteSimulado, ClienteDTO.class)).thenReturn(new ClienteDTO());

        ResponseEntity<ClienteDTO> response = clienteController.atualizarCliente(id, clienteDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDeletarCliente() {
        Long id = 1L;

        ResponseEntity<Void> response = clienteController.deletarCliente(id);

        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(clienteService, times(1)).deletarCliente(id);
    }

}
