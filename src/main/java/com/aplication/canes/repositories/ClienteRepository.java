package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.ClienteEntitie;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntitie, Integer >{

}
