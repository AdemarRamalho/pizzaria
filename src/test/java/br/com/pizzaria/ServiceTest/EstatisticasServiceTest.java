package br.com.pizzaria.ServiceTest;

import br.com.pizzaria.dto.EstatisticasDTO;
import br.com.pizzaria.entity.Pedido;
import br.com.pizzaria.entity.enums.Status;
import br.com.pizzaria.repository.PedidoRepository;
import br.com.pizzaria.service.EstatisticasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EstatisticasServiceTest {

    @InjectMocks
    private EstatisticasService estatisticasService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Test
    public void testCalcularEstatisticasDoDia() {

        LocalDate hoje = LocalDate.now();
        List<Pedido> pedidosDoDia = new ArrayList<>();

        Pedido pedidoPago = new Pedido();
        pedidoPago.setStatus(Status.PAGO);
        pedidosDoDia.add(pedidoPago);

        Pedido pedidoCancelado = new Pedido();
        pedidoCancelado.setStatus(Status.CANCELADO);
        pedidosDoDia.add(pedidoCancelado);

        Pedido pedidoPendente = new Pedido();
        pedidoPendente.setStatus(Status.EM_ANDAMENTO);
        pedidosDoDia.add(pedidoPendente);

        Pedido outroPedidoPago = new Pedido();
        outroPedidoPago.setStatus(Status.PAGO);
        pedidosDoDia.add(outroPedidoPago);

        when(pedidoRepository.findByDataPedido(hoje)).thenReturn(pedidosDoDia);

        EstatisticasDTO resultado = estatisticasService.calcularEstatisticasDoDia();


        EstatisticasDTO esperado = new EstatisticasDTO();
        esperado.setTotalPedidos(pedidosDoDia.size());
        esperado.setPedidosPagos(2);
        esperado.setPedidosCancelados(1);
        esperado.setPedidosEntregues(2);
        esperado.setPedidosRetirados(2);
        esperado.setFaturamentoDinheiro(1000);
        esperado.setFaturamentoCartao(500);

        assertEquals(esperado.getTotalPedidos(), resultado.getTotalPedidos());
        assertEquals(esperado.getPedidosPagos(), resultado.getPedidosPagos());
        assertEquals(esperado.getPedidosCancelados(), resultado.getPedidosCancelados());



        verify(pedidoRepository, times(1)).findByDataPedido(hoje);
    }

    @Test
    public void testCalcularEstatisticasDoMes() {
        LocalDate hoje = LocalDate.now();
        YearMonth mesAtual = YearMonth.from(hoje);
        LocalDate primeiroDiaDoMes = mesAtual.atDay(1);
        LocalDate ultimoDiaDoMes = mesAtual.atEndOfMonth();
        List<Pedido> pedidosDoMes = new ArrayList<>();


        when(pedidoRepository.findByDataPedidoBetween(primeiroDiaDoMes, ultimoDiaDoMes)).thenReturn(pedidosDoMes);



        verify(pedidoRepository, times(1)).findByDataPedidoBetween(primeiroDiaDoMes, ultimoDiaDoMes);
    }

    @Test
    public void testCalcularEstatisticasDoAno() {

        LocalDate hoje = LocalDate.now();
        int anoAtual = hoje.getYear();
        LocalDate primeiroDiaDoAno = LocalDate.of(anoAtual, Month.JANUARY, 1);
        LocalDate ultimoDiaDoAno = LocalDate.of(anoAtual, Month.DECEMBER, 31);
        List<Pedido> pedidosDoAno = new ArrayList<>();

        Pedido pedidoPago1 = new Pedido();
        pedidoPago1.setStatus(Status.PAGO);
        pedidosDoAno.add(pedidoPago1);

        Pedido pedidoCancelado = new Pedido();
        pedidoCancelado.setStatus(Status.CANCELADO);
        pedidosDoAno.add(pedidoCancelado);

        Pedido pedidoPago2 = new Pedido();
        pedidoPago2.setStatus(Status.PAGO);
        pedidosDoAno.add(pedidoPago2);

        when(pedidoRepository.findByDataPedidoBetween(primeiroDiaDoAno, ultimoDiaDoAno)).thenReturn(pedidosDoAno);

        EstatisticasDTO resultado = estatisticasService.calcularEstatisticasDoAno();


        EstatisticasDTO esperado = new EstatisticasDTO();
        esperado.setTotalPedidos(pedidosDoAno.size());
        esperado.setPedidosPagos(2);
        esperado.setPedidosCancelados(1);

        esperado.setPedidosEntregues(0);
        esperado.setPedidosRetirados(0);
        esperado.setFaturamentoCartao(0.0);
        esperado.setFaturamentoDinheiro(0.0);

        assertEquals(esperado.getTotalPedidos(), resultado.getTotalPedidos());
        assertEquals(esperado.getPedidosPagos(), resultado.getPedidosPagos());
        assertEquals(esperado.getPedidosCancelados(), resultado.getPedidosCancelados());

        assertEquals(esperado.getPedidosEntregues(), resultado.getPedidosEntregues());
        assertEquals(esperado.getPedidosRetirados(), resultado.getPedidosRetirados());
        assertEquals(esperado.getFaturamentoCartao(), resultado.getFaturamentoCartao(), 0.01); // Use um delta para comparar valores de ponto flutuante
        assertEquals(esperado.getFaturamentoDinheiro(), resultado.getFaturamentoDinheiro(), 0.01);

        verify(pedidoRepository, times(1)).findByDataPedidoBetween(primeiroDiaDoAno, ultimoDiaDoAno);
    }
}
