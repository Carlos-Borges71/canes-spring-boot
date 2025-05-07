package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.canes.entities.ClienteEntitie;
import com.aplication.canes.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public List<ClienteEntitie> findAll(){

        return repo.findAll();
    }

    public ClienteEntitie findById(Integer id){

        Optional<ClienteEntitie> obj = repo.findById(id);

        return obj.get();
    }

    public void insert(ClienteEntitie obj){

         repo.save(obj);
    }

    public void deleteById(Integer id){
        if(!repo.existsById(id)){

            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }

        repo.deleteById(id);
    }
}
