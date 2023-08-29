package br.com.pizzaria.service;

import br.com.pizzaria.entity.Configuracao;
import br.com.pizzaria.repository.ConfiguracaoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;
    @Transactional
    public Configuracao findById(Long id){
    if (id == 0){
        throw new RuntimeException(", Id não localizado");
    } else if (configuracaoRepository.findById(id).isEmpty()) {
        throw new RuntimeException(", não foi posssivel localizar a configuracao desejada");
    }else {
        return configuracaoRepository.findById(id).orElse(null);
    }
        
    }

    @Transactional
    public void cadastrar(Configuracao configuracao){
        this.configuracaoRepository.save(configuracao);
    }
    @Transactional
    public void atualizar(Long idConf, Configuracao configuracao){
        this.configuracaoRepository.save(configuracao);
    }

    }

