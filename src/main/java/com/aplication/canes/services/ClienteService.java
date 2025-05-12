package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.canes.entities.ClienteEntitie;
import com.aplication.canes.repositories.ClienteRepository;
import com.aplication.canes.services.exceptions.ResourceNotFoundEXception;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public List<ClienteEntitie> findAll(){

        return repo.findAll();
    }

    public ClienteEntitie findById(Integer id){

       Optional<ClienteEntitie> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundEXception("Usuario com ID "+ id +" não encontrado."));
    }

    public void insert(ClienteEntitie obj){

         repo.save(obj);
    }

    public void deleteById(Integer id){
        
        findById(id);

        repo.deleteById(id);
    }
}
