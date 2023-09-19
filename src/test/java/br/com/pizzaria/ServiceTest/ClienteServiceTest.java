package br.com.pizzaria.ServiceTest;

import br.com.pizzaria.dto.ClienteDTO;
import br.com.pizzaria.entity.Cliente;
import br.com.pizzaria.repository.ClienteRepository;
import br.com.pizzaria.service.ClienteService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testCriarCliente() {
        // Configurar dados de entrada
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("João");
        clienteDTO.setTelefone("123456789");

        // Criar um objeto Cliente simulado com os valores corretos
        Cliente clienteSimulado = new Cliente();
        clienteSimulado.setId(1L);
        clienteSimulado.setNome("João");
        clienteSimulado.setTelefone("123456789");


        when(modelMapper.map(clienteDTO, Cliente.class)).thenReturn(clienteSimulado);


        when(clienteRepository.save(clienteSimulado)).thenReturn(clienteSimulado);


        Cliente clienteCriado = clienteService.criarCliente(clienteDTO);


        assertNotNull(clienteCriado.getId());
        assertEquals("João", clienteCriado.getNome());
        assertEquals("123456789", clienteCriado.getTelefone());


        verify(modelMapper, times(1)).map(clienteDTO, Cliente.class);
        verify(clienteRepository, times(1)).save(clienteSimulado);
    }


    @Test
    public void testListarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente());
        clientes.add(new Cliente());

        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> listaClientes = clienteService.listarClientes();

        assertEquals(2, listaClientes.size());
    }

    @Test
    public void testBuscarClientePorId() {
        Long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome("João");

        when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));

        Cliente encontrado = clienteService.buscarClientePorId(id);

        assertNotNull(encontrado);
        assertEquals(id, encontrado.getId());
        assertEquals("João", encontrado.getNome());
    }

    @Test
    public void testBuscarClientePorId_NaoEncontrado() {
        Long id = 1L;

        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> clienteService.buscarClientePorId(id));

    }

    @Test
    public void testAtualizarCliente_NaoEncontrado() {
        Long id = 1L;
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("Maria");
        clienteDTO.setTelefone("9876543210");

        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> clienteService.atualizarCliente(id, clienteDTO));

    }

    @Test
    public void testDeletarCliente() {
        Long id = 1L;
        Cliente clienteExistente = new Cliente();
        clienteExistente.setId(id);

        when(clienteRepository.findById(id)).thenReturn(Optional.of(clienteExistente));

        clienteService.deletarCliente(id);

        verify(clienteRepository, times(1)).delete(clienteExistente);
    }

    @Test
    public void testDeletarCliente_NaoEncontrado() {
        Long id = 1L;

        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> clienteService.deletarCliente(id));

    }


}



