package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lotId;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "unid_id")
    private Unidade unidade;

    private Date lotDataLotacao;
    private Date lotDataRemocao;
    private String lotPortaria;
}