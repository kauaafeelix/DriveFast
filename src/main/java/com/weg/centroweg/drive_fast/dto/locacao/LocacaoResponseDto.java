package com.weg.centroweg.drive_fast.dto.locacao;

import com.weg.centroweg.drive_fast.dto.cliente.ClienteResponseDto;
import com.weg.centroweg.drive_fast.dto.veiculo.VeiculoResponseDto;

public record LocacaoResponseDto(
        Long id,
        Integer dias,
        String nomeCliente,
        String nomeVeiculo
) {
}
