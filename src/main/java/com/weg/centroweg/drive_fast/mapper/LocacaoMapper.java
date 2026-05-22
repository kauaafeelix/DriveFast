package com.weg.centroweg.drive_fast.mapper;

import com.weg.centroweg.drive_fast.dto.locacao.LocacaoRequestDto;
import com.weg.centroweg.drive_fast.dto.locacao.LocacaoResponseDto;
import com.weg.centroweg.drive_fast.model.Locacao;
import org.springframework.stereotype.Component;

@Component
public class LocacaoMapper {

    public Locacao toEntity (LocacaoRequestDto request){
        return new Locacao(
                request.dias()
        );
    }

    public LocacaoResponseDto toDto(Locacao locacao){
        return new LocacaoResponseDto(
                locacao.getId(),
                locacao.getDias(),
                locacao.getCliente().getNome(),
                locacao.getVeiculo().getMarca()
        );
    }
}
