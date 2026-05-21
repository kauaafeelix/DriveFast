package com.weg.centroweg.drive_fast.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private BigDecimal valorDiaria;

    private Boolean disponivel;

    @PrePersist
    public void prePersist(){
        if (this.disponivel == null){
            this.disponivel = true;
        }
    }

    public Veiculo(String marca, String modelo, String placa, BigDecimal valorDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
    }
}
