package com.joaocarlos.seplag.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UnidadeEnderecoId  implements Serializable {

    private Integer unidadeId;
    private Integer enderecoId;

    public UnidadeEnderecoId() {}

    public UnidadeEnderecoId(Integer unidadeId, Integer enderecoId) {
        this.unidadeId = unidadeId;
        this.enderecoId = enderecoId;
    }

    public Integer getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Integer unidadeId) {
        this.unidadeId = unidadeId;
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
        UnidadeEnderecoId that = (UnidadeEnderecoId) o;
        return unidadeId.equals(that.unidadeId) && enderecoId.equals(that.enderecoId);
    }

    @Override
    public int hashCode() {
        return unidadeId.hashCode() + enderecoId.hashCode();
    }
}
