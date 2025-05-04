package com.aplication.canes.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aplication.canes.entities.FornecedorEntitie;
import com.aplication.canes.services.FornecedorService;


@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResouce {

    @Autowired
    private FornecedorService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){

        List<FornecedorEntitie> obj = service.findAll();
        return ResponseEntity.ok().body(obj);        
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id){

        FornecedorEntitie obj = service.findById(id);
        return ResponseEntity.ok().body(obj);        
    }
}
