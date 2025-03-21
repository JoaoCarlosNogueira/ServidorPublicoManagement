package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pesId;

    private String pesNome;
    private Date pesDataNascimento;
    private String pesSexo;
    private String pesMae;
    private String pesPai;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<PessoaEndereco> enderecos;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, optional = true)
    private ServidorTemporario servidorTemporario;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL,optional = true)
    private ServidorEfetivo servidorEfetivo;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Lotacao> lotacoes;
}