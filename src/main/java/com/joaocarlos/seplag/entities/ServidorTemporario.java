package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.persister.collection.mutation.UpdateRowsCoordinatorNoOp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ServidorTemporario {

    @Id
    private Integer pesId;

    @OneToOne
    @JoinColumn(name = "pes_id", nullable = false)
    private Pessoa pessoa;

    private Date stDataAdmissao;
    private Date stDataDemissao;
}