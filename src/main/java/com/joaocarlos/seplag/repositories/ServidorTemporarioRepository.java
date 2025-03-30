package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.entities.ServidorTemporario;
import com.joaocarlos.seplag.entities.Unidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorTemporarioRepository  extends JpaRepository<ServidorTemporario,Integer> {
    Page<ServidorTemporario> findAll(Pageable pageable);
}
