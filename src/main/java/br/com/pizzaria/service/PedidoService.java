package br.com.pizzaria.service;

import br.com.pizzaria.dto.PedidoDTO;
import br.com.pizzaria.entity.Cliente;
import br.com.pizzaria.entity.Funcionario;
import br.com.pizzaria.entity.Pedido;
import br.com.pizzaria.repository.ClienteRepository;
import br.com.pizzaria.repository.FuncionarioRepository;
import br.com.pizzaria.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PedidoService(
            PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository,
            FuncionarioRepository funcionarioRepository,
            ModelMapper modelMapper
    ) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.modelMapper = modelMapper;
    }

    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);

        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        pedido.setCliente(cliente);

        Funcionario funcionario = funcionarioRepository.findById(pedidoDTO.getFuncionarioId())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
        pedido.setFuncionario(funcionario);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
    }

    public Pedido atualizarPedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        modelMapper.map(pedidoDTO, pedido);

        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        pedidoRepository.delete(pedido);
    }

}
