package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.aplication.canes.entities.OperadorCliente;
import com.aplication.canes.entities.pk.OperadorClientePK;
import com.aplication.canes.repositories.OperadorClienteRepository;
import com.aplication.canes.services.exceptions.DataBaseException;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OperadorClienteService {

    @Autowired
    private OperadorClienteRepository repo;

    public List<OperadorCliente> findAll(){

        return repo.findAll();
    }

    public OperadorCliente findById(OperadorClientePK id){
        
        Optional<OperadorCliente> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception(id));
    }

    public OperadorCliente insert(OperadorCliente obj){

        try {

         return repo.save(obj);

        }catch(ConstraintViolationException e) {

            throw new ResourceNotFoundEXception(e.getMessage());

        }catch(HttpMessageNotReadableException e){

            throw new ResourceNotFoundEXception(e.getMessage());
        }
    }

    public void deleteById(OperadorClientePK id){

        findById(id);

        try{

        repo.deleteById(id); 
        }catch(DataIntegrityViolationException e){

            throw new DataBaseException(id);
        }
      
    }

    public OperadorCliente update(OperadorClientePK id, OperadorCliente obj) {

        try{
        OperadorCliente entity = repo.getReferenceById(id);

        updateData(entity, obj);

        return repo.save(entity);

        }catch(EntityNotFoundException e) {

            throw new ResourceNotFoundEXception(id);

        }catch(TransactionSystemException e){

            throw new DataBaseException(id);
        }
        
    }

    private void updateData(OperadorCliente entity, OperadorCliente obj){

        entity.setId(obj.getId());;  
                
        }

}    
        
    