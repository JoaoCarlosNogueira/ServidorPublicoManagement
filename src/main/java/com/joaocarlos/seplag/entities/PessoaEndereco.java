package com.joaocarlos.seplag.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@IdClass(PessoaEnderecoId.class)
public class PessoaEndereco {

    @Id
    @Column(name = "pes_id")
    private Integer pesId;

    @Id
    @Column(name = "end_id")
    private Integer endId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pes_id", referencedColumnName = "pesId", insertable = false, updatable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "end_id", referencedColumnName = "endId", insertable = false, updatable = false)
    private Endereco endereco;
}