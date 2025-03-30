package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.entities.Unidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade,Integer> {
    Page<Unidade> findAll(Pageable pageable);
}
