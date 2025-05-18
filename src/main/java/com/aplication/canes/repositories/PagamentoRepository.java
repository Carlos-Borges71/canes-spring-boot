package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.PagamentoEntitie;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntitie, Integer>{

}
