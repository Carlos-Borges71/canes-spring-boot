package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.aplication.canes.entities.PedidoProduto;
import com.aplication.canes.entities.pk.PedidoProdutoPK;
import com.aplication.canes.repositories.PedidoProdutoRepository;
import com.aplication.canes.services.exceptions.DataBaseException;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoProdutoService {

    @Autowired
    private PedidoProdutoRepository repo;

    public List<PedidoProduto> findAll(){

        return repo.findAll();
    }

    public PedidoProduto findById(PedidoProdutoPK id){
        
        Optional<PedidoProduto> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception(id));
    }

    public PedidoProduto insert(PedidoProduto obj){

        try {

         return repo.save(obj);

        }catch(ConstraintViolationException e) {

            throw new ResourceNotFoundEXception(e.getMessage());

        }catch(HttpMessageNotReadableException e){

            throw new ResourceNotFoundEXception(e.getMessage());
        }
    }

    public void deleteById(PedidoProdutoPK id){

        findById(id);

        try{

        repo.deleteById(id); 
        }catch(DataIntegrityViolationException e){

            throw new DataBaseException(id);
        }
      
    }

    public PedidoProduto update(PedidoProdutoPK id, PedidoProduto obj) {

        try{
        PedidoProduto entity = repo.getReferenceById(id);

        updateData(entity, obj);

        return repo.save(entity);

        }catch(EntityNotFoundException e) {

            throw new ResourceNotFoundEXception(id);

        }catch(TransactionSystemException e){

            throw new DataBaseException(id);
        }
        
    }

    private void updateData(PedidoProduto entity, PedidoProduto obj){


        entity.setQuant(obj.getQuant());  
        
                
        }
}
