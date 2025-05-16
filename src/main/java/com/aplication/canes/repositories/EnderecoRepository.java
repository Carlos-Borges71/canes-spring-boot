package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.EnderecoEntitie;

@Repository
public interface EnderecoRepository extends JpaRepository <EnderecoEntitie, Integer>{

}
