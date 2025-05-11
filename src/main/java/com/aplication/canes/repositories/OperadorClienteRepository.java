package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.OperadorCliente;
import com.aplication.canes.entities.pk.OperadorClientePK;

@Repository
public interface OperadorClienteRepository extends JpaRepository<OperadorCliente, OperadorClientePK>{

}
