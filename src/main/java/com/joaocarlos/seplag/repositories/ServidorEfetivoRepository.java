package com.joaocarlos.seplag.repositories;

import com.joaocarlos.seplag.entities.ServidorEfetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo,Integer> {
}
