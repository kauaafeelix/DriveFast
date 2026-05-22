package com.weg.centroweg.drive_fast.dto.veiculo;

import java.math.BigDecimal;

public record VeiculoCreateDto(
        String marca,
        String modelo,
        String placa,
        BigDecimal valorDiaria
) {
}
