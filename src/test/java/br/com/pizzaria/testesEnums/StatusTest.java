package br.com.pizzaria.testesEnums;

import br.com.pizzaria.entity.enums.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {

    @Test
  void testNomeStatusRecebido() {
        assertEquals("RECEBIDO", Status.RECEBIDO.name());
    }

    @Test
  void testNomeStatusPago() {
        assertEquals("PAGO", Status.PAGO.name());
    }

    @Test
  void testNomeStatusCancelado() {
        assertEquals("CANCELADO", Status.CANCELADO.name());
    }

    @Test
  void testNomeStatusEmAndamento() {
        assertEquals("EM_ANDAMENTO", Status.EM_ANDAMENTO.name());
    }

    @Test
  void testNomeStatusEmEntrega() {
        assertEquals("EM_ENTREGA", Status.EM_ENTREGA.name());
    }

    @Test
  void testNomeStatusFinalizado() {
        assertEquals("FINALIZADO", Status.FINALIZADO.name());
    }

    @Test
  void testToStringStatusRecebido() {
        assertEquals("RECEBIDO", Status.RECEBIDO.toString());
    }

    @Test
  void testToStringStatusPago() {
        assertEquals("PAGO", Status.PAGO.toString());
    }

    @Test
  void testToStringStatusCancelado() {
        assertEquals("CANCELADO", Status.CANCELADO.toString());
    }

    @Test
  void testToStringStatusEmAndamento() {
        assertEquals("EM_ANDAMENTO", Status.EM_ANDAMENTO.toString());
    }

    @Test
  void testToStringStatusEmEntrega() {
        assertEquals("EM_ENTREGA", Status.EM_ENTREGA.toString());
    }

    @Test
  void testToStringStatusFinalizado() {
        assertEquals("FINALIZADO", Status.FINALIZADO.toString());
    }
}
