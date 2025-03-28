package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.dto.EnderecoDTO;
import com.joaocarlos.seplag.dto.ServidorDTO;
import com.joaocarlos.seplag.entities.ServidorEfetivo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("SELECT new com.joaocarlos.seplag.dto.EnderecoDTO(" +
            "e.endTipoLogradouro, e.endLogradouro, e.endNumero, e.endBairro, c.cidNome, c.cidUf) " +
            "FROM ServidorEfetivo s " +
            "JOIN Lotacao l ON s.pessoa.pesId = l.pessoa.pesId " +
            "JOIN UnidadeEndereco ue ON ue.unidade.unidId = l.unidade.unidId " +
            "JOIN Endereco e ON ue.endereco.endId = e.endId " +
            "JOIN Cidade c ON e.cidade.cidId = c.cidId " +
            "WHERE LOWER(s.pessoa.pesNome) LIKE LOWER(CONCAT('%', :nomeParte, '%'))")
    Page<EnderecoDTO> findEnderecoByNome(@Param("nomeParte") String nomeParte, Pageable pageable);

}
