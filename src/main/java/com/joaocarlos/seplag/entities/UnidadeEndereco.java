package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UnidadeEndereco {

    @EmbeddedId
    private UnidadeEnderecoId id;

    @ManyToOne
    @JoinColumn(name = "unidId", insertable = false, updatable = false)
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "endId", insertable = false, updatable = false)
    private Endereco endereco;
}