package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@IdClass(UnidadeEnderecoId.class)
public class UnidadeEndereco {

    @Id
    @Column(name = "unid_id")
    private Integer unidId;

    @Id
    @Column(name = "end_id")
    private Integer endId;

    @ManyToOne
    @JoinColumn(name = "unid_id", referencedColumnName = "unidId", insertable = false, updatable = false)
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "end_id", referencedColumnName = "endId", insertable = false, updatable = false)
    private Endereco endereco;
}