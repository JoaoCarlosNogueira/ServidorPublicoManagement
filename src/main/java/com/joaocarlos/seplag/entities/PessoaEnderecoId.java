package com.joaocarlos.seplag.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

public class PessoaEnderecoId implements Serializable {
    private Integer pesId;
    private Integer endId;

    public PessoaEnderecoId() {}

    public PessoaEnderecoId(Integer pesId, Integer endId) {
        this.pesId = pesId;
        this.endId = endId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaEnderecoId that = (PessoaEnderecoId) o;
        return Objects.equals(pesId, that.pesId) && Objects.equals(endId, that.endId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesId, endId);
    }
}
