package com.weg.centroweg.drive_fast.mapper;

import com.weg.centroweg.drive_fast.dto.cliente.ClienteCreateDto;
import com.weg.centroweg.drive_fast.dto.cliente.ClienteResponseDto;
import com.weg.centroweg.drive_fast.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity (ClienteCreateDto create){
        return new Cliente(
                create.nome(),
                create.email(),
                create.cnh()
        );
    }

    public ClienteResponseDto toDto(Cliente cliente){
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCnh(),
                cliente.getEmail()
        );
    }
}
