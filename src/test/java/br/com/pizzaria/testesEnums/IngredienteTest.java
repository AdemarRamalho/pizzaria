package br.com.pizzaria.testesEnums;

import br.com.pizzaria.entity.enums.Ingrediente;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredienteTest {

    @Test
    public void testNomeIngredienteTomate() {
        assertEquals("Tomate", Ingrediente.TOMATE.name());
    }

    @Test
    public void testNomeIngredienteQueijo() {
        assertEquals("Queijo", Ingrediente.QUEIJO.name());
    }

    @Test
    public void testNomeIngredienteCebola() {
        assertEquals("Cebola", Ingrediente.CEBOLA.name());
    }
    @Test
    public void testNomeIngredienteFrango() {
        assertEquals("Frango", Ingrediente.FRANGO.name());
    }
    @Test
    public void testNomeIngredienteCalabresa() {
        assertEquals("Calabresa", Ingrediente.CALABRESA.name());
    }
    @Test
    public void testNomeIngredientePimentao() {
        assertEquals("Pimentao", Ingrediente.PIMENTAO.name());
    }
    @Test
    public void testNomeIngredienteOregano() {
        assertEquals("Oregano", Ingrediente.OREGANO.name());
    }
    @Test
    public void testNomeIngredienteOvo() {
        assertEquals("Ovo", Ingrediente.OVO.name());
    }
    @Test
    public void testNomeIngredienteCatupiry() {
        assertEquals("Catupiry", Ingrediente.CATUPIRY.name());
    }
    @Test
    public void testNomeIngredienteAzeitona() {
        assertEquals("Azeitona", Ingrediente.AZEITONA.name());
    }


    @Test
    public void testToStringIngredienteTomate() {
        assertEquals("Tomate", Ingrediente.TOMATE.toString());
    }

    @Test
    public void testToStringIngredienteQueijo() {
        assertEquals("Queijo", Ingrediente.QUEIJO.toString());
    }

    @Test
    public void testToStringIngredienteCebola() {
        assertEquals("Cebola", Ingrediente.CEBOLA.toString());
    }

    @Test
    public void testToStringIngredienteFrango() {
        assertEquals("Frango", Ingrediente.FRANGO.toString());
    }
    @Test
    public void testToStringIngredienteCalabresa() {
        assertEquals("Calabresa", Ingrediente.CALABRESA.toString());
    }
    @Test
    public void testToStringIngredientePimentao() {
        assertEquals("Pimentao", Ingrediente.PIMENTAO.toString());
    }
    @Test
    public void testToStringIngredienteOregano() {
        assertEquals("Oregano", Ingrediente.OREGANO.toString());
    }
    @Test
    public void testToStringIngredienteOvo() {
        assertEquals("Ovo", Ingrediente.OVO.toString());
    }
    @Test
    public void testToStringIngredienteCatupiry() {
        assertEquals("Catupiry", Ingrediente.CATUPIRY.toString());
    }
    @Test
    public void testToStringIngredienteAzeitona() {
        assertEquals("Azeitona", Ingrediente.AZEITONA.toString());
    }


}
