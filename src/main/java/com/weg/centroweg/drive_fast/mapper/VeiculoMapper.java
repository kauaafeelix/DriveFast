package com.weg.centroweg.drive_fast.mapper;

import com.weg.centroweg.drive_fast.dto.veiculo.VeiculoCreateDto;
import com.weg.centroweg.drive_fast.dto.veiculo.VeiculoResponseDto;
import com.weg.centroweg.drive_fast.model.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {

    public Veiculo toEntity (VeiculoCreateDto create){
        return new Veiculo(
                create.marca(),
                create.modelo(),
                create.placa(),
                create.valorDiaria()
        );
    }

    public VeiculoResponseDto toDto (Veiculo veiculo){

        return new VeiculoResponseDto(
                veiculo.getId(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getPlaca(),
                veiculo.getValorDiaria()
        );
    }
}
