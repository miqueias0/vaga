package br.com.mike.vaga.dao;

import br.com.mike.vaga.modelo.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVaga extends JpaRepository<Vaga, String> {

}
