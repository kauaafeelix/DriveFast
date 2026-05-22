package com.weg.centroweg.drive_fast.repository;

import com.weg.centroweg.drive_fast.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByDisponivel(Boolean disponivel);
}
