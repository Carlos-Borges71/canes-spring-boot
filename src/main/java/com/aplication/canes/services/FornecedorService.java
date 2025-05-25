package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.aplication.canes.entities.FornecedorEntitie;
import com.aplication.canes.repositories.FornecedorRepository;
import com.aplication.canes.services.exceptions.DataBaseException;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repo;

   public List<FornecedorEntitie> findAll(){

        return repo.findAll();
    }

    public FornecedorEntitie findById(Integer id){
        
        Optional<FornecedorEntitie> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception(id));
    }

    public FornecedorEntitie insert(FornecedorEntitie obj){

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

    public FornecedorEntitie update(Integer id, FornecedorEntitie obj) {

        try{
        FornecedorEntitie entity = repo.getReferenceById(id);

        updateData(entity, obj);

        return repo.save(entity);

        }catch(EntityNotFoundException e) {

            throw new ResourceNotFoundEXception(id);

        }catch(TransactionSystemException e){

            throw new DataBaseException(id);
        }
        
    }

    private void updateData(FornecedorEntitie entity, FornecedorEntitie obj){

        entity.setEmpresa(obj.getEmpresa());
        entity.setCnpjCpf(obj.getCnpjCpf());
        entity.setEndereco(obj.getEndereco());
        
        }
}
