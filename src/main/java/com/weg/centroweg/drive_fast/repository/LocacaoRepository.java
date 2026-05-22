package com.weg.centroweg.drive_fast.repository;

import com.weg.centroweg.drive_fast.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    @Query("SELECT l FROM Locacao l WHERE l.cliente.id = :clienteId")
    List<Locacao> findByClienteId (@Param("clienteId") Long clienteId);
}
