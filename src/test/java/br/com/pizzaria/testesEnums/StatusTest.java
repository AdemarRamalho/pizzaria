package br.com.pizzaria.testesEnums;

import br.com.pizzaria.entity.enums.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {

    @Test
    public void testNomeStatusRecebido() {
        assertEquals("RECEBIDO", Status.RECEBIDO.name());
    }

    @Test
    public void testNomeStatusPago() {
        assertEquals("PAGO", Status.PAGO.name());
    }

    @Test
    public void testNomeStatusCancelado() {
        assertEquals("CANCELADO", Status.CANCELADO.name());
    }

    @Test
    public void testNomeStatusEmAndamento() {
        assertEquals("EM_ANDAMENTO", Status.EM_ANDAMENTO.name());
    }

    @Test
    public void testNomeStatusEmEntrega() {
        assertEquals("EM_ENTREGA", Status.EM_ENTREGA.name());
    }

    @Test
    public void testNomeStatusFinalizado() {
        assertEquals("FINALIZADO", Status.FINALIZADO.name());
    }

    @Test
    public void testToStringStatusRecebido() {
        assertEquals("RECEBIDO", Status.RECEBIDO.toString());
    }

    @Test
    public void testToStringStatusPago() {
        assertEquals("PAGO", Status.PAGO.toString());
    }

    @Test
    public void testToStringStatusCancelado() {
        assertEquals("CANCELADO", Status.CANCELADO.toString());
    }

    @Test
    public void testToStringStatusEmAndamento() {
        assertEquals("EM_ANDAMENTO", Status.EM_ANDAMENTO.toString());
    }

    @Test
    public void testToStringStatusEmEntrega() {
        assertEquals("EM_ENTREGA", Status.EM_ENTREGA.toString());
    }

    @Test
    public void testToStringStatusFinalizado() {
        assertEquals("FINALIZADO", Status.FINALIZADO.toString());
    }
}
