package br.com.pizzaria.repository;

import br.com.pizzaria.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByDataPedido(LocalDate dataPedido);

    List<Pedido> findByDataPedidoBetween(LocalDate start, LocalDate end);
}
