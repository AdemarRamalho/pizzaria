package br.com.pizzaria.entityTest;

import br.com.pizzaria.entity.Sabor;
import org.junit.Assert;
import org.junit.Test;

public class SaborTest {

    @Test
    public void testSaborGetterSetter() {
        Sabor sabor = new Sabor();
        sabor.setId(1L);
        sabor.setNome("Margherita");
        sabor.setValor(20.0);

        Assert.assertEquals(1L, sabor.getId().longValue());
        Assert.assertEquals("Margherita", sabor.getNome());
        Assert.assertEquals(20.0, sabor.getValor(), 0.001); // Use uma margem de erro pequena para valores decimais
    }
}

