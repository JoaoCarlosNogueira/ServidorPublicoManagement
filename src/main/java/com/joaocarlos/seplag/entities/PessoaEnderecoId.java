package com.joaocarlos.seplag.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PessoaEnderecoId implements Serializable {

    private Integer pessoaId;
    private Integer enderecoId;

    public PessoaEnderecoId() {}

    public PessoaEnderecoId(Integer pessoaId, Integer enderecoId) {
        this.pessoaId = pessoaId;
        this.enderecoId = enderecoId;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaEnderecoId that = (PessoaEnderecoId) o;
        return pessoaId.equals(that.pessoaId) && enderecoId.equals(that.enderecoId);
    }

    @Override
    public int hashCode() {
        return pessoaId.hashCode() + enderecoId.hashCode();
    }
}
