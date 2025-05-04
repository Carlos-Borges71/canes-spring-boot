package com.aplication.canes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.canes.entities.FornecedorEntitie;
import com.aplication.canes.repositories.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repo;

    public List<FornecedorEntitie> findAll(){
        
        return repo.findAll();
    }

    public FornecedorEntitie findById(Integer id){

        Optional<FornecedorEntitie> obj = repo.findById(id);
		return obj.get();
    }
}
