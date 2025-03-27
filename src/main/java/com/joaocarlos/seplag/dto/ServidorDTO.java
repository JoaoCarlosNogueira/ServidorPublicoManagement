package com.joaocarlos.seplag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ServidorDTO{
    private String nome;
    private Integer idade;
    private String unidade;
    private String fotografia;
    private Date dataNascimento;

    public ServidorDTO(String nome,int idade ,Date dataNascimento, String unidade, String fotografia) {
        this.nome = nome;
        this.idade = idade;
        this.unidade = unidade;
        this.fotografia = fotografia;
        this.dataNascimento = dataNascimento;
    }

    public ServidorDTO(String nome,Date dataNascimento, String unidade, String fotografia) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.unidade = unidade;
        this.fotografia = fotografia;
    }

}
