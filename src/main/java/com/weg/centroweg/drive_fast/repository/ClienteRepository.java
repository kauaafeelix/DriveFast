package com.weg.centroweg.drive_fast.repository;

import com.weg.centroweg.drive_fast.model.Cliente;
import com.weg.centroweg.drive_fast.projection.ClienteGastoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = """
        SELECT c.nome AS nomeCliente , SUM(l.valor_total) AS totalGasto
        FROM clientes c 
        JOIN locacoes l ON l.cliente_id = c.id
        GROUP BY c.id, c.nome       
        """, nativeQuery = true)
    List<ClienteGastoProjection> findRelatorioGastos();
}
