package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.TelefoneEntitie;

@Repository
public interface TelefoneRepository extends JpaRepository <TelefoneEntitie, Integer>{

}
