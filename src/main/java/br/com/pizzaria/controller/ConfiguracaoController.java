package br.com.pizzaria.controller;

import br.com.pizzaria.entity.Configuracao;
import br.com.pizzaria.service.ConfiguracaoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/configuracao")
public class ConfiguracaoController {
    @Autowired
    private ConfiguracaoService configuracaoService;

    @GetMapping ("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        final Configuracao configuracao = this.configuracaoService.findById(id);
        return  configuracao ==null
                ? ResponseEntity.badRequest().body("Nada encontradp")
                : ResponseEntity.ok(configuracao);
    }

    @PostMapping
    public ResponseEntity<?>cad(@ResponseBody final Configuracao configuracao){
        try {
            return ResponseEntity.ok(configuracaoService.cadastrar(configuracao));

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{idConf}")
    public ResponseEntity<?>atu(@PathVariable Long idConf,@RequestBody Configuracao configuracao){
        try {4
            this.configuracaoService.atualizar(idConf, configuracao);
            return ResponseEntity.ok().body("Conf atualizada com sucesso");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
