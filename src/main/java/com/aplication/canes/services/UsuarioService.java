package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.aplication.canes.repositories.UsuarioRepository;
import com.aplication.canes.services.exceptions.DataBaseException;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

import jakarta.persistence.EntityNotFoundException;

import com.aplication.canes.entities.UsuarioEntitie;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<UsuarioEntitie> findAll(){

        return repo.findAll();
    }

    public UsuarioEntitie findById(Integer id){
        
        Optional<UsuarioEntitie> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception(id));
    }

    public UsuarioEntitie insert(UsuarioEntitie obj){

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

    public UsuarioEntitie update(Integer id, UsuarioEntitie obj) {

        try{
        UsuarioEntitie entity = repo.getReferenceById(id);

        updateData(entity, obj);

        return repo.save(entity);

        }catch(EntityNotFoundException e) {

            throw new ResourceNotFoundEXception(id);

        }catch(TransactionSystemException e){

            throw new DataBaseException(id);
        }
        
    }

    private void updateData(UsuarioEntitie entity, UsuarioEntitie obj){

        entity.setNome(obj.getNome());
        entity.setInstante(obj.getInstante());
        entity.setSetor(obj.getSetor());
        entity.setLogin(obj.getLogin());
        entity.setSenha(obj.getSenha());        
        }


}
