package org.example.trackerdeatividade.repository;

import org.example.trackerdeatividade.dto.saida.DadosTarefa;
import org.example.trackerdeatividade.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<DadosTarefa> findByTitulo(String titulo);

    List<DadosTarefa> findByStatus(String status);
}
