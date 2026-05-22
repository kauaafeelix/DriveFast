package com.weg.centroweg.drive_fast.service;

import com.weg.centroweg.drive_fast.dto.veiculo.VeiculoCreateDto;
import com.weg.centroweg.drive_fast.dto.veiculo.VeiculoResponseDto;
import com.weg.centroweg.drive_fast.dto.veiculo.VeiculoUpdateDto;
import com.weg.centroweg.drive_fast.mapper.VeiculoMapper;
import com.weg.centroweg.drive_fast.model.Veiculo;
import com.weg.centroweg.drive_fast.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;
    private final VeiculoMapper mapper;

    public VeiculoService(VeiculoRepository repository, VeiculoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public VeiculoResponseDto criarVeiculo (VeiculoCreateDto create){

        Veiculo veiculo = mapper.toEntity(create);

        repository.save(veiculo);

        return mapper.toDto(veiculo);
    }

    public List<VeiculoResponseDto> listarVeiculos (){

        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public VeiculoResponseDto buscarPorId (Long id){

        Veiculo veiculo = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O Veiculo não existe"));

        return mapper.toDto(veiculo);
    }

    public VeiculoResponseDto atualizarValorDaDiaria (Long id, VeiculoUpdateDto update){

        Veiculo veiculo = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O Veiculo não existe"));

        veiculo.setValorDiaria(update.valorDiaria());

        repository.save(veiculo);

        return mapper.toDto(veiculo);
    }

    public void deletarVeiculo (Long id){
        Veiculo veiculo = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O Veiculo não existe"));

        repository.deleteById(id);
    }

    public List<VeiculoResponseDto> listarVeiculosDisponiveis(){

         return repository.findByDisponivel(true)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
