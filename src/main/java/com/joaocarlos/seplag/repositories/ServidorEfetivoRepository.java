package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.dto.EnderecoDTO;
import com.joaocarlos.seplag.dto.ServidorDTO;
import com.joaocarlos.seplag.entities.ServidorEfetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo,Integer> {

    @Query("SELECT new com.joaocarlos.seplag.dto.ServidorDTO(" +
            "s.pessoa.pesNome, s.pessoa.pesDataNascimento, u.unidNome, f.fpHash) " +
            "FROM ServidorEfetivo s " +
            "JOIN Lotacao l ON s.pessoa.pesId = l.pessoa.pesId " +
            "JOIN Unidade u ON l.unidade.unidId = u.unidId " +
            "LEFT JOIN FotoPessoa f ON f.pessoa.pesId = s.pessoa.pesId " +
            "WHERE u.unidId = :unidId")
    List<ServidorDTO> findServidoresByUnidade(@Param("unidId") Integer unidId);
}
