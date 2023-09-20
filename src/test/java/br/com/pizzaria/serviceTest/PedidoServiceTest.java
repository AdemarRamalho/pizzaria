package br.com.pizzaria.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.pizzaria.dto.PedidoDTO;
import br.com.pizzaria.entity.Cliente;
import br.com.pizzaria.entity.Funcionario;
import br.com.pizzaria.entity.Pedido;
import br.com.pizzaria.repository.ClienteRepository;
import br.com.pizzaria.repository.FuncionarioRepository;
import br.com.pizzaria.repository.PedidoRepository;
import br.com.pizzaria.service.PedidoService;
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


public class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PedidoService pedidoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarPedido() {
        // Mocks
        PedidoDTO pedidoDTO = new PedidoDTO();
        Pedido pedido = new Pedido();
        Long clienteId = 1L;
        Long funcionarioId = 2L;

        when(modelMapper.map(pedidoDTO, Pedido.class)).thenReturn(pedido);
        when(clienteRepository.findById(clienteId)).thenReturn(Optional.of(new Cliente()));
        when(funcionarioRepository.findById(funcionarioId)).thenReturn(Optional.of(new Funcionario()));
        when(pedidoRepository.save(pedido)).thenReturn(pedido);

        pedidoDTO.setClienteId(clienteId);
        pedidoDTO.setFuncionarioId(funcionarioId);

        // Test
        Pedido resultado = pedidoService.criarPedido(pedidoDTO);

        // Verificações
        assertNotNull(resultado);
        assertEquals(pedido, resultado);

        verify(modelMapper, times(1)).map(pedidoDTO, Pedido.class);
        verify(clienteRepository, times(1)).findById(clienteId);
        verify(funcionarioRepository, times(1)).findById(funcionarioId);
        verify(pedidoRepository, times(1)).save(pedido);
    }

    @Test
    public void testListarPedidos() {
        // Mocks
        List<Pedido> listaPedidos = new ArrayList<>();
        when(pedidoRepository.findAll()).thenReturn(listaPedidos);

        // Test
        List<Pedido> resultado = pedidoService.listarPedidos();

        // Verificações
        assertNotNull(resultado);
        assertEquals(listaPedidos, resultado);

        verify(pedidoRepository, times(1)).findAll();
    }

    @Test
    public void testBuscarPedidoPorId() {
        // Mocks
        Long id = 1L;
        Pedido pedido = new Pedido();
        when(pedidoRepository.findById(id)).thenReturn(Optional.of(pedido));

        // Test
        Pedido resultado = pedidoService.buscarPedidoPorId(id);

        // Verificações
        assertNotNull(resultado);
        assertEquals(pedido, resultado);

        verify(pedidoRepository, times(1)).findById(id);
    }

    @Test
    public void testBuscarPedidoPorIdNaoEncontrado() {
        // Mocks
        Long id = 1L;
        when(pedidoRepository.findById(id)).thenReturn(Optional.empty());

        // Test
        assertThrows(EntityNotFoundException.class, () -> pedidoService.buscarPedidoPorId(id));

        verify(pedidoRepository, times(1)).findById(id);
    }


    @Test
    public void testAtualizarPedidoNaoEncontrado() {
        // Mocks
        Long id = 1L;
        PedidoDTO pedidoDTO = new PedidoDTO();
        Pedido pedido = new Pedido();

        when(modelMapper.map(pedidoDTO, Pedido.class)).thenReturn(pedido);

        // Test
        assertThrows(EntityNotFoundException.class, () -> pedidoService.atualizarPedido(id, pedidoDTO));

        verify(pedidoRepository, times(1)).findById(id);
    }

    @Test
    public void testDeletarPedido() {
        // Mocks
        Long id = 1L;
        Pedido pedido = new Pedido();

        when(pedidoRepository.findById(id)).thenReturn(Optional.of(pedido));

        // Test
        pedidoService.deletarPedido(id);

        // Verificações
        verify(pedidoRepository, times(1)).findById(id);


    }
}