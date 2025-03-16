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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unidadeEnderecoid;

    @ManyToOne
    @JoinColumn(name = "unid_id")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "end_id")
    private Endereco endereco;
}