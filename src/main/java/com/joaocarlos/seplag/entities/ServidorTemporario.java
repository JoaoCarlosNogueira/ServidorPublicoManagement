package com.joaocarlos.seplag.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    @OneToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    private Date stDataAdmissao;
    private Date stDataDemissao;
}