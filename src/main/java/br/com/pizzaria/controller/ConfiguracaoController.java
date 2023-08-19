package br.com.pizzaria.controller;

import br.com.pizzaria.entity.Configuracao;
import br.com.pizzaria.service.ConfiguracaoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/configuracao")
public class ConfiguracaoController {
    @Autowired
    private ConfiguracaoService configuracaoService;

    @GetMapping ("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        final Configuracao configuracao = this.configuracaoService
    }



}
