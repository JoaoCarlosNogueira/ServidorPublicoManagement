package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ServidorEfetivo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long servidorEfetivoid;

    @OneToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    private String seMatricula;

}