package com.aplication.canes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.PedidoEntitie;

@Repository
public interface PedidoRepository extends  JpaRepository<PedidoEntitie, Integer>{

// @Query("SELECT p FROM PedidoEntitie p "+" WHERE LOWER(p.cliente.nome) LIKE LOWER(CONCAT('%', :termo, '%'))"+" OR LOWER(p.cliente.telefones.numero) LIKE LOWER(CONCAT('%', :termo, '%')) "+" OR CAST(p.id) = :termo")
@Query("SELECT p FROM PedidoEntitie p "+" LEFT JOIN p.cliente.telefones t " +"  WHERE LOWER (p.cliente.nome)  LIKE LOWER (CONCAT('%', :termo ,'%')) "+" OR CAST(p.id AS string) = :termo "+" OR t.numero LIKE CONCAT('%', :termo, '%') "+" ORDER BY p.data")
List<PedidoEntitie>findByPedidos(@Param("termo") String termo); 

}
