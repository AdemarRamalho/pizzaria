package br.com.pizzaria.controller;

import br.com.pizzaria.dto.EstatisticasDTO;
import br.com.pizzaria.entity.Estatisticas;
import br.com.pizzaria.service.EstatisticasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/estatisticas")
    public class EstatisticasController {
        private final EstatisticasService estatisticasService;

        @Autowired
        public EstatisticasController(EstatisticasService estatisticasService) {
            this.estatisticasService = estatisticasService;
        }

        @GetMapping("/diarias")
        public ResponseEntity<EstatisticasDTO> obterEstatisticasDiarias() {
            EstatisticasDTO estatisticasDTO = estatisticasService.calcularEstatisticasDoDia();
            return ResponseEntity.ok(estatisticasDTO);
        }

        @GetMapping("/mensais")
        public ResponseEntity<EstatisticasDTO> obterEstatisticasMensais() {
            EstatisticasDTO estatisticasDTO = estatisticasService.calcularEstatisticasDoMes();
            return ResponseEntity.ok(estatisticasDTO);
        }

        @GetMapping("/anuais")
        public ResponseEntity<EstatisticasDTO> obterEstatisticasAnuais() {
            EstatisticasDTO estatisticasDTO = estatisticasService.calcularEstatisticasDoAno();
            return ResponseEntity.ok(estatisticasDTO);
        }


}
