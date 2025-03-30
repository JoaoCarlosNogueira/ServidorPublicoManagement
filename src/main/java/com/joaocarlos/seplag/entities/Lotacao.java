package com.joaocarlos.seplag.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lotId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "unid_id")
    private Unidade unidade;

    private Date lotDataLotacao;
    private Date lotDataRemocao;
    private String lotPortaria;
}