package com.joaocarlos.seplag.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FotoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fpId;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    private Date fpData;
    private String fpBucket;
    private String fpHash;

    // Getters and Setters
}