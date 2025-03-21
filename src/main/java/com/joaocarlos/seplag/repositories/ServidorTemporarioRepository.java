package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.entities.ServidorTemporario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorTemporarioRepository  extends JpaRepository<ServidorTemporario,Integer> {
}
