package com.weg.centroweg.drive_fast.dto.locacao;

public record LocacaoRequestDto(
        Integer dias,
        Long clienteId,
        Long veiculoId
) {
}
