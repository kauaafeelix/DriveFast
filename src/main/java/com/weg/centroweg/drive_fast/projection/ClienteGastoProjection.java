package com.weg.centroweg.drive_fast.projection;

import java.math.BigDecimal;

public record ClienteGastoProjection(
        String getNomeCliente,
        BigDecimal getValorTotalGasto
) {
}
