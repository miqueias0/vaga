package br.com.mike.vaga.controller;

import br.com.mike.comum.records.AutenticacaoRecord;
import br.com.mike.comum.records.CandidaturaRecord;
import br.com.mike.comum.records.MensagemRetorno;
import br.com.mike.comum.service.AutenticationService;
import br.com.mike.comum.service.CandidaturaService;
import br.com.mike.vaga.modelo.Vaga;
import br.com.mike.vaga.record.VagaRecord;
import br.com.mike.vaga.repository.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vaga")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @GetMapping(value = "/obterLista")
    @CrossOrigin("*")
    public ResponseEntity<List<VagaRecord>> obterLista(@RequestHeader HttpHeaders sec) throws Exception {
        try {
            AutenticacaoRecord seguranca = new AutenticationService(sec).validarToken();
            List<VagaRecord> vagasRecord = vagaService.findList().stream().map(this::converterVaga).toList();
            return ResponseEntity.ok().body(vagasRecord);
        } catch (Exception e) {
            throw new Exception("Erro ao obter lista pelo seguinte motivo: " + (e.getLocalizedMessage() != null ? e.getLocalizedMessage() : ""));
        }
    }

    @GetMapping(value = "/obterPorId")
    @CrossOrigin("*")
    public ResponseEntity<VagaRecord> obterPorId(@RequestHeader HttpHeaders sec, @RequestParam("id") String id) throws Exception {
        try {
            AutenticacaoRecord seguranca = new AutenticationService(sec).validarToken();
            VagaRecord vagaRecord = converterVaga(vagaService.findById(id));
            return ResponseEntity.ok().body(vagaRecord);
        } catch (Exception e) {
            throw new Exception("Erro ao obter por id pelo seguinte motivo: " + (e.getLocalizedMessage() != null ? e.getLocalizedMessage() : ""));
        }
    }

    @PostMapping(value = "/manter")
    @CrossOrigin("*")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<VagaRecord> obterLista(@RequestHeader HttpHeaders sec, @RequestBody VagaRecord vagaRecord) throws Exception {
        try {
            AutenticacaoRecord seguranca = new AutenticationService(sec).validarToken();
            Vaga vaga = converterVagaRecord(vagaRecord);
            vaga.setContratanteId(seguranca.identificador());
            vagaRecord = converterVaga(vagaService.manter(vaga));
            
            return ResponseEntity.ok().body(vagaRecord);
        } catch (Exception e) {
            
            throw new Exception("Erro ao criar pelo seguinte motivo: " + (e.getLocalizedMessage() != null ? e.getLocalizedMessage() : ""));
        }
    }

    @PostMapping(value = "/alterar")
    @CrossOrigin("*")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<VagaRecord> alterar(@RequestHeader HttpHeaders sec, @RequestBody VagaRecord vagaRecord) throws Exception {
        try {
            AutenticacaoRecord seguranca = new AutenticationService(sec).validarToken();

            vagaRecord = converterVaga(vagaService.alterar(converterVagaRecord(vagaRecord)));
            
            return ResponseEntity.ok().body(vagaRecord);
        } catch (Exception e) {
            
            throw new Exception("Erro ao alterar vaga pelo seguinte motivo: " + (e.getLocalizedMessage() != null ? e.getLocalizedMessage() : ""));
        }
    }

    @PostMapping(value = "/excluir")
    @CrossOrigin("*")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<MensagemRetorno> excluir(@RequestHeader HttpHeaders sec, @RequestBody VagaRecord vagaRecord) throws Exception {
        try {
            AutenticacaoRecord seguranca = new AutenticationService(sec).validarToken();
            vagaService.excluir(converterVagaRecord(vagaRecord));
            return ResponseEntity.ok().body(new MensagemRetorno("Sucesso"));
        } catch (Exception e) {
            throw new Exception("Erro ao excluir vaga pelo seguinte motivo: " + (e.getLocalizedMessage() != null ? e.getLocalizedMessage() : ""));
        }
    }


    private VagaRecord converterVaga(Vaga vaga) {
        return new VagaRecord(vaga.getId(), vaga.getTitulo(), vaga.getDescricao(), vaga.getRequisitos());
    }

    private Vaga converterVagaRecord(VagaRecord vagaRecord) {
        Vaga vaga = new Vaga();
        vaga.setId(vagaRecord.id());
        vaga.setDescricao(vagaRecord.descricao());
        vaga.setRequisitos(vagaRecord.requisitos());
        vaga.setTitulo(vagaRecord.titulo());
        return vaga;
    }

}
