package br.com.pizzaria.entityTest;

import br.com.pizzaria.entity.Pedido;
import br.com.pizzaria.entity.enums.Status;
import br.com.pizzaria.entity.enums.Tamanho;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PedidoTest {

    @Test
    public void testPedidoGetterSetter() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setTamanho(Tamanho.GRANDE);
        pedido.setEntregaNecessaria(true);
        pedido.setStatus(Status.EM_ANDAMENTO);

        List<String> sabores = Arrays.asList("Margherita", "Calabresa");
        pedido.setSabores(sabores);

        Assert.assertEquals(1L, pedido.getId().longValue());
        Assert.assertEquals(Tamanho.GRANDE, pedido.getTamanho());
        Assert.assertTrue(pedido.isEntregaNecessaria());
        Assert.assertEquals(Status.EM_ANDAMENTO, pedido.getStatus());
        Assert.assertEquals(sabores, pedido.getSabores());
    }
}

