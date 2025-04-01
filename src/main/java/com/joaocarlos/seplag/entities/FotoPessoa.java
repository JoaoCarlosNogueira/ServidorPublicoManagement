package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FotoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fpId;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    private Date fpData;
    private String fpBucket;
    private String fpHash;
    
}