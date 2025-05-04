package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.FornecedorEntitie;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntitie, Integer> {

}
