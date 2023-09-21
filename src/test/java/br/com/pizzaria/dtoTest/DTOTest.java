package br.com.pizzaria.dtoTest;

import br.com.pizzaria.dto.ClienteDTO;
import br.com.pizzaria.dto.EnderecoDTO;
import br.com.pizzaria.dto.PedidoDTO;
import br.com.pizzaria.dto.EstatisticasDTO;
import br.com.pizzaria.dto.FuncionarioDTO;
import br.com.pizzaria.dto.PizzaDTO;
import br.com.pizzaria.dto.SaborDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DTOTest {

    @Test
    public void testClienteDTO() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("João");
        clienteDTO.setTelefone("123-456-789");

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setNomeRua("Rua Principal");
        enderecoDTO.setNumeroCasa(123);

        List<EnderecoDTO> enderecos = new ArrayList<>();
        enderecos.add(enderecoDTO);
        clienteDTO.setEnderecoDTO(enderecos);

        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setTamanho("Grande");

        List<PedidoDTO> pedidos = new ArrayList<>();
        pedidos.add(pedidoDTO);
        clienteDTO.setPedidoDTO(pedidos);

        Assert.assertEquals("João", clienteDTO.getNome());
        Assert.assertEquals("123-456-789", clienteDTO.getTelefone());
        Assert.assertEquals(enderecos, clienteDTO.getEnderecoDTO());
        Assert.assertEquals(pedidos, clienteDTO.getPedidoDTO());
    }

    @Test
    public void testEstatisticasDTO() {
        EstatisticasDTO estatisticasDTO = new EstatisticasDTO();
        estatisticasDTO.setTotalPedidos(10);
        estatisticasDTO.setPedidosPagos(8);

        Assert.assertEquals(10, estatisticasDTO.getTotalPedidos());
        Assert.assertEquals(8, estatisticasDTO.getPedidosPagos());
    }

    @Test
    public void testFuncionarioDTO() {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setNome("Maria");
        funcionarioDTO.setCargo("Atendente");

        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setTamanho("Média");

        List<PedidoDTO> pedidos = new ArrayList<>();
        pedidos.add(pedidoDTO);
        funcionarioDTO.setPedidosDTO(pedidos);

        Assert.assertEquals("Maria", funcionarioDTO.getNome());
        Assert.assertEquals("Atendente", funcionarioDTO.getCargo());
        Assert.assertEquals(pedidos, funcionarioDTO.getPedidosDTO());
    }

    @Test
    public void testPedidoDTO() {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setTamanho("Pequena");
        pedidoDTO.setEntregaNecessaria(true);
        pedidoDTO.setStatus("Pendente");
        pedidoDTO.setValorTotal(25.0);

        List<String> sabores = new ArrayList<>();
        sabores.add("Margherita");
        sabores.add("Calabresa");
        pedidoDTO.setSabores(sabores);

        Assert.assertEquals("Pequena", pedidoDTO.getTamanho());
        Assert.assertTrue(pedidoDTO.isEntregaNecessaria());
        Assert.assertEquals("Pendente", pedidoDTO.getStatus());
        Assert.assertEquals(25.0, pedidoDTO.getValorTotal(), 0.001); // Use uma margem de erro pequena para valores decimais
        Assert.assertEquals(sabores, pedidoDTO.getSabores());
    }

    @Test
    public void testPizzaDTO() {
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.setTamanho("Média");

        List<Long> saborIds = new ArrayList<>();
        saborIds.add(1L);
        saborIds.add(2L);
        pizzaDTO.setSaborIds(saborIds);

        Assert.assertEquals("Média", pizzaDTO.getTamanho());
        Assert.assertEquals(saborIds, pizzaDTO.getSaborIds());
    }

    @Test
    public void testSaborDTO() {
        SaborDTO saborDTO = new SaborDTO();
        saborDTO.setNome("Calabresa");

        Assert.assertEquals("Calabresa", saborDTO.getNome());
    }
}
