package br.com.pizzaria.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

    public class EstatisticasDTO {
        private int totalPedidos;
        private int pedidosPagos;
        private int pedidosCancelados;
        private int pedidosEntregues;
        private int pedidosRetirados;
        private double faturamentoCartao;
        private double faturamentoDinheiro;
    }
