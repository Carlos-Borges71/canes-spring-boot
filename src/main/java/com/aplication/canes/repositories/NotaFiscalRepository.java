package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.NotaFiscalEntitie;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscalEntitie, Integer>{

}
