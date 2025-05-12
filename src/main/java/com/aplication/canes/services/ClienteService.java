package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.aplication.canes.entities.ClienteEntitie;
import com.aplication.canes.repositories.ClienteRepository;
import com.aplication.canes.services.exceptions.DataBaseException;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

     @Autowired
    private ClienteRepository repo;

    public List<ClienteEntitie> findAll(){

        return repo.findAll();
    }

    public ClienteEntitie findById(Integer id){
        
        Optional<ClienteEntitie> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception(id));
    }

    public ClienteEntitie insert(ClienteEntitie obj){

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

    public ClienteEntitie update(Integer id, ClienteEntitie obj) {

        try{
        ClienteEntitie entity = repo.getReferenceById(id);

        updateData(entity, obj);

        return repo.save(entity);

        }catch(EntityNotFoundException e) {

            throw new ResourceNotFoundEXception(id);

        }catch(TransactionSystemException e){

            throw new DataBaseException(id);
        }
        
    }

    private void updateData(ClienteEntitie entity, ClienteEntitie obj){

        entity.setNome(obj.getNome());
        entity.setInstante(obj.getInstante());        
        
        }


}

