package br.com.mike.vaga.repository;

import br.com.mike.vaga.dao.IVaga;
import br.com.mike.vaga.modelo.Vaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VagaService {

    @Autowired(required = true)
    private IVaga iVaga;

    public Vaga findById(String id){
        return iVaga.findById(id).orElse(null);
    }

    public List<Vaga> findList(){
        return iVaga.findAll();
    }

    public Vaga manter(Vaga vaga){
        vaga.setId(UUID.randomUUID().toString());
        return iVaga.save(vaga);
    }

    public Vaga alterar(Vaga vaga) throws Exception {
        Vaga entity = iVaga.findById(vaga.getId()).orElse(null);
        if(entity != null){
            entity.setDescricao(vaga.getDescricao());
            entity.setRequisitos(vaga.getRequisitos());
            entity.setTitulo(vaga.getTitulo());
            return iVaga.save(vaga);
        }else{
            throw new Exception("Erro ao alterar Vaga pelo seguinte motivo: Vaga não encontrada");
        }
    }

    public void excluir(Vaga vaga){
        iVaga.delete(vaga);
    }
}
