package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.entities.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao,Integer> {
}
