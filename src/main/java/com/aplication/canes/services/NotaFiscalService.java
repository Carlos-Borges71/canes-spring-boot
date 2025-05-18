package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.aplication.canes.entities.NotaFiscalEntitie;
import com.aplication.canes.repositories.NotaFiscalRepository;
import com.aplication.canes.services.exceptions.DataBaseException;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NotaFiscalService {

     @Autowired
    private NotaFiscalRepository repo;

    public List<NotaFiscalEntitie> findAll(){

        return repo.findAll();
    }

    public NotaFiscalEntitie findById(Integer id){
        
        Optional<NotaFiscalEntitie> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception(id));
    }

    public NotaFiscalEntitie insert(NotaFiscalEntitie obj){

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

    public NotaFiscalEntitie update(Integer id, NotaFiscalEntitie obj) {

        try{
        NotaFiscalEntitie entity = repo.getReferenceById(id);

        updateData(entity, obj);

        return repo.save(entity);

        }catch(EntityNotFoundException e) {

            throw new ResourceNotFoundEXception(id);

        }catch(TransactionSystemException e){

            throw new DataBaseException(id);
        }
        
    }

    private void updateData(NotaFiscalEntitie entity, NotaFiscalEntitie obj){

        entity.setNotaFiscal(obj.getNotaFiscal());
        entity.setData(obj.getData());
        entity.setFornecedor(obj.getFornecedor());        
        
        }
}
