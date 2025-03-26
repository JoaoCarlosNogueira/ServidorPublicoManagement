package com.joaocarlos.seplag.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

public class UnidadeEnderecoId implements Serializable {
    private Integer unidId;
    private Integer endId;

    public UnidadeEnderecoId() {}

    public UnidadeEnderecoId(Integer unidId, Integer endId) {
        this.unidId = unidId;
        this.endId = endId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadeEnderecoId that = (UnidadeEnderecoId) o;
        return Objects.equals(unidId, that.unidId) && Objects.equals(endId, that.endId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unidId, endId);
    }
}
