package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ServidorTemporario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servidorTemporarioid;

    @OneToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    private Date stDataAdmissao;
    private Date stDataDemissao;
}