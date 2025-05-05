package com.aplication.canes.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aplication.canes.entities.UsuarioEntitie;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntitie, Integer>{

}
