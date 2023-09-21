package br.com.pizzaria.entityTest;

import br.com.pizzaria.entity.Pizza;
import br.com.pizzaria.entity.Sabor;
import br.com.pizzaria.entity.enums.Tamanho;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PizzaTest {

    @Test
    public void testPizzaGetterSetter() {
        Pizza pizza = new Pizza();
        pizza.setId(1L);
        pizza.setTamanho(Tamanho.PEQUENA);

        List<Sabor> sabores = new ArrayList<>();
        sabores.add(new Sabor(1L, "Margherita", 20.0));
        sabores.add(new Sabor(2L, "Calabresa", 22.0));
        pizza.setSabores(sabores);

        Assert.assertEquals(1L, pizza.getId().longValue());
        Assert.assertEquals(Tamanho.PEQUENA, pizza.getTamanho());
        Assert.assertEquals(sabores, pizza.getSabores());
    }
}
