package com.weg.centroweg.drive_fast.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cnh;

    @Column(nullable = false)
    private String email;


    public Cliente(String nome, String cnh, String email) {
        this.nome = nome;
        this.cnh = cnh;
        this.email = email;
    }
}
