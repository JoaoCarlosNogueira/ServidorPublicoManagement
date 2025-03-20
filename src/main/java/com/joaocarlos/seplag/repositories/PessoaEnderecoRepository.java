package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.entities.PessoaEndereco;
import com.joaocarlos.seplag.entities.PessoaEnderecoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, PessoaEnderecoId> {
}
