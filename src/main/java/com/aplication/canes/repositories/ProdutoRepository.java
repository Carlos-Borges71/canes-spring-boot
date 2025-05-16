package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.ProdutoEntitie;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntitie , Integer>{

}
