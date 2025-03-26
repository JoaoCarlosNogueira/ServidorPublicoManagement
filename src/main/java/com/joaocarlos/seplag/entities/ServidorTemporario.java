package com.joaocarlos.seplag.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.persister.collection.mutation.UpdateRowsCoordinatorNoOp;

import java.util.Date;
import java.util.Locale;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServidorTemporario {

    @Id
    private Integer pesId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    private Date stDataAdmissao;
    private Date stDataDemissao;

}