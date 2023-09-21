package br.com.pizzaria.entityTest;

import br.com.pizzaria.entity.Estatisticas;
import org.junit.Assert;
import org.junit.Test;

public class EstatisticasTest {

    @Test
    public void testEstatisticasGetterSetter() {
        Estatisticas estatisticas = new Estatisticas();
        estatisticas.setId(1L);
        estatisticas.setTotalPedidos(10);
        estatisticas.setPedidosPagos(8);

        Assert.assertEquals(1L, estatisticas.getId().longValue());
        Assert.assertEquals(10, estatisticas.getTotalPedidos());
        Assert.assertEquals(8, estatisticas.getPedidosPagos());
    }
}

