package br.com.pizzaria.controller;

import br.com.pizzaria.dto.PedidoDTO;
import br.com.pizzaria.entity.Pedido;
import br.com.pizzaria.service.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;
    private final ModelMapper modelMapper;

    @Autowired
    public PedidoController(PedidoService pedidoService, ModelMapper modelMapper) {
        this.pedidoService = pedidoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.criarPedido(pedidoDTO);
        PedidoDTO responseDTO = modelMapper.map(pedido, PedidoDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        List<PedidoDTO> responseDTOs = pedidos.stream()
                .map(pedido -> modelMapper.map(pedido, PedidoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        PedidoDTO responseDTO = modelMapper.map(pedido, PedidoDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizarPedido(
            @PathVariable Long id,
            @RequestBody PedidoDTO pedidoDTO
    ) {
        Pedido pedido = pedidoService.atualizarPedido(id, pedidoDTO);
        PedidoDTO responseDTO = modelMapper.map(pedido, PedidoDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }


}
