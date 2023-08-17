package br.com.pizzaria.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_estatisticas",schema = "public")
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

