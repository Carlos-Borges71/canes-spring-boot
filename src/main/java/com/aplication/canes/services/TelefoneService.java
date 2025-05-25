package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.aplication.canes.entities.TelefoneEntitie;
import com.aplication.canes.repositories.TelefoneRepository;
import com.aplication.canes.services.exceptions.DataBaseException;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TelefoneService {

     @Autowired
    private TelefoneRepository repo;

    public List<TelefoneEntitie> findAll(){

        return repo.findAll();
    }

    public TelefoneEntitie findById(Integer id){
        
        Optional<TelefoneEntitie> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception(id));
    }

    public TelefoneEntitie insert(TelefoneEntitie obj){

        
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

    public TelefoneEntitie update(Integer id, TelefoneEntitie obj) {

        findById(id);
        try{
        TelefoneEntitie entity = repo.getReferenceById(id);

        updateData(entity, obj);

        return repo.save(entity);

        }catch(EntityNotFoundException e) {

            throw new ResourceNotFoundEXception(id);

        }catch(TransactionSystemException e){

            throw new DataBaseException(id);
        }
        
    }

    private void updateData(TelefoneEntitie entity, TelefoneEntitie obj){

        entity.setNumero(obj.getNumero());
        entity.setCliente(obj.getCliente());
        entity.setFornecedor(obj.getFornecedor());
        entity.setOperador(obj.getOperador());     
        
        }


}

