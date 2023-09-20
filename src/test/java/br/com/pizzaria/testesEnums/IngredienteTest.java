package br.com.pizzaria.testesEnums;

import br.com.pizzaria.entity.enums.Ingrediente;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredienteTest {

    @Test
    public void testNomeIngredienteTomate() {
        assertEquals("TOMATE", Ingrediente.TOMATE.name());
    }

    @Test
    public void testNomeIngredienteQueijo() {
        assertEquals("QUEIJO", Ingrediente.QUEIJO.name());
    }

    @Test
    public void testNomeIngredienteCebola() {
        assertEquals("CEBOLA", Ingrediente.CEBOLA.name());
    }
    @Test
    public void testNomeIngredienteFrango() {
        assertEquals("FRANGO", Ingrediente.FRANGO.name());
    }
    @Test
    public void testNomeIngredienteCalabresa() {
        assertEquals("CALABRESA", Ingrediente.CALABRESA.name());
    }
    @Test
    public void testNomeIngredientePimentao() {
        assertEquals("PIMENTAO", Ingrediente.PIMENTAO.name());
    }
    @Test
    public void testNomeIngredienteOregano() {
        assertEquals("OREGANO", Ingrediente.OREGANO.name());
    }
    @Test
    public void testNomeIngredienteOvo() {
        assertEquals("OVO", Ingrediente.OVO.name());
    }
    @Test
    public void testNomeIngredienteCatupiry() {
        assertEquals("CATUPIRY", Ingrediente.CATUPIRY.name());
    }
    @Test
    public void testNomeIngredienteAzeitona() {
        assertEquals("AZEITONA", Ingrediente.AZEITONA.name());
    }


    @Test
    public void testToStringIngredienteTomate() {
        assertEquals("TOMATE", Ingrediente.TOMATE.toString());
    }

    @Test
    public void testToStringIngredienteQueijo() {
        assertEquals("QUEIJO", Ingrediente.QUEIJO.toString());
    }

    @Test
    public void testToStringIngredienteCebola() {
        assertEquals("CEBOLA", Ingrediente.CEBOLA.toString());
    }

    @Test
    public void testToStringIngredienteFrango() {
        assertEquals("FRANGO", Ingrediente.FRANGO.toString());
    }
    @Test
    public void testToStringIngredienteCalabresa() {
        assertEquals("CALABRESA", Ingrediente.CALABRESA.toString());
    }
    @Test
    public void testToStringIngredientePimentao() {
        assertEquals("PIMENTAO", Ingrediente.PIMENTAO.toString());
    }
    @Test
    public void testToStringIngredienteOregano() {
        assertEquals("OREGANO", Ingrediente.OREGANO.toString());
    }
    @Test
    public void testToStringIngredienteOvo() {
        assertEquals("OVO", Ingrediente.OVO.toString());
    }
    @Test
    public void testToStringIngredienteCatupiry() {
        assertEquals("CATUPIRY", Ingrediente.CATUPIRY.toString());
    }
    @Test
    public void testToStringIngredienteAzeitona() {
        assertEquals("AZEITONA", Ingrediente.AZEITONA.toString());
    }


}
