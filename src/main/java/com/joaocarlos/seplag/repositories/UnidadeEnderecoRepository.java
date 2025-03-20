package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.entities.UnidadeEndereco;
import com.joaocarlos.seplag.entities.UnidadeEnderecoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeEnderecoRepository extends JpaRepository<UnidadeEndereco, UnidadeEnderecoId> {
}
