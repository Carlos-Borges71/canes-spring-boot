package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.aplication.canes.entities.ProdutoEntitie;
import com.aplication.canes.entities.dto.ProdutoDPO;
import com.aplication.canes.repositories.ProdutoRepository;
import com.aplication.canes.services.exceptions.DataBaseException;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    public List<ProdutoDPO> findAll(){

        List<ProdutoEntitie> produtos = repo.findAll();

        return produtos.stream().map(ProdutoDPO::new).collect(Collectors.toList());
    }

    public ProdutoEntitie findById(Integer id){
        
        Optional<ProdutoEntitie> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception(id));
    }

    public ProdutoEntitie insert(ProdutoEntitie obj){

        try {

         return repo.save(obj);

        }catch(ConstraintViolationException e) {

            throw new ResourceNotFoundEXception(e.getMessage());

        }catch(HttpMessageNotReadableException e){

            throw new ResourceNotFoundEXception(e.getMessage());
        }
    }

    public void deleteById(Integer id){

        findById(id);

        try{

        repo.deleteById(id); 
        }catch(DataIntegrityViolationException e){

            throw new DataBaseException(id);
        }
      
    }

    public ProdutoEntitie update(Integer id, ProdutoEntitie obj) {

        try{
        ProdutoEntitie entity = repo.getReferenceById(id);

        updateData(entity, obj);

        return repo.save(entity);

        }catch(EntityNotFoundException e) {

            throw new ResourceNotFoundEXception(id);

        }catch(TransactionSystemException e){

            throw new DataBaseException(id);
        }
        
    }

    private void updateData(ProdutoEntitie entity, ProdutoEntitie obj){

        entity.setNome(obj.getNome());
        entity.setCodigo(obj.getCodigo());
        entity.setEstoque(obj.getEstoque());
        entity.setValorCompra(obj.getValorCompra());
        entity.setQuantcompra(obj.getQuantcompra());
        entity.setValorVenda(obj.getValorVenda());       
        
        }


}

