package com.joaocarlos.seplag.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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

    @JsonProperty("pessoaId")
    public Integer getPessoaId() {
        return pessoa != null ? pessoa.getPesId() : null;
    }

    @JsonProperty("pessoaId")
    public void setPessoaId(Integer pessoaId) {
        if (pessoa == null) {
            pessoa = new Pessoa();
        }
        pessoa.setPesId(pessoaId);
    }

    @JsonProperty("unidadeId")
    public Integer getUnidadeId() {
        return unidade != null ? unidade.getUnidId() : null;
    }

    @JsonProperty("unidadeId")
    public void setUnidadeId(Integer unidadeId) {
        if (unidade == null) {
            unidade = new Unidade();
        }
        unidade.setUnidId(unidadeId);
    }
}