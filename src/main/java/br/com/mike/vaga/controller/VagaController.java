package br.com.mike.vaga.controller;

import br.com.mike.comum.records.AutenticacaoRecord;
import br.com.mike.comum.records.TokenRecord;
import br.com.mike.comum.service.AutenticationService;
import br.com.mike.vaga.configuration.ConfigurationUserTransaction;
import br.com.mike.vaga.record.VagaRecord;
import br.com.mike.vaga.repository.VagaService;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/vaga")
public class VagaController {
    @Autowired
    private VagaService vagaService;
    private ConfigurationUserTransaction userTransaction;

    @GetMapping(value = "/obterLista")
    public ResponseEntity<List<VagaRecord>> obterLista(@RequestHeader HttpHeaders sec) throws Exception {
        try {
            AutenticacaoRecord seguranca = new AutenticationService("http://localhost:8081", sec).validarToken();
//            List<VagaRecord> vagaRecord = vagaService.findList().stream().map(this::converterVaga).toList();
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            throw new Exception("Erro ao obter por id pelo seguinte motivo: " + (e.getLocalizedMessage() != null ? e.getLocalizedMessage(): ""));
        }
    }
}
