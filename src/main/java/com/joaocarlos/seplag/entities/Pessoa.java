package com.joaocarlos.seplag.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonIgnore
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, optional = true)
    private ServidorTemporario servidorTemporario;

    @JsonIgnore
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, optional = true)
    private ServidorEfetivo servidorEfetivo;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lotacao> lotacoes;
}
