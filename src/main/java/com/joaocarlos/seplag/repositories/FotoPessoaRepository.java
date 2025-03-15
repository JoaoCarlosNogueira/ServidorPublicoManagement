package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.entities.FotoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoPessoaRepository extends JpaRepository<FotoPessoa,Long> {
}
