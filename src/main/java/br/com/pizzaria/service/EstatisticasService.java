package br.com.pizzaria.service;

import br.com.pizzaria.dto.EstatisticasDTO;
import br.com.pizzaria.entity.Estatisticas;
import br.com.pizzaria.entity.Pedido;
import br.com.pizzaria.entity.enums.Status;
import br.com.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

@Service
public class EstatisticasService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public EstatisticasService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    private Estatisticas calcularEstatisticas(List<Pedido> pedidos) {
        int totalPedidos = pedidos.size();
        int pedidosPagos = 0;
        int pedidosCancelados = 0;

        for (Pedido pedido : pedidos) {
            if (Status.PAGO.equals(pedido.getStatus())) {
                pedidosPagos++;
            } else if (Status.CANCELADO.equals(pedido.getStatus())) {
                pedidosCancelados++;
            }
        }
        Estatisticas estatisticas = new Estatisticas();
        estatisticas.setTotalPedidos(totalPedidos);
        estatisticas.setPedidosPagos(pedidosPagos);
        estatisticas.setPedidosCancelados(pedidosCancelados);

        return estatisticas;
    }

    public EstatisticasDTO converterEstatisticasParaDTO(Estatisticas estatisticas) {
        EstatisticasDTO dto = new EstatisticasDTO();
        dto.setTotalPedidos(estatisticas.getTotalPedidos());
        dto.setPedidosPagos(estatisticas.getPedidosPagos());
        dto.setPedidosCancelados(estatisticas.getPedidosCancelados());
        return dto;
    }

    public EstatisticasDTO calcularEstatisticasDoDia() {
        LocalDate hoje = LocalDate.now();
        List<Pedido> pedidosDoDia = pedidoRepository.findByDataPedido(hoje);

        Estatisticas estatisticas = calcularEstatisticas(pedidosDoDia);

        return mapEstatisticasToDTO(estatisticas);
    }
    public EstatisticasDTO calcularEstatisticasDoMes() {
        LocalDate hoje = LocalDate.now();
        YearMonth mesAtual = YearMonth.from(hoje);
        LocalDate primeiroDiaDoMes = mesAtual.atDay(1);
        LocalDate ultimoDiaDoMes = mesAtual.atEndOfMonth();

        List<Pedido> pedidosDoMes = pedidoRepository.findByDataPedidoBetween(primeiroDiaDoMes, ultimoDiaDoMes);

        Estatisticas estatisticas = calcularEstatisticas(pedidosDoMes);
        return mapEstatisticasToDTO(estatisticas);
    }
    public EstatisticasDTO calcularEstatisticasDoAno() {
        LocalDate hoje = LocalDate.now();
        int anoAtual = hoje.getYear();
        LocalDate primeiroDiaDoAno = LocalDate.of(anoAtual, Month.JANUARY, 1);
        LocalDate ultimoDiaDoAno = LocalDate.of(anoAtual, Month.DECEMBER, 31);

        List<Pedido> pedidosDoAno = pedidoRepository.findByDataPedidoBetween(primeiroDiaDoAno, ultimoDiaDoAno);
        Estatisticas estatisticas = calcularEstatisticas(pedidosDoAno);
        return mapEstatisticasToDTO(estatisticas);
    }
    private EstatisticasDTO mapEstatisticasToDTO(Estatisticas estatisticas) {
        EstatisticasDTO dto = new EstatisticasDTO();
        dto.setTotalPedidos(estatisticas.getTotalPedidos());
        dto.setPedidosPagos(estatisticas.getPedidosPagos());
        dto.setPedidosCancelados(estatisticas.getPedidosCancelados());
        return dto;
    }
}
