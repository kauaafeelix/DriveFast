package com.weg.centroweg.drive_fast.service;

import com.weg.centroweg.drive_fast.dto.cliente.ClienteCreateDto;
import com.weg.centroweg.drive_fast.dto.cliente.ClienteResponseDto;
import com.weg.centroweg.drive_fast.dto.cliente.ClienteUpdateDto;
import com.weg.centroweg.drive_fast.mapper.ClienteMapper;
import com.weg.centroweg.drive_fast.model.Cliente;
import com.weg.centroweg.drive_fast.projection.ClienteGastoProjection;
import com.weg.centroweg.drive_fast.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClienteResponseDto criarCliente (ClienteCreateDto create){

        Cliente cliente = mapper.toEntity(create);

        repository.save(cliente);

        return mapper.toDto(cliente);
    }

    public List<ClienteResponseDto> listarClientes (){

        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ClienteResponseDto buscarPorId (Long id){

        Cliente cliente = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O Cliente não existe"));

        return mapper.toDto(cliente);
    }

    public ClienteResponseDto atualizarPorId (Long id, ClienteUpdateDto update){

        Cliente cliente = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O Cliente não existe"));

        cliente.setNome(update.nome());
        cliente.setEmail(update.email());

        repository.save(cliente);

        return mapper.toDto(cliente);
    }

    public void deletarCliente (Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O Cliente não existe"));

        repository.deleteById(id);
    }

    public List<ClienteGastoProjection> relatorioGastos() {
        return repository.findRelatorioGastos();
    }
}
