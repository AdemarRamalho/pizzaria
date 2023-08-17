package br.com.pizzaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Estatisticas {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int totalPedidos;
        private int pedidosPagos;
        private int pedidosCancelados;
        private int pedidosEntregues;
        private int pedidosRetirados;
        private double faturamentoCartao;
        private double faturamentoDinheiro;
    }

