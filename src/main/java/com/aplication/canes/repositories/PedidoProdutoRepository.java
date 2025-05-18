package com.aplication.canes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplication.canes.entities.PedidoProduto;
import com.aplication.canes.entities.pk.PedidoProdutoPK;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, PedidoProdutoPK> {

}
