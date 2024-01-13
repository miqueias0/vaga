package br.com.mike.vaga.record;

import java.util.List;

public record VagaRecord(String id, String titulo, String descricao, List<String> requisitos) {
}
