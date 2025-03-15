package com.joaocarlos.seplag.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UnidadeEndereco {
    @Id
    @ManyToOne
    @JoinColumn(name = "unid_id")
    private Unidade unidade;

    @Id
    @ManyToOne
    @JoinColumn(name = "end_id")
    private Endereco endereco;
}