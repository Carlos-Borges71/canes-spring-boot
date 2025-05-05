package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.aplication.canes.repositories.UsuarioRepository;
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

        return obj.get();
    }

    public void deleteById(Integer id){

        if (!repo.existsById(id)){

            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }

        repo.deleteById(id);
        
      

    }


}
