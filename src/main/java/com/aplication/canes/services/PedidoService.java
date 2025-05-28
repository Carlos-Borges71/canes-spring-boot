package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.aplication.canes.entities.PedidoEntitie;
import com.aplication.canes.repositories.PedidoRepository;
import com.aplication.canes.services.exceptions.DataBaseException;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @PersistenceContext
    private EntityManager entityManager;

    public List<?>findPerson(String name){

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("get_pedidos_by_name").registerStoredProcedureParameter("pedidos_name", String.class, ParameterMode.IN).setParameter("pedidos_name", name);
        
        return query.getResultList();
    }

    public List<PedidoEntitie> findByPedidos(String termo){

        return repo.findByPedidos(termo);
    }

    public List<PedidoEntitie> findAll(){

        return repo.findAll();
    }

    public PedidoEntitie findById(Integer id){
        
        Optional<PedidoEntitie> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception(id));
    }

    public PedidoEntitie insert(PedidoEntitie obj){

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

    public PedidoEntitie update(Integer id, PedidoEntitie obj) {

        try{
        PedidoEntitie entity = repo.getReferenceById(id);

        updateData(entity, obj);

        return repo.save(entity);

        }catch(EntityNotFoundException e) {

            throw new ResourceNotFoundEXception(id);

        }catch(TransactionSystemException e){

            throw new DataBaseException(id);
        }
        
    }

    private void updateData(PedidoEntitie entity, PedidoEntitie obj){

        entity.setStatus(obj.getStatus());
        entity.setData(obj.getData());
        entity.setValor(obj.getValor());
        entity.setCliente(obj.getCliente());      
        
        }
}
