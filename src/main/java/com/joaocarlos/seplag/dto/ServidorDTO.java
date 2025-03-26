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

    public ServidorDTO(String nome, Date dataNascimento, String unidade, String fotografia) {
        this.nome = nome;
        this.idade = calcularIdade(dataNascimento);
        this.unidade = unidade;
        this.fotografia = fotografia;
    }

    private int calcularIdade(Date dataNascimento) {
        if (dataNascimento == null) return 0;
        LocalDate nascimento = dataNascimento.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

}
