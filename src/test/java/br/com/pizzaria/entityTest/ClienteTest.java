package br.com.pizzaria.entityTest;

import br.com.pizzaria.entity.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void testGettersAndSetters() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Ademar");
        cliente.setTelefone("+1234567890");

        assertEquals(1L,(long) cliente.getId());
        assertEquals("Ademar", cliente.getNome());
        assertEquals("+1234567890", cliente.getTelefone());
    }

    @Test
    public void testAnotacoes() {

        assertTrue(Cliente.class.isAnnotationPresent(Entity.class));

        Table tableAnnotation = Cliente.class.getAnnotation(Table.class);
        assertNotNull(tableAnnotation);
        assertEquals("tb_cliente", tableAnnotation.name());
        assertEquals("public", tableAnnotation.schema());
    }
}