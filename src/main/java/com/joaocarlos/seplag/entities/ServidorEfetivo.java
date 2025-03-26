package com.joaocarlos.seplag.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaocarlos.seplag.dto.ServidorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServidorEfetivo {
    @Id
    private Integer pesId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    private String seMatricula;

}