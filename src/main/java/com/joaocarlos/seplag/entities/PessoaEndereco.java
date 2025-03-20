package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PessoaEndereco {

    @EmbeddedId
    private PessoaEnderecoId id;

    @ManyToOne
    @JoinColumn(name = "pes_id", insertable = false, updatable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "end_id", insertable = false, updatable = false)
    private Endereco endereco;
}