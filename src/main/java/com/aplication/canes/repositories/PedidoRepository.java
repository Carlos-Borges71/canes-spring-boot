package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.PedidoEntitie;

@Repository
public interface PedidoRepository extends  JpaRepository<PedidoEntitie, Integer>{

}
